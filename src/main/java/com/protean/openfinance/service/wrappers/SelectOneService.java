package com.protean.openfinance.service.wrappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsdl.beckn.api.model.common.*;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import com.nsdl.beckn.api.model.select.SelectMessage;
import com.nsdl.beckn.api.model.select.SelectRequest;
import com.protean.openfinance.AdaptorConsumer;
import com.protean.openfinance.dto.form.Form1SubmissionResponse;
import com.protean.openfinance.dto.searchwrapper.SearchWrapperDto;
import com.protean.openfinance.utill.OpenFinanceUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.nsdl.beckn.api.enums.ContextAction.SELECT;

@Service
@Slf4j
public class SelectOneService extends BaseService {

    @Autowired
    @Qualifier("snakeCaseObjectMapper")
    private ObjectMapper snakeCaseMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OpenFinanceUtils openFinanceUtils;

    @Autowired
    private LSPClientService lspClientService;


    @Autowired
    private AdaptorConsumer consumer;

    public List<OnSelectRequest> performSelectOne(List<Form1SubmissionResponse> form1SubmissionResponses, SearchWrapperDto searchWrapperDto) throws JsonProcessingException {

        SelectRequest selectRequest1 = new SelectRequest();
        List<OnSelectRequest> select1ResponseList = new ArrayList<>();

        for(Form1SubmissionResponse form1Response : form1SubmissionResponses) {

            //1.Prepare select 1 request
            Context context = openFinanceUtils.prepareRrquestContext(form1Response.getContext(), SELECT.value());
            SelectMessage message = prepareSelect_1_Message(form1Response);

            selectRequest1.setContext(context);
            selectRequest1.setMessage(message);

	        // Log start
            apiAudit.auditLogs(context, form1Response, searchWrapperDto, selectRequest1);
            //TODO : instead above line ...log [selectRequest_1]

            //2.call select 1
            OnSelectRequest onSelectRequest = null;
            try {

                String responseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(selectRequest1), SELECT.value(),"SELECT_1", selectRequest1.getContext());
                onSelectRequest = snakeCaseMapper.readValue(responseString, OnSelectRequest.class);

            } catch (Exception e) {
                log.warn("skipping select 1 request for {} , cause : {}", selectRequest1.getContext().toString(), ExceptionUtils.getStackTrace(e));
                continue;
            }
            select1ResponseList.add(onSelectRequest);

        }
        return select1ResponseList;

    }

    private SelectMessage prepareSelect_1_Message(Form1SubmissionResponse form1Response) {
        SelectMessage selectMessage = new SelectMessage();
        Order order = new Order();

        Provider provider = new Provider();
        Item item = new Item();

        //prepare Xinput
        Xinput xinput = new Xinput();

        Form form = new Form();
        form.setId(form1Response.getForm().getId());
        xinput.setForm(form);
        xinput.setRequired(null);

        //prepare form response
        XInputFormResponse formResponse = new XInputFormResponse();
        formResponse.setStatus("SUCCESS");
        formResponse.setSubmissionId(form1Response.getSubmissionId());

        xinput.setXInputFormResponse(formResponse);

        item.setId(form1Response.getItemId());//set to itemId from on_search response
        item.setXinput(xinput);//set x_input

        provider.setId(form1Response.getProvider().getId());

        order.setProvider(provider);
        order.setItems(List.of(item));

        selectMessage.setOrder(order);

        return selectMessage;
    }


   /* private OnSelectRequest callAdaptorSelect_1(SelectRequest selectRequest1) throws Exception {

        OnSelectRequest onSelectRequest_1 = null;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        SelectRequest selectRequest = new SelectRequest();
        selectRequest.setContext(selectRequest1.getContext());
        selectRequest.setMessage(selectRequest1.getMessage());

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

            onSelectRequest_1 = snakeCaseMapper.readValue(responseBody, OnSelectRequest.class);

           *//*
           * moved to GetLspRedirect URl
           List<Tags> consentInfoTags = onSelectRequest_1.getMessage().getOrder().getItems().get(0).getTags().stream().filter(orderItemsTag ->
                            orderItemsTag.getDescriptor().getCode().equalsIgnoreCase("CONSENT_INFO"))
                    .collect(Collectors.toList());

            Optional<ListElement> consentHandler = consentInfoTags.get(0).getList().stream().filter(descriptorConsentHandler -> descriptorConsentHandler.getDescriptor().getCode().equalsIgnoreCase("CONSENT_HANDLER")).findFirst();


            //TO DO : if present or else throw
            String consentHandlerId = consentHandler.get().getValue();
            //String authorizationToken = lspClientService.getLspBearerToken();
            //String url = lspClientService.getRedirectUrl(consentHandlerId);*//*


        } else {
            throw new GenericException("Error calling seller");
        }

        return onSelectRequest_1;

    }*/




}

