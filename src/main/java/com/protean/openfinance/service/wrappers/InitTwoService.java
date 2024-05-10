package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.*;
import com.nsdl.beckn.api.model.init.InitMessage;
import com.nsdl.beckn.api.model.init.InitRequest;
import com.nsdl.beckn.api.model.oninit.OnInitMessage;
import com.nsdl.beckn.api.model.oninit.OnInitRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InitTwoService extends BaseService {

    public OnInitRequest orchestratorInitTwo(OnInitRequest onInitOneRequest, String formThreeSubmissionId) throws Exception {
        OnInitRequest onInitTwoRequest = performInitTwo(onInitOneRequest, formThreeSubmissionId);//eNach link in the response
        return onInitTwoRequest;
    }

    public OnInitRequest performInitTwo(OnInitRequest onInitOneRequest, String formThreeSubmisisonId) throws Exception {

        InitRequest initTwoRequest = new InitRequest();

        Context context = openFinanceUtils.prepareRrquestContext(onInitOneRequest.getContext(), ContextAction.INIT.value());
        initTwoRequest.setContext(context);
        initTwoRequest.setMessage(prepareInitTwoMessage(onInitOneRequest, formThreeSubmisisonId));

        log.info("Init 2 REQ  ==========> {}", JsonUtils.toJsonString(initTwoRequest));

        String onInitTwoResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(initTwoRequest), ContextAction.INIT.value(),"INIT_2", initTwoRequest.getContext());
        OnInitRequest onInitTwoRequest = snakeCaseMapper.readValue(onInitTwoResponseString, OnInitRequest.class);

        return onInitTwoRequest;

    }

    private InitMessage prepareInitTwoMessage(OnInitRequest onInit_1_Request, String bankDetailsFormSubmisisonId) throws JsonProcessingException {

        OnInitMessage onInitOneMessage = onInit_1_Request.getMessage();

        InitMessage initTwoMessage = new InitMessage();
        Order order = new Order();

        Provider provider = new Provider();
        Item item = new Item();
        Item onInit2Item = onInitOneMessage.getOrder().getItems().get(0);
        //prepare Xinput
        Xinput xinput = new Xinput();

        Form form = new Form();
        form.setId(onInitOneMessage.getOrder().getItems().get(0).getXinput().getForm().getId());
        xinput.setForm(form);
        xinput.setRequired(null);

        //prepare form response
        XInputFormResponse formResponse = new XInputFormResponse();
        formResponse.setStatus("SUCCESS");
        formResponse.setSubmissionId(bankDetailsFormSubmisisonId);

        xinput.setXInputFormResponse(formResponse);

        item.setId(onInit2Item.getId());//set to itemId from on_search response
        item.setXinput(xinput);//set x_input

       // provider.setId(onSelect2Message.getOrder().getProvider().getId());// provider id from prev select message i.e ==> OnSelectMessage 1

        provider.setId(onInitOneMessage.getOrder().getProvider().getId());//set only provider id
        order.setProvider(provider);
        order.setItems(List.of(item));

        //prepare payment
        List<Payment> payments = openFinanceUtils.prepareInitOnePaymentTags();//fixed values from json file
        payments.get(0).setId(onInitOneMessage.getOrder().getPayments().get(0).getId());
        order.setPayments(payments);

        initTwoMessage.setOrder(order);
        return initTwoMessage;
    }
}

