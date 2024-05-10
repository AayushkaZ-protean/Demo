package com.protean.openfinance.utill;


import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.nsdl.beckn.api.model.common.Context;
import com.nsdl.beckn.api.model.common.Error;
import com.nsdl.beckn.api.model.common.FetchStatusRequestModel;
import com.nsdl.beckn.api.model.common.NackResponseModel;
import com.nsdl.beckn.api.model.common.Payment;
import com.nsdl.beckn.api.model.search.SearchMessage;
import com.protean.openfinance.dto.searchwrapper.SearchWrapperDto;
import com.protean.openfinance.entity.ApiAudit;
import com.protean.openfinance.exception.LenderException;
import com.protean.openfinance.service.wrappers.ApiAuditService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class OpenFinanceUtils {

    @Autowired
    //  @Qualifier("snakeCaseObjectMapper")
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("snakeCaseObjectMapper")
    private ObjectMapper snakeCaseObjectMapper;

    @Autowired
    private ApiAuditService apiAuditService;

    private String dirPath = "/wrapper/";

    @Value("${adaptor.v2.base-url}")
    public String baseUrl;

    @Value("${adaptor.v2.subscriber.id}")
    public String bapId;

    @Value("${adaptor.v2.subscriber.short-name}")
    public String shortName;

    @Value("${adaptor.v2.subscriber-url}")
    public String bapUri;


    public Context prepareContext(SearchWrapperDto searchWrapperDto) throws JsonProcessingException {

        String contextJson = readJsonFile(dirPath + "search/context.json");
        Context context = objectMapper.readValue(contextJson, Context.class);

        context.setBapId(bapId);
        context.setBapUri(bapUri);

        context.setTransactionId(searchWrapperDto.getTxId());
        context.setMessageId(String.valueOf(UUID.randomUUID()));
        return context;
    }

    public SearchMessage prepareSearchMessage(SearchWrapperDto searchWrapperDto) throws JsonProcessingException {

        String context = readJsonFile(dirPath + "search/search_message.json");
        SearchMessage message = objectMapper.readValue(context, SearchMessage.class);
        message.getIntent().getCategory().getDescriptor().setCode(searchWrapperDto.getLoanType());
        return message;
    }

    public String readJsonFile(String filePath) {
        Object inputJSON = JsonUtils.classpathToObject(filePath);
        return JsonUtils.toPrettyJsonString(inputJSON);
    }

    /*
     * Format the current date and time using the formatter
     * format - "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
     * */
    public String prepareCurrentDateTimeInZonedDatTime() {
        LocalDateTime currentDateTime = LocalDateTime.now(ZoneOffset.UTC);
        // Define a formatter for the desired date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        // Format the current date and time using the formatter
        return currentDateTime.format(formatter);
    }

    /**
     * @param formResponse - form response body {"submission_id" : "abc123"}
     * @return submissionId
     * JSONPath - $.submission_id
     */
    public String getSubmissionIdFromResponse(String formResponse){
        log.info("form response {}", formResponse);

        String submissionIdJsonPath ="$.submission_id";
        String submissionId = null;

        try {
            submissionId = JsonPath.parse(formResponse).read(submissionIdJsonPath);

        } catch (Exception e) {
            log.error("Error form response form submission_id {}", ExceptionUtils.getStackTrace(e));
            NackResponseModel nackResponseModel = new NackResponseModel();
            Error error = new Error();
            error.setType("Empty submission_id");
            error.setMessage("Submission Id does not exists");
            nackResponseModel.setError(error);

            throw new LenderException(nackResponseModel);
        }
        return submissionId;
    }

    public List<Payment> prepareInitOnePaymentTags() throws JsonProcessingException {

        String context = readJsonFile(dirPath + "init/init_payments.json");
        List<Payment> message = List.of(snakeCaseObjectMapper.readValue(context, Payment[].class));

        return message;
    }

    /**
     * for KBL trailing port number 8880 from BPP_URI
     * @param context
     * @return context
     */
    public Context handleKblBppUrl(Context context) {

        String bppUri = "https://ondcuatkbl.ignosis.ai:8880/lender-bridge/ondc/kbl-uat";
        //String bppUri = "https://ondcuatpahal.ignosis.ai:8880/lender-bridge/ondc/pahal";

        if (context.getBppUri().contains("kbl-uat")){
            //context.setBppUri(bppUri);
        }
        /*if (context.getBppUri().contains("ignosis")){
            context.setBppUri(bppUri);
        }*/
        return context;
    }

    public String getFormUrlFromInputForm(final String url) {

        String finalUrl = url;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(
                url,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseBody = response.getBody();
            log.info("form submission fetching URL by html {}", responseBody);
            // expanding on the example in the 'appendReplacement' JavaDoc:
            Pattern p = Pattern.compile("action=\"[-a-zA-Z0-9+&@#\\/%?=~_|!:,.;]*\""); // your URL regexp
            Matcher m = p.matcher(responseBody);
            while (m.find()) {
                finalUrl = m.group(0); // i iz smrt
                finalUrl = finalUrl.replace("action=\"", "").replace("\"","");
                finalUrl = finalUrl.startsWith("http") ? finalUrl : url + finalUrl;
                break;
            }
        }
        return finalUrl ;
    }

    public String querySubmissionIdFromOnStatusRequest(String onStatus) {

        String submissionId = null;
        try {
            String submissionIdPath = "$.message.order.items[0].xinput.form_response.submission_id";

            submissionId = JsonPath.parse(onStatus).read(submissionIdPath);

            log.info("submission id from on status {}", submissionId);
        } catch (Exception e) {
            log.warn("Unable to fetch submission id from on status : {}", onStatus);
        }
        return submissionId;

    }

    public String getSubmissionIdFromAdaptorService(String txId, String subscriberId, String bapId) {
        String submissionId = null;
        try {
            FetchStatusRequestModel requestModel = FetchStatusRequestModel
                    .builder()
                        .transactionId(txId)
                        .subscriberId(subscriberId)
                        .action("on_status")
                        .type("BAP")
                        .recordRange("0-1")
                        .sellers(List.of(bapId))
                    .build();

            ResponseEntity<String> responseEntity = getOnStatusFromAdaptor(requestModel);

            // Process the response
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                submissionId = querySubmissionIdFromOnStatusRequest(responseEntity.getBody());
            } else {
                log.warn("null submission id due to 500 satus code");
                return null;
            }

        } catch (RestClientException e) {
            log.warn("Error while fetching on staus request from ADAPTOR-API");
        }

        return submissionId;
    }

    @NotNull
    public ResponseEntity<String> getOnStatusFromAdaptor(FetchStatusRequestModel requestModel) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(JsonUtils.toJsonString(requestModel), headers);

        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = MessageFormat.format("{0}{1}",baseUrl, "extract-audit-logs");

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, String.class);
        log.debug("on_status response from adaptor {}", String.valueOf(responseEntity.getBody()));
        return responseEntity;
    }

    public String queryApiAudit(Context context) throws JsonProcessingException {

        String submissionId = null;
        List<ApiAudit> apiAudits = apiAuditService.getApiAudits(context);

        if(!CollectionUtils.isEmpty(apiAudits)){
            submissionId = querySubmissionIdFromOnStatusRequest(apiAudits.get(0).getJson());
        } else {
            //throw new GenericException("Submission Id not found");
        }
        return submissionId;
    }

    public String onStatusSubmissionIdFromApiAuditOrAdaptorCall(Context context) throws JsonProcessingException {

        log.info("fetching submission id from on_status request");
        String submissionId = queryApiAudit(context); //fetch from database

        if(Objects.isNull(submissionId)){ //fetch from api call
            log.info("fetching submission id from on_status request by ADAPTOR API CALL due to null entry in db");
            submissionId = getSubmissionIdFromAdaptorService(context.getTransactionId(), context.getBapId(), context.getBppId());
        }
        return submissionId;
    }

    public Context prepareRrquestContext(Context context, String action) {
        Context context1 = handleKblBppUrl(context);
        context1.setAction(action);
        context1.setMessageId(String.valueOf(UUID.randomUUID()));
        context1.setTimestamp(prepareCurrentDateTimeInZonedDatTime());
        return context1;
    }


    public String handleKblBppFormUrl(String url){

        String portExcludedUrl = url;

        if (url.contains("kbl-uat") && url.contains(":8880")){

           // portExcludedUrl = url.replace(":8880", "");
        }
        return portExcludedUrl;
    }

    public String getHeaderByName(String headerName, HttpHeaders httpHeaders){
        return httpHeaders.get(headerName).get(0);
    }
}
