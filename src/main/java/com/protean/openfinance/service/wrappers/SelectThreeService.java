package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.*;
import com.nsdl.beckn.api.model.onselect.OnSelectMessage;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import com.nsdl.beckn.api.model.onstatus.OnStatusRequest;
import com.nsdl.beckn.api.model.select.SelectMessage;
import com.nsdl.beckn.api.model.select.SelectRequest;
import com.protean.openfinance.dto.form.Form1SubmissionResponse;
import com.protean.openfinance.dto.searchwrapper.SelectOfferDto;
import com.protean.openfinance.utill.LoanStatusType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SelectThreeService extends BaseService {

    public OnSelectRequest orchestratorSelect3(SelectOfferDto selectedOfferDto, HttpHeaders headers) throws Exception {
        //form 02 submission
        Form1SubmissionResponse formTwoSubmissionResponse = formTwoLoanAmtAndTenureSubmission(selectedOfferDto);
        //prepare select 3 request
        OnSelectRequest onSelectThreeRequest = performSelectThree(formTwoSubmissionResponse);
        apiAuditService.auditOnSelect3("on_select_3",onSelectThreeRequest,headers);
        //return result for UI - KYC Link
        applicantDetailsService.updateApplicantStatus(headers, LoanStatusType.FORM_LOAN_AMT.value(), onSelectThreeRequest);
        return onSelectThreeRequest;
    }


    public OnSelectRequest performSelectThree(Form1SubmissionResponse form2SubmissionResponse) throws Exception {

        SelectRequest selectRequest3 = new SelectRequest();

        Context context = openFinanceUtils.prepareRrquestContext(form2SubmissionResponse.getContext(), ContextAction.SELECT.value());
        selectRequest3.setContext(context);
        selectRequest3.setMessage(prepareSelectThreeMessage(form2SubmissionResponse));

        log.info("select 3 REQ  ==========> {}", JsonUtils.toJsonString(selectRequest3));

        //OnSelectRequest onSelect_3_Request = callAdaptorSelect_3(selectRequest3);
        String onSelectThreeResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(selectRequest3), ContextAction.SELECT.value(),"SELECT_3", selectRequest3.getContext());
        OnSelectRequest onSelectThreeRequest = snakeCaseMapper.readValue(onSelectThreeResponseString, OnSelectRequest.class);
        log.info("onSelectThree");
        return onSelectThreeRequest;

    }

    private SelectMessage prepareSelectThreeMessage(Form1SubmissionResponse form2SubmissionResponse) throws JsonProcessingException {

        OnSelectMessage onSelect2Message = snakeCaseMapper.readValue(form2SubmissionResponse.getResponse(), OnSelectMessage.class);
        SelectMessage selectMessage = new SelectMessage();
        Order order = new Order();

        //Provider provider = new Provider();
        Item item = new Item();
        Item onSelect2Item = onSelect2Message.getOrder().getItems().get(0);
        //prepare Xinput
        Xinput xinput = new Xinput();

        Form form = onSelect2Item.getXinput().getForm();
        //form.setId(onSelect2Message.getOrder().getItems().get(0).getXinput().getForm().getId());
        xinput.setForm(form);
        xinput.setRequired(null);

        //prepare form response
        XInputFormResponse formResponse = new XInputFormResponse();
        formResponse.setStatus("SUCCESS");
        formResponse.setSubmissionId(form2SubmissionResponse.getSubmissionId());

        xinput.setXInputFormResponse(formResponse);

        item.setId(onSelect2Item.getId());//set to itemId from on_search response
        item.setXinput(xinput);//set x_input

       // provider.setId(onSelect2Message.getOrder().getProvider().getId());// provider id from prev select message i.e ==> OnSelectMessage 1

        order.setProvider(onSelect2Message.getOrder().getProvider());
        order.setItems(List.of(item));

        selectMessage.setOrder(order);

        return selectMessage;
    }


   /* private OnSelectRequest callAdaptorSelect_3(SelectRequest selectRequest2) throws JsonProcessingException {

        OnSelectRequest onSelectRequest_3 = null;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        SelectRequest selectRequest = new SelectRequest();
        selectRequest.setContext(selectRequest2.getContext());
        selectRequest.setMessage(selectRequest2.getMessage());

        log.info("Select 1 RES =============> {}", JsonUtils.toPrettyJsonString(selectRequest));
        HttpEntity<String> requestEntity = new HttpEntity<>(snakeCaseMapper.writeValueAsString(selectRequest), headers);

        String apiUrl = "https://pilot-gateway-1.beckn.nsdl.co.in/adaptor-v2/adp1/select";

        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {

            String responseBody = response.getBody();
            System.out.println("Response: " + responseBody);
            onSelectRequest_3 = snakeCaseMapper.readValue(responseBody, OnSelectRequest.class);

        } else {
            throw new GenericException("Error calling seller");
        }
        return onSelectRequest_3;
    }*/

    private Form1SubmissionResponse formTwoLoanAmtAndTenureSubmission(SelectOfferDto selectedOffer) throws JsonProcessingException {

        Form1SubmissionResponse form2SubmissionResponse = new Form1SubmissionResponse();

        OnSelectRequest onSelect_2_Request = selectedOffer.getSelectedOffer();

        //  if (!onSelect_2_Request.getContext().getBppId().equalsIgnoreCase("ondctest.refo.dev")) {  // SLIPPED DMI
        Item item = onSelect_2_Request.getMessage().getOrder().getItems().get(0);
        Xinput xinput = item.getXinput();


        Optional<Tags> loanInfoTag = item.getTags().stream().filter(tag -> tag.getDescriptor().getCode().equalsIgnoreCase("LOAN_INFO")).findFirst();
        String loanAmtString = item.getPrice().getValue();
        long loanAmount = Math.round(Double.valueOf(loanAmtString));


        //INTEREST_RATE, TERM, INTEREST_RATE_TYPE, APPLICATION_FEE, FORECLOSURE_FEE, INTEREST_RATE_CONVERSION_CHARGE,
        // DELAY_PENALTY_FEE, OTHER_PENALTY_FEE, TNC_LINK, ANNUAL_PERCENTAGE_RATE, REPAYMENT_FREQUENCY,
        // NUMBER_OF_INSTALLMENTS_OF_REPAYMENT, COOL_OFF_PERIOD, INSTALLMENT_AMOUNT
        Map<String, String> loanInfoDescriptorMap = loanInfoTag.get().getList().stream()
                .collect(Collectors.toMap(
                        listElement -> listElement.getDescriptor().getCode(),  // Key mapper function
                        listElement -> listElement.getValue()                 // Value mapper function
                ));


        //String url = openFinanceUtils.getFormUrlFromInputForm(xinput.getForm().getUrl());
        String url = openFinanceUtils.handleKblBppFormUrl(openFinanceUtils.getFormUrlFromInputForm(xinput.getForm().getUrl()));
        //String url = "https://preprodfiu.pirimidtech.com:8880/lender-bridge/ondc/kbl-uat/public/information/form/offer-update/b601c80e-49bc-4da2-81d8-85fd670296dc/submit";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");


        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("requestAmount", selectedOffer.getLoanAmountAdjusted());
        //map.add("requestTerm", selectedOffer.getLoanTenureAdjusted());
        map.add("formId", xinput.getForm().getId());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {

            String response = responseEntity.getBody();
            log.info("Form 2 Submission URL ===============> {}", url);
            log.info("Form 2 SubmissionId ===============> {}", JsonUtils.toPrettyJsonString(responseEntity.getBody()));

            String submissionId = openFinanceUtils.getSubmissionIdFromResponse(response);


            form2SubmissionResponse.setProvider(onSelect_2_Request.getMessage().getOrder().getProvider());
            form2SubmissionResponse.setSubmissionId(submissionId);
            form2SubmissionResponse.setForm(item.getXinput().getForm());
            try {
                form2SubmissionResponse.setResponse(snakeCaseMapper.writeValueAsString(onSelect_2_Request.getMessage()));//this message and form id will be used for select 3
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            form2SubmissionResponse.setIsSubmitted(true);
            form2SubmissionResponse.setDescriptor(item.getDescriptor());
            form2SubmissionResponse.setItemId(item.getId());
            form2SubmissionResponse.setContext(handleKblBppUrl(onSelect_2_Request.getContext()));

        } else {
            log.error("Form 2 submission request failed with status code {}, and response {}", responseEntity.getStatusCode(), responseEntity.toString());
        }
        return form2SubmissionResponse;
    }


    /**
     * for KBL trailing port number 8880 from BPP_URI
     * @param context
     * @return context
     */
    private Context handleKblBppUrl(Context context) {

        String bppUri = "https://ondcuatkbl.ignosis.ai:8880/lender-bridge/ondc/kbl-uat";

        if (context.getBppUri().contains("kbl-uat")){
            context.setBppUri(bppUri);
        }

        /*String bppUri = "https://ondcuatpahal.ignosis.ai:8880/lender-bridge/ondc/pahal-uat";
        if (context.getBppUri().contains("ignosis")){
            context.setBppUri(bppUri);
        }*/
        return context;
    }

    public void saveOnStatusResponse(OnStatusRequest onStatusFromAdaptor) throws JsonProcessingException {
        apiAuditService.saveOnStatusResponse(onStatusFromAdaptor);
    }


}

