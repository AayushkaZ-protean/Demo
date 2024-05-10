package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.*;
import com.nsdl.beckn.api.model.onselect.OnSelectMessage;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import com.nsdl.beckn.api.model.select.SelectMessage;
import com.nsdl.beckn.api.model.select.SelectRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SelectTwoService extends BaseService{

    public List<OnSelectRequest> performSelectTwo(List<OnSelectRequest> onSelect1List) throws JsonProcessingException {

        List<OnSelectRequest> onSelectTwoRequests = new ArrayList<>();

        for (OnSelectRequest onSelectRequest1 : onSelect1List) {

            SelectRequest selectRequest2 = new SelectRequest();

            Context context = openFinanceUtils.prepareRrquestContext(onSelectRequest1.getContext(), ContextAction.SELECT.value());
            SelectMessage message = prepareSelectTwoMessage(onSelectRequest1);

            selectRequest2.setContext(context);
            selectRequest2.setMessage(message);

            log.info("select 2 REQ  ==========> {}", JsonUtils.toJsonString(selectRequest2));

            OnSelectRequest onSelectRequest = null;
            try {

                String onSelectTwoResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(selectRequest2), ContextAction.SELECT.value(), "SELECT_2", selectRequest2.getContext());
                onSelectRequest = snakeCaseMapper.readValue(onSelectTwoResponseString, OnSelectRequest.class);
                //onSelectRequest = callAdaptorSelect_2(selectRequest2);

            } catch (Exception e) {
                log.warn("skipping/failed select 2 call for : {}, cause : {}", JsonUtils.toPrettyJsonString(selectRequest2), ExceptionUtils.getStackTrace(e));
                continue;
            }
            onSelectTwoRequests.add(onSelectRequest);
        }

        return onSelectTwoRequests;

    }

    /**
     * @param onSelectRequest1
     * @return SelectMessage
     * Difference between Select 1 vs 2 ==> select 1 all form input from onsearch and submission id from FromSubsmission[personal info]
     * for select 2 - all input's from OnSelectMessage 1 [msg. to msg.] just change from_response status from PENDING TO CONSENT_APPROVED
     */
    private SelectMessage prepareSelectTwoMessage(OnSelectRequest onSelectRequest1) {

        OnSelectMessage onSelect1Message = onSelectRequest1.getMessage();
        SelectMessage selectMessage = new SelectMessage();
        Order order = new Order();

        Provider provider = new Provider();
        Item item = new Item();

        //prepare Xinput
        Xinput xinput = new Xinput();

        Form form = new Form();
        form.setId(onSelect1Message.getOrder().getItems().get(0).getXinput().getForm().getId());
        xinput.setForm(form);
        xinput.setRequired(null);

        //prepare form response
        XInputFormResponse formResponse = new XInputFormResponse();
        //formResponse.setStatus("CONSENT_APPROVED");
        formResponse.setStatus("APPROVED");// log review comment
        formResponse.setSubmissionId(onSelect1Message.getOrder().getItems().get(0).getXinput().getXInputFormResponse().getSubmissionId());

        xinput.setXInputFormResponse(formResponse);

        item.setId(onSelect1Message.getOrder().getItems().get(0).getId());//set to itemId from on_search response
        item.setXinput(xinput);//set x_input

        provider.setId(onSelect1Message.getOrder().getProvider().getId());// provider id from prev select message i.e ==> OnSelectMessage 1

        order.setProvider(provider);
        order.setItems(List.of(item));

        selectMessage.setOrder(order);

        return selectMessage;
    }

/*
    private OnSelectRequest callAdaptorSelect_2(SelectRequest selectRequest2) throws Exception {

        OnSelectRequest onSelectRequest_2 = null;

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
            onSelectRequest_2 = snakeCaseMapper.readValue(responseBody, OnSelectRequest.class);

        } else {
            throw new GenericException("Error calling seller");
        }
        return onSelectRequest_2;

    }*/


}

