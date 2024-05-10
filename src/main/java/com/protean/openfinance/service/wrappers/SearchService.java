package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jayway.jsonpath.JsonPath;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.Context;
import com.nsdl.beckn.api.model.common.Item;
import com.nsdl.beckn.api.model.onsearch.OnSearchRequest;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import com.nsdl.beckn.api.model.search.SearchMessage;
import com.nsdl.beckn.api.model.search.SearchRequest;
import com.protean.openfinance.dto.form.Form1SubmissionResponse;
import com.protean.openfinance.dto.searchwrapper.ApplicantInfo;
import com.protean.openfinance.dto.searchwrapper.SearchWrapperDto;
import com.protean.openfinance.exception.GenericException;
import com.protean.openfinance.exception.LenderException;
import com.protean.openfinance.utill.Constant;
import com.protean.openfinance.utill.LoanStatusType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class SearchService extends BaseService {

    @Value("${adaptor.filter-lsp.kbl}")
    public String kblBppId;

    @Value("${adaptor.filter-lsp.dmi}")
    public String dmiBppId;

    @Value("${adaptor.filter-lsp.sequel}")
    public String sequel;

    @Value("${adaptor.filter-lsp.abfl}")
    public String abfl;

    @Value("${adaptor.filter-lsp.praman}")
    public String praman;

    public String search(SearchWrapperDto searchWrapperDto, HttpHeaders httpHeaders) throws Exception {

        //1.Search call
        SearchRequest searchRequest = prepareSearchRequest(searchWrapperDto);
        //prepareAaId(searchWrapperDto);
		//1.1 set logs

        audit.auditLogs("search", searchWrapperDto, searchRequest);
        audit.saveApplicationDetails(searchWrapperDto, LoanStatusType.PERSONAL_INFO.value());

        String searchResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(searchRequest), ContextAction.SEARCH.value(), "SEARCH",searchRequest.getContext() );

        List<OnSearchRequest> kblDmiOnSearchResponses = filterOnSearchResponseForDmiAndKbl(searchResponseString, searchRequest);

        log.info("Search Response  =================> {}", JsonUtils.toPrettyJsonString(kblDmiOnSearchResponses));

        //2.Form submission
        List<Form1SubmissionResponse> form1SubmissionResponses = formOnePersonalInfoSubmission(kblDmiOnSearchResponses, searchWrapperDto);

        //3. Select_1
        List<OnSelectRequest> onSelectOneRequests = selectService.performSelectOne(form1SubmissionResponses, searchWrapperDto);

        //TODO : save onSelect_1_Requests [converto to json and save in json column] action - on_select_1
        //String response = JsonUtils.toJsonString(onSelect_1_Requests);//for logs -amit
      
        audit.auditLogs("on_select_1", searchWrapperDto, onSelectOneRequests);
        
        //3. get lsp bearer token
        String url = lspClientService.  getRedirectUrl(onSelectOneRequests, searchWrapperDto);

        return url;// API RESPONSE

    }


    private List<OnSearchRequest> filterOnSearchResponseForDmiAndKbl(String searchResponseString,SearchRequest searchRequest) throws JsonProcessingException {

        /*String test ="$.responses[*]";

        List<OnSearchRequest> onSearchRequests = new ArrayList<>();

        List<Object> list = JsonPath.parse(searchResponseString).read(test);

        for(Object object : list){
            try{
                OnSearchRequest onSearchRequest = snakeCaseMapper.readValue(JsonUtils.toJsonString(object), OnSearchRequest.class);
                onSearchRequests.add(onSearchRequest);
            }catch (Exception e){
                log.error("Skipped on search due to invalid response {}",JsonUtils.toJsonString(object));
            }
        }
                return onSearchRequests;*/


        //String queryFilter ="$.responses[?(@.context.bpp_id == 'ondcuatkbl.ignosis.ai' || @.context.bpp_id == 'ondctest.refo.dev')]";
        //String sql = "ondc.sequelstring.com/seller/protocol";
        //String queryFilter ="$.responses[?(@.context.bpp_id == '"+kblBppId+"' || @.context.bpp_id == '"+dmiBppId+"')]";// || @.context.bpp_id == '"+sequel+"' || @.context.bpp_id == '"+abfl+"' || @.context.bpp_id == '"+praman+"')]";
        String queryFilter ="$.responses[?(@.context.bpp_id == '"+kblBppId+"' || @.context.bpp_id == '"+dmiBppId+"' || @.context.bpp_id == '"+sequel+"' || @.context.bpp_id == '"+abfl+"' || @.context.bpp_id == '"+praman+"')]";

        //String queryFilter ="$.responses[?(@.context.bpp_id == 'ondctest.refo.dev')]";

        Object result = JsonPath.parse(searchResponseString).read(queryFilter);

        audit.auditLogs("on_search", searchRequest, result);
        //TODO : audit log  - action on_search , responsees,
        List<OnSearchRequest> onSearchRequestList = snakeCaseMapper.readValue(JsonUtils.toJsonString(result), new TypeReference<List<OnSearchRequest>>(){});

        return onSearchRequestList;

    }


    private SearchRequest prepareSearchRequest(SearchWrapperDto searchWrapperDto) throws JsonProcessingException {
        Context context = commonObjectPreparer.prepareContext(searchWrapperDto);
        SearchMessage searchMessage = commonObjectPreparer.prepareSearchMessage(searchWrapperDto);

        SearchRequest req = new SearchRequest();
        req.setContext(context);
        req.setMessage(searchMessage);

        return req;
    }

   /* private List<OnSearchRequest> callAdaptorSearch(ObjectRequest searchInput) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        *//*Context context = commonObjectPreparer.prepareContext();
        SearchMessage searchMessage = commonObjectPreparer.prepareSearchMessage();*//*

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setContext(searchInput.getContext());
        searchRequest.setMessage((SearchMessage) searchInput.getMessage());

        HttpEntity<String> requestEntity = new HttpEntity<>(snakeCaseMapper.writeValueAsString(searchRequest), headers);

        String apiUrl = "https://pilot-gateway-1.beckn.nsdl.co.in/adaptor-v2/adp1/search";

        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseBody = response.getBody();
            System.out.println("Response: " + responseBody);
        } else {
            throw new GenericException("Error calling seller");
        }

        String jsonPathExpression ="$.responses[?(@.context.bpp_id == 'preprodfiu.pirimidtech.com' || @.context.bpp_id == 'ondctest.refo.dev')]";
        Object result = JsonPath.parse(response.getBody()).read(jsonPathExpression);
        
        audit.auditLogs("on_search", searchRequest, result);
        //TODO : audit log  - action on_search , responsees,
        return List.of(snakeCaseMapper.readValue(JsonUtils.toJsonString(result), OnSearchRequest[].class));
    }*/

    private List<Form1SubmissionResponse> formOnePersonalInfoSubmission(List<OnSearchRequest> onSearchRequestList, SearchWrapperDto searchWrapperDto) {

        List<Form1SubmissionResponse> formSubmissionList = new ArrayList<>();

        Iterator<OnSearchRequest> onSearchRequestIterator = onSearchRequestList.iterator();

        while (onSearchRequestIterator.hasNext()) {

            OnSearchRequest onSearchRequest = onSearchRequestIterator.next();

            try {
                Form1SubmissionResponse form1SubmissionResponse = new Form1SubmissionResponse();

                String formUrl = onSearchRequest.getMessage().getCatalog().getBppProviders().get(0).getItems().get(0).getXinput().getForm().getUrl();
                String finalUrl = openFinanceUtils.handleKblBppFormUrl(openFinanceUtils.getFormUrlFromInputForm(formUrl));

                HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(formInputMap(searchWrapperDto.getApplicantInfo()), buildRequestHeaders());

                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.exchange(
                        finalUrl,
                        HttpMethod.POST,
                        entity,
                        String.class
                );

                if (response.getStatusCode().is2xxSuccessful()) {

                    log.info("Form 1 Submission URL ===============> {}", finalUrl);
                    log.info("Form 1 SubmissionId =================> {}", JsonUtils.toPrettyJsonString(response.getBody()));

                    if (process2xxAndSetSubmissionId(response, !onSearchRequestIterator.hasNext(), formSubmissionList, onSearchRequest, form1SubmissionResponse))
                        continue;

                } else {
                    process5xxErrorResponse(form1SubmissionResponse, onSearchRequest, response);
                }

                formSubmissionList.add(form1SubmissionResponse);
            }
            catch (RestClientException e) {
                log.warn("Error while form 1 submission, skipping form submission for  : {} , cause : {}", onSearchRequest.getContext().toString(), ExceptionUtils.getStackTrace(e));
            }
        }
        return formSubmissionList;
    }

    private static void process5xxErrorResponse(Form1SubmissionResponse form1SubmissionResponse, OnSearchRequest onSearchRequest, ResponseEntity<String> response) {
        form1SubmissionResponse.setIsSubmitted(false);
        form1SubmissionResponse.setDescriptor(onSearchRequest.getMessage().getCatalog().getBppProviders().get(0).getItems().get(0).getDescriptor());
        log.error("Request failed with status code: {}", response.getStatusCode());
    }

    private boolean process2xxAndSetSubmissionId(ResponseEntity<String> response, boolean isLastIteration, List<Form1SubmissionResponse> formSubmissionList, OnSearchRequest onSearchRequest, Form1SubmissionResponse form1SubmissionResponse) {
        String responseBody = response.getBody();
        String submissionId = null;

        try {
            submissionId = openFinanceUtils.getSubmissionIdFromResponse(responseBody);

        } catch (LenderException e) {

            if(isLastIteration && CollectionUtils.isEmpty(formSubmissionList)){
                throw e;
            }
            return true;
        }

        Item item = onSearchRequest.getMessage().getCatalog().getBppProviders().get(0).getItems().get(0);

        form1SubmissionResponse.setProvider(onSearchRequest.getMessage().getCatalog().getBppProviders().get(0));
        form1SubmissionResponse.setSubmissionId(submissionId);
        form1SubmissionResponse.setForm(item.getXinput().getForm());
        form1SubmissionResponse.setResponse(responseBody);
        form1SubmissionResponse.setIsSubmitted(true);
        form1SubmissionResponse.setDescriptor(item.getDescriptor());
        form1SubmissionResponse.setItemId(item.getId());
        form1SubmissionResponse.setContext(openFinanceUtils.handleKblBppUrl(onSearchRequest.getContext()));
        return false;
    }

    @NotNull
    private static HttpHeaders buildRequestHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("Accept", "application/json");
        return headers;
    }

    @NotNull
    private static MultiValueMap<String, String> formInputMap(ApplicantInfo applicantInfo) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("firstName", applicantInfo.getFirstName());
        map.add("lastName", applicantInfo.getLastName());
        map.add("dob", applicantInfo.getDob());//"1992-04-12"
        map.add("pan", applicantInfo.getPan());//required field
        map.add("contactNumber", applicantInfo.getContactNumber());
        map.add("employmentType", applicantInfo.getEmploymentType());//salaried, self-employed //required
        map.add("income", applicantInfo.getIncome());//"900000" //required >900000
        map.add("companyName", applicantInfo.getCompanyName());
        map.add("email", applicantInfo.getEmail());
        map.add("officialemail", applicantInfo.getOfficialemail()); //required
        map.add("udyamNumber", applicantInfo.getUdyamNumber());
        map.add("addressL1", applicantInfo.getAddressL1());
        map.add("addressL2", applicantInfo.getAddressL2());
        map.add("city", applicantInfo.getCity());
        map.add("state", applicantInfo.getState());
        map.add("pincode", applicantInfo.getPincode());
        map.add("endUse","other");//hardcoded
        map.add("gender", "male");
        map.add("aa_id", applicantInfo.getAa_id());//"8087841100@finvu" //required

        map.add("bureauConsent", applicantInfo.getBureauConsent());
        return map;
    }

    public void prepareAaId(SearchWrapperDto searchWrapperDto) {

        String aa_id = searchWrapperDto.getApplicantInfo().getAaCode().equalsIgnoreCase(Constant.AA_CODE_FINVU)
                ? MessageFormat.format("{0}{1}", searchWrapperDto.getApplicantInfo().getContactNumber(), Constant.AA_FINVU_ID)
                : null;

        if(Objects.isNull(aa_id) || StringUtils.isBlank(searchWrapperDto.getApplicantInfo().getContactNumber())){
            throw new GenericException("Invalid AA_Id");
        }
        searchWrapperDto.getApplicantInfo().setAa_id(aa_id);
    }
}

