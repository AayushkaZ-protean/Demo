package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsdl.beckn.api.model.common.ListElement;
import com.nsdl.beckn.api.model.common.Tags;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import com.protean.openfinance.dto.lsp.LspBody;
import com.protean.openfinance.dto.lsp.LspHeader;
import com.protean.openfinance.dto.lsp.LspRequest;
import com.protean.openfinance.dto.searchwrapper.SearchWrapperDto;
import com.protean.openfinance.exception.GenericException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LSPClientService {

    @Autowired
    @Qualifier("snakeCaseObjectMapper")
    private ObjectMapper snakeCaseMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${lsp.consent-request.header.rid}")
    private String rid;

    @Value("${lsp.consent-request.header.channel-id}")
    private String channelId;

    @Value("${lsp.consent-request.body.lsp-id}")
    private String lspId;

    @Value("${lsp.consent-request.encrypt-url}")
    private String encryptLspConsentRequestUrl;

    @Value("${lsp.consent-request.token-url}")
    private String lspTokenUrl;



    public String getLspBearerToken() throws JsonProcessingException {

        String token = null;

        // Define the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // Define the request body
        String requestBody = prepareLspTokenRequest();

        // Create the HTTP entity with headers and body
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(lspTokenUrl, HttpMethod.POST, requestEntity, String.class);


        if (response.getStatusCode() == HttpStatus.OK && !response.getBody().contains("NACK")) {

            String responseBody = response.getBody();
            log.info("lsp token response {}", responseBody);
            log.info("lsp response status code {}", response.getStatusCode());
            log.info("lsp response body {}", responseBody);

            LspRequest lspRequest = objectMapper.readValue(responseBody, LspRequest.class);
            token = lspRequest.getBody().getToken();

            if(StringUtils.isEmpty(token)){
                log.error("lsp response {}", responseBody);
                throw new GenericException("Empty barer toke  from lsp");
            }

        } else {
            throw new GenericException("Error calling lsp get token api");
        }
       return token;
    }

    private String prepareLspTokenRequest() {

        LspRequest lspRequest = new LspRequest();

        LspHeader header = new LspHeader();

        // Format the current date and time using the formatter
        String formattedDateTime = getOffSetDateTimeString();

        header.setTs(formattedDateTime);
        header.setRid(rid);
        header.setChannelId(channelId);

        LspBody body = new LspBody();
        body.setPassword("7777");
        body.setUserId("channel@dhanaprayoga");

        lspRequest.setBody(body);
        lspRequest.setHeader(header);

        return JsonUtils.toJsonString(lspRequest);
    }

    public String getRedirectUrl(List<OnSelectRequest> onSelectOneRequests, SearchWrapperDto searchWrapperDto) throws JsonProcessingException {

        String authorizationToken = getLspBearerToken();

        List<String> collectConsentHandleIds = collectConsentHandleId(onSelectOneRequests);

        if(CollectionUtils.isNotEmpty(collectConsentHandleIds)) {
            //call lsp redirect endpoint request
            return getEncryptLspConsentRequest(collectConsentHandleIds, authorizationToken, searchWrapperDto);
        }else {
            throw new GenericException("Empty AA redirection link response");
        }

    }

    /**
     * @param consentHandleIds
     * @param authorizationToken
     * @param searchWrapperDto
     * @return
     * @throws JsonProcessingException
     * @url to be called - https://dhanaprayoga.fiu.finfactor.in/finsense/API/V1/EncryptLspConsentRequest
     */
    private String getEncryptLspConsentRequest(List<String> consentHandleIds, String authorizationToken, SearchWrapperDto searchWrapperDto) throws JsonProcessingException {


        String responseBody = null;
        // Define the URL

        // Define the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", MessageFormat.format("Bearer {0}", authorizationToken)); // Replace with your actual token
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Define the request body
        LspRequest lspRequest = prepareLspEncryptConsentRequest(consentHandleIds, searchWrapperDto);
        String requestBody = JsonUtils.toJsonString(lspRequest);

        // Create the HTTP entity with headers and body
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(encryptLspConsentRequestUrl, HttpMethod.POST, requestEntity, String.class);


        if (response.getStatusCode() == HttpStatus.OK) {

            responseBody = response.getBody();
            log.info("lsp token response {}", responseBody);
            log.info("lsp response status code {}", response.getStatusCode());
            log.info("lsp response body {}", responseBody);

        } else {
            log.error("Error calling EncryptLspConsentRequest");
            throw new GenericException("Error calling EncryptLspConsentRequest");
        }

        return responseBody;

    }

    private LspRequest prepareLspEncryptConsentRequest(List<String> consentHandleIds, SearchWrapperDto searchWrapperDto) {

        log.info("preparing EncryptLspConsentRequest for consentHandleIds {}", consentHandleIds);

        LspRequest lspRequest = new LspRequest();
        LspHeader header = new LspHeader();

        String formattedDateTime = getOffSetDateTimeString();

        header.setTs(formattedDateTime);
        header.setRid(rid);//"445e7f8c-22eb-4c09-b6d9-677ef59dbc29"
        header.setChannelId(channelId);//finsense

        LspBody body = new LspBody();
        body.setLspId(lspId);//loanseva
        body.setUserId(searchWrapperDto.getApplicantInfo().getAa_id());
        body.setUrl("https://sdkredirect.finvu.in/");
        body.setReturnUrl(searchWrapperDto.getConsentRedirectUrl());

        body.setConsentHandles(consentHandleIds);

        lspRequest.setBody(body);
        lspRequest.setHeader(header);

        log.info("prepared EncryptLspConsentRequest {}", lspRequest);

        return lspRequest;
    }

    @NotNull
    private static String getOffSetDateTimeString() {
        // Get the current date and time with the time zone offset
        OffsetDateTime currentDateTime = OffsetDateTime.now();
        // Define the formatter for the ISO 8601 format including milliseconds and the time zone offset
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        // Format the current date and time using the formatter
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }


    //collect consent handle request from first select response
    private List<String> collectConsentHandleId(List<OnSelectRequest> onSelect1Requests) {

        List<String> consentHandles = new ArrayList<>();

        for(OnSelectRequest onSelectRequest : onSelect1Requests) {

            log.info("fetching consent handler id for {}", onSelectRequest.getContext().getBppId());

            List<Tags> consentInfoTags = onSelectRequest.getMessage().getOrder().getItems().get(0).getTags()
                    .stream()
                        .filter(orderItemsTag ->
                            orderItemsTag.getDescriptor().getCode().equalsIgnoreCase("CONSENT_INFO"))
                    .collect(Collectors.toList());

            Optional<ListElement> consentHandler = consentInfoTags.get(0).getList()
                    .stream()
                        .filter(descriptorConsentHandler ->
                                descriptorConsentHandler.getDescriptor().getCode()
                                        .equalsIgnoreCase("CONSENT_HANDLER"))
                    .findFirst();

            //Optional<ListElement> consentHandler = consentInfoTags.get(0).getList().stream().filter(descriptorConsentHandler -> descriptorConsentHandler.getDescriptor().getCode().equalsIgnoreCase("CONSENT_HANDLER")).findFirst();

            if(consentHandler.isPresent()) {
                consentHandles.add(consentHandler.get().getValue());
            }else{
                log.warn("consent handler not found in the request {}", JsonUtils.toJsonString(onSelectRequest));
                throw new GenericException("Consent handler id not found for the BPP "+onSelectRequest.getContext().getBppId());
            }
        }

        return consentHandles;
    }
}
