package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.*;
import com.nsdl.beckn.api.model.init.InitMessage;
import com.nsdl.beckn.api.model.init.InitRequest;
import com.nsdl.beckn.api.model.oninit.OnInitRequest;
import com.nsdl.beckn.api.model.onselect.OnSelectMessage;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import com.protean.openfinance.dto.searchwrapper.PostKycAndBankDetailsDto;
import com.protean.openfinance.entity.ApiAudit;
import com.protean.openfinance.utill.LoanStatusType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class InitOneService extends BaseService {


    public OnInitRequest orchestratorInitOne(PostKycAndBankDetailsDto postKycAndBankDetailsDto, HttpHeaders httpHeaders) throws Exception {


        OnSelectRequest onSelect3Request = postKycAndBankDetailsDto.getPostKyc();

        //1. get submission id from adaptor

        String submissionId = openFinanceUtils.onStatusSubmissionIdFromApiAuditOrAdaptorCall(onSelect3Request.getContext());

        //2. prepare init one request context / message
        //3. Call adaptor init one
        OnInitRequest onInitOneRequest = performInitOne(onSelect3Request, submissionId);

        //return onInit_1_Request;

        //4. get bank detail form and submit - FORM submission
        String formThreeSubmissionId = submitBankDetailForm(onInitOneRequest, postKycAndBankDetailsDto);
        //submission id for bank form/disbursement

        //---------- INIT TWO [will receive e-nach form to be return UI]-----------

        //1. prepare init 2 request - bank detail form submission id with form id and other inputs
        OnInitRequest onInitRequest2 = initTwoService.orchestratorInitTwo(onInitOneRequest, formThreeSubmissionId);

        applicantDetailsService.updateApplicantStatus(httpHeaders, LoanStatusType.KYC.value(), null);

        return onInitRequest2;
    }

    private String submitBankDetailForm(OnInitRequest onInit_1_Request, PostKycAndBankDetailsDto postKycDetails) {

        String submissionId = null;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        headers.set("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8");
        headers.set("Cache-Control", "max-age=0");
        headers.set("Connection", "keep-alive");
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        Form form = onInit_1_Request.getMessage().getOrder().getItems().get(0).getXinput().getForm();

        // Request parameters
        /*Map<String, String> requestBody = new HashMap<>();
        requestBody.put("accHolderName", postKycDetails.getAccHolderName());
        requestBody.put("acctype", postKycDetails.getAcctype());
        requestBody.put("accNo", postKycDetails.getAccNo());
        requestBody.put("ifscCode", postKycDetails.getIfscCode());
        requestBody.put("formId", form.getId());*/

        headers.set("Accept", "application/json");

        MultiValueMap<String, String> inputMap = new LinkedMultiValueMap<>();

        inputMap.add("accHolderName", postKycDetails.getAccHolderName());
        inputMap.add("acctype", postKycDetails.getAcctype());
        inputMap.add("accNo", postKycDetails.getAccNo());
        inputMap.add("ifscCode", postKycDetails.getIfscCode());
        inputMap.add("formId", form.getId());

        log.info("Bank Details form url  ===> {}", form.getUrl());
        //UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(openFinanceUtils.getFormUrlFromInputForm(form.getUrl()));
        final String url = openFinanceUtils.getFormUrlFromInputForm(form.getUrl());



      /*  // Encode the request parameters
        for (Map.Entry<String, String> entry : requestBody.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }*/

        //HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(inputMap, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                //builder.toUriString(),
                HttpMethod.POST,
                requestEntity,
                String.class
        );


        if (responseEntity.getStatusCode() == HttpStatus.OK && !responseEntity.getBody().contains("ack")) {

            String responseBody = responseEntity.getBody();
            log.info("Form 3 [] Response ===============> {}", JsonUtils.toPrettyJsonString(responseBody));
            submissionId = openFinanceUtils.getSubmissionIdFromResponse(responseBody);

        } else {
            log.error("invalid response received after form 2 submission id");
            //throw new GenericException("Invalid response by bank details for submission service");
        }
        return submissionId;
    }


    private String submitBankDetailFormOld(OnInitRequest onInit_1_Request, PostKycAndBankDetailsDto postKycDetails) {

        String submissionId = null;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        headers.set("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8");
        headers.set("Cache-Control", "max-age=0");
        headers.set("Connection", "keep-alive");
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        Form form = onInit_1_Request.getMessage().getOrder().getItems().get(0).getXinput().getForm();

        // Request parameters
        Map<String, String> requestBody = new HashMap<>();

        requestBody.put("accHolderName", postKycDetails.getAccHolderName());
        requestBody.put("acctype", postKycDetails.getAcctype());
        requestBody.put("accNo", postKycDetails.getAccNo());
        requestBody.put("ifscCode", postKycDetails.getIfscCode());
        requestBody.put("formId", form.getId());

        headers.set("Accept", "application/json");

        MultiValueMap<String, String> inputMap = new LinkedMultiValueMap<>();

        inputMap.add("accHolderName", postKycDetails.getAccHolderName());
        inputMap.add("acctype", postKycDetails.getAcctype());
        inputMap.add("accNo", postKycDetails.getAccNo());
        inputMap.add("ifscCode", postKycDetails.getIfscCode());
        inputMap.add("formId", form.getId());

        log.info("Bank Details form url  ===> {}", form.getUrl());
        //UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(openFinanceUtils.getFormUrlFromInputForm(form.getUrl()));
        final String url = openFinanceUtils.getFormUrlFromInputForm(form.getUrl());



      /*  // Encode the request parameters
        for (Map.Entry<String, String> entry : requestBody.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }*/

        //HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(inputMap, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                //builder.toUriString(),
                HttpMethod.POST,
                requestEntity,
                String.class
        );


        if (responseEntity.getStatusCode() == HttpStatus.OK && !responseEntity.getBody().contains("ack")) {

            String responseBody = responseEntity.getBody();
            log.info("Form 3 [] Response ===============> {}", JsonUtils.toPrettyJsonString(responseBody));
            submissionId = openFinanceUtils.getSubmissionIdFromResponse(responseBody);

        } else {
            log.error("invalid response received after form 2 submission id");
            //throw new GenericException("Invalid response by bank details for submission service");
        }
        return submissionId;
    }


    public OnInitRequest performInitOne(OnSelectRequest onSelectThreeRequest, String submissionId) throws Exception {

        InitRequest initRequest = new InitRequest();
        Context context = openFinanceUtils.prepareRrquestContext(onSelectThreeRequest.getContext(), ContextAction.INIT.value());
        initRequest.setContext(context);
        initRequest.setMessage(prepareInitOneMessage(onSelectThreeRequest, submissionId));

        log.info("Init 1 REQ  ==========> {}", JsonUtils.toJsonString(initRequest));

        String onInittOneResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(initRequest),ContextAction.INIT.value(),"INIT_!", initRequest.getContext());
        OnInitRequest onInitOneRequest = snakeCaseMapper.readValue(onInittOneResponseString, OnInitRequest.class);

        //TODO : log on init 1
        return onInitOneRequest;

    }

    private InitMessage prepareInitOneMessage(OnSelectRequest onSelectRequest, String kycFormSubmissionId) throws JsonProcessingException {

        OnSelectMessage onSelectThreeMessage = onSelectRequest.getMessage();

        InitMessage initMessage = new InitMessage();
        Order order = new Order();

        Provider provider = new Provider();
        Item item = new Item();
        Item onSelect2Item = onSelectThreeMessage.getOrder().getItems().get(0);
        //prepare Xinput
        Xinput xinput = new Xinput();

        Form form = new Form();
        form.setId(onSelectThreeMessage.getOrder().getItems().get(0).getXinput().getForm().getId());
        xinput.setForm(form);
        xinput.setRequired(null);

        //prepare form response
        XInputFormResponse formResponse = new XInputFormResponse();
        formResponse.setStatus("SUCCESS");
        formResponse.setSubmissionId(kycFormSubmissionId);

        xinput.setXInputFormResponse(formResponse);

        item.setId(onSelect2Item.getId());//set to itemId from on_search response
        item.setXinput(xinput);//set x_input

        // provider.setId(onSelect2Message.getOrder().getProvider().getId());// provider id from prev select message i.e ==> OnSelectMessage 1

        provider.setId(onSelectThreeMessage.getOrder().getProvider().getId());//set only provider id
        order.setProvider(provider);
        order.setItems(List.of(item));

        initMessage.setOrder(order);

        //prepare payment
        List<Payment> payments = openFinanceUtils.prepareInitOnePaymentTags();//fixed values from json file
        order.setPayments(payments);

        return initMessage;
    }


   /* private OnInitRequest callAdaptorInitOne(InitRequest initRequest) throws JsonProcessingException {

        OnInitRequest onInitRequestThree = null;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        InitRequest initRequest1 = new InitRequest();
        initRequest1.setContext(initRequest.getContext());
        initRequest1.setMessage(initRequest.getMessage());

        log.info("Init 1 REQ =============> {}", JsonUtils.toPrettyJsonString(initRequest1));
        HttpEntity<String> requestEntity = new HttpEntity<>(snakeCaseMapper.writeValueAsString(initRequest1), headers);

        String apiUrl = "https://pilot-gateway-1.beckn.nsdl.co.in/adaptor-v2/adp1/init";

        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {

            String responseBody = response.getBody();
            log.info("Init 1 RES ========> {}", responseBody);
            onInitRequestThree = snakeCaseMapper.readValue(responseBody, OnInitRequest.class);

        } else {
            throw new GenericException("Error calling seller");
        }
        return onInitRequestThree;
    }*/


    //todo : mock service delete this later at code cleanup
    /*public String getKycSubmissionIdDFromAdaptor__REMOVE_THIS_LATER(OnSelectRequest onSelect3Request) throws JsonProcessingException {

        String submissionId = null;


        List<ApiAudit> auditList = apiAuditService.getApiAudits(onSelect3Request.getContext());

        String on_statusString = auditList.get(0).getJson();


        JsonNode jsonNode = objectMapper.readTree(on_statusString);

        submissionId = jsonNode
                .path("message").path("order").path("items").path(0)
                .path("xinput").path("form_response").path("submission_id")
                .asText();

        return submissionId;
    }*/

}

