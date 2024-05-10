package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.*;
import com.nsdl.beckn.api.model.confirm.ConfirmMessage;
import com.nsdl.beckn.api.model.confirm.ConfirmRequest;
import com.nsdl.beckn.api.model.onconfirm.OnConfirmRequest;
import com.nsdl.beckn.api.model.oninit.OnInitMessage;
import com.nsdl.beckn.api.model.oninit.OnInitRequest;
import com.nsdl.beckn.api.model.onstatus.OnStatusRequest;
import com.nsdl.beckn.api.model.status.StatusMessage;
import com.nsdl.beckn.api.model.status.StatusRequest;
import com.protean.openfinance.dto.searchwrapper.ConfirmLoanApplicationDto;
import com.protean.openfinance.dto.searchwrapper.LoanStatusDto;
import com.protean.openfinance.exception.GenericException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StatusService extends BaseService {

    public OnConfirmRequest orchestratorConfirm(ConfirmLoanApplicationDto loanStatusDto) throws Exception {
        OnConfirmRequest onConfirmRequest = performConfirm(loanStatusDto.getLoanStatus());
        return onConfirmRequest;
    }

    public OnConfirmRequest performConfirm(OnInitRequest onInitRequest) throws Exception {

        ConfirmRequest confirmRequest = new ConfirmRequest();
        String submissionId = openFinanceUtils.onStatusSubmissionIdFromApiAuditOrAdaptorCall(onInitRequest.getContext());
        Context context = openFinanceUtils.prepareRrquestContext(onInitRequest.getContext(), ContextAction.CONFIRM.value());

        confirmRequest.setContext(context);
        confirmRequest.setMessage(prepareConfirmMessage(onInitRequest, submissionId));


        String onConfirmResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(confirmRequest), ContextAction.CONFIRM.value(), "CONFIRM", confirmRequest.getContext());
        OnConfirmRequest onConfirmRequest = snakeCaseMapper.readValue(onConfirmResponseString, OnConfirmRequest.class);

        return onConfirmRequest;

    }

    private ConfirmMessage prepareConfirmMessage(OnInitRequest onInitTwoRequest, String enachSubmissionId) throws JsonProcessingException {

        OnInitMessage onInitTwoMessage = onInitTwoRequest.getMessage();

        ConfirmMessage confirmMessage = new ConfirmMessage();
        Order order = new Order();

        Provider provider = new Provider();
        Item item = new Item();
        Item onInit2Item = onInitTwoMessage.getOrder().getItems().get(0);
        //prepare Xinput
        Xinput xinput = new Xinput();

        Form form = new Form();
        form.setId(onInitTwoMessage.getOrder().getItems().get(0).getXinput().getForm().getId());
        xinput.setForm(form);
        xinput.setRequired(null);

        //prepare form response
        XInputFormResponse formResponse = new XInputFormResponse();
        formResponse.setStatus("SUCCESS");
        formResponse.setSubmissionId(enachSubmissionId);

        xinput.setXInputFormResponse(formResponse);

        item.setId(onInit2Item.getId());//set to itemId from on_search response
        item.setXinput(xinput);//set x_input

        // provider.setId(onSelect2Message.getOrder().getProvider().getId());// provider id from prev select message i.e ==> OnSelectMessage 1

        provider.setId(onInitTwoMessage.getOrder().getProvider().getId());//set only provider id
        order.setProvider(provider);
        order.setItems(List.of(item));

        //prepare payment
        List<Payment> payments = openFinanceUtils.prepareInitOnePaymentTags();//fixed values from json file
        order.setPayments(payments);

        confirmMessage.setOrder(order);
        return confirmMessage;
    }

    public OnConfirmRequest loanSummary(HttpHeaders header) throws Exception {

        OnConfirmRequest latestOnConfirmByContactNumber = applicantDetailsService.getOnConfirmByTransactionIdAndContactNumber(header);
        log.info("previous esigned_confirmed for contactNumber {}", JsonUtils.toPrettyJsonString(latestOnConfirmByContactNumber));
        return latestOnConfirmByContactNumber;

    }

    public OnStatusRequest loanStatus(LoanStatusDto loanStatusDto) throws Exception {

        StatusRequest statusRequest = new StatusRequest();

        Context context = openFinanceUtils.prepareRrquestContext(loanStatusDto.getOnConfirmResponse().getContext(), ContextAction.STATUS.value());
        statusRequest.setContext(context);
        statusRequest.setMessage(prepareStatusMessage(loanStatusDto.getOnConfirmResponse()));

        log.info("Status REQ  ==========> {}", JsonUtils.toJsonString(statusRequest));

        String onStatusResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(statusRequest), ContextAction.STATUS.value(), "loan_status", statusRequest.getContext());
        OnStatusRequest onStatusRequest = snakeCaseMapper.readValue(onStatusResponseString, OnStatusRequest.class);
        log.info("fetch loan status");

        return onStatusRequest;

    }

   /* private OnConfirmRequest callAdaptorConfirm(ConfirmRequest confirmRequestInput) throws JsonProcessingException {

        OnConfirmRequest onConfirmRequest = null;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ConfirmRequest confirmRequest = new ConfirmRequest();
        confirmRequest.setContext(confirmRequestInput.getContext());
        confirmRequest.setMessage(confirmRequestInput.getMessage());

        log.info("Init 3 REQ =============> {}", JsonUtils.toPrettyJsonString(confirmRequest));
        HttpEntity<String> requestEntity = new HttpEntity<>(snakeCaseMapper.writeValueAsString(confirmRequest), headers);

        String apiUrl = "https://pilot-gateway-1.beckn.nsdl.co.in/adaptor-v2/adp1/confirm";

        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {

            String responseBody = response.getBody();

            log.info("confirm ==> {}", responseBody);

            onConfirmRequest = snakeCaseMapper.readValue(responseBody, OnConfirmRequest.class);

            //TODO : save on_init 3 in api audit log

        } else {
            throw new GenericException("Error calling seller init 2");
        }
        return onConfirmRequest;
    }*/

    public StatusMessage prepareStatusMessage(OnConfirmRequest onConfirmRequest) {
        StatusMessage statusMessage = new StatusMessage();
        statusMessage.setRefId(onConfirmRequest.getMessage().getOrder().getQuote().getId());
        return statusMessage;

    }

    public String fetchOnStatus(HttpHeaders headers, String model) throws JsonProcessingException {
        String minified = String.valueOf(snakeCaseMapper.readValue(model, JsonNode.class));
        ResponseEntity<String> responseEntity = openFinanceUtils.getOnStatusFromAdaptor(snakeCaseMapper.readValue(minified, FetchStatusRequestModel.class));
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new GenericException("No on_status record found");
        }
    }
}
