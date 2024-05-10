package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.*;
import com.nsdl.beckn.api.model.init.InitMessage;
import com.nsdl.beckn.api.model.init.InitRequest;
import com.nsdl.beckn.api.model.oninit.OnInitMessage;
import com.nsdl.beckn.api.model.oninit.OnInitRequest;
import com.protean.openfinance.dto.searchwrapper.PostEnachFinalAgreementDto;
import com.protean.openfinance.utill.LoanStatusType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InitThreeService extends BaseService {

    public OnInitRequest orchestratorInitThree(PostEnachFinalAgreementDto finalAgreementDto, HttpHeaders headers) throws Exception {

        OnInitRequest onInitThreeRequest = performInitThree(finalAgreementDto.getPostEnach(), headers);////eSign link
        return onInitThreeRequest;
    }

    public OnInitRequest performInitThree(OnInitRequest onInitTwoRequest, HttpHeaders headers) throws Exception {

        String submissionId = openFinanceUtils.onStatusSubmissionIdFromApiAuditOrAdaptorCall(onInitTwoRequest.getContext());

        InitRequest initThreeRequest = new InitRequest();
        initThreeRequest.setContext(openFinanceUtils.prepareRrquestContext(onInitTwoRequest.getContext(), ContextAction.INIT.value()));
        initThreeRequest.setMessage(prepareInitThreeMessage(onInitTwoRequest, submissionId));

        log.info("Init 3 REQ  ==========> {}", JsonUtils.toJsonString(initThreeRequest));

        String onInitThreeResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(initThreeRequest), ContextAction.INIT.value(),"INIT_3", initThreeRequest.getContext());
        OnInitRequest onInitThreeRequest = snakeCaseMapper.readValue(onInitThreeResponseString, OnInitRequest.class);

        applicantDetailsService.updateApplicantStatus(headers, LoanStatusType.ENACH.name(), null);
        return onInitThreeRequest;
    }

    private InitMessage prepareInitThreeMessage(OnInitRequest onInitTwoRequest, String enachSubmissionId) throws JsonProcessingException {

        OnInitMessage onInitTwoMessage = onInitTwoRequest.getMessage();

        InitMessage initThreeMessage = new InitMessage();
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
        payments.get(0).setId(onInitTwoRequest.getMessage().getOrder().getPayments().get(0).getId());
        order.setPayments(payments);

        initThreeMessage.setOrder(order);
        return initThreeMessage;
    }
}

