package com.protean.openfinance;

import com.bazaarvoice.jolt.JsonUtils;
import com.nsdl.beckn.api.model.common.Context;
import com.protean.openfinance.exception.GenericException;
import com.protean.openfinance.service.wrappers.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;


@Slf4j
@Service
public class AdaptorConsumer extends BaseService {


    @Value("${adaptor.v2.subscriber.id}")
    public String id;

    @Value("${adaptor.v2.subscriber.short-name}")
    public String shortName;

    @Value("${adaptor.v2.subscriber-url}")
    public String url;

    @Autowired
    public RestTemplate restTemplate;

    public String postOnAdaptor(String requestBody, String action, String eventDescriptor, Context context) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        log.info("Calling Adaptor for ==============   ACTION : {}   ==============", action);
        log.info("Calling Adaptor with Request ======> {}", JsonUtils.toPrettyJsonString(requestBody));

        apiAuditService.adaptorAuditBefore(requestBody, action, eventDescriptor, context);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        String apiUrl = MessageFormat.format("{0}{1}", url, action);

        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        log.info("Response from Adaptor =====> {}", response);

        if (response.getStatusCode() == HttpStatus.OK) {

            String responseBody = response.getBody();
            log.info("Response: {}", responseBody);

            apiAuditService.adaptorAuditAfter(responseBody, action, eventDescriptor, context);

            handleSellerNackIfExists(responseBody);//check if nack and return error code to UI
            return responseBody;
        } else {
            throw new GenericException("Error calling seller");
        }
    }
}
