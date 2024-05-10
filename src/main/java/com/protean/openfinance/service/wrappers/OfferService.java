package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import com.protean.openfinance.dto.searchwrapper.OfferWrapperDto;
import com.protean.openfinance.entity.ApiAudit;
import com.protean.openfinance.exception.GenericException;
import com.protean.openfinance.repository.ApiAuditRepository;
import com.protean.openfinance.utill.LoanStatusType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class OfferService {

    @Autowired
    @Qualifier("snakeCaseObjectMapper")
    private ObjectMapper snakeCaseMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SelectTwoService selectTwoService;

    @Autowired
    private ApiAuditRepository apiAuditRepository;

    @Autowired
    private ApplicantDetailsService applicantDetailsService;



    public String offers(OfferWrapperDto offerWrapperDto, HttpHeaders headers) throws JsonProcessingException {

        //List<ApiAudit> apiAuditList = apiAuditRepository.findApiAuditByTransactionId(offerWrapperDto.getTransactionId(), "on_select_1");
        List<ApiAudit> apiAuditList = apiAuditRepository.findByTransactionIdAndActionOrderByCreatedOnDesc(offerWrapperDto.getTransactionId(), "on_select_1");


        log.info("Input to get offer {}", JsonUtils.toPrettyJsonString(offerWrapperDto));
        log.info("Found prev saved on_select_1 response to generate offer select_2 ====> {}", apiAuditList);

        if (!CollectionUtils.isEmpty(apiAuditList)) {

            ApiAudit apiAuditData = apiAuditList.get(0);

            if (apiAuditData != null) {

                String onSelectOneRequestsJson = apiAuditData.getJson();

                log.info("on_select_1 saved json ===> {}", JsonUtils.toPrettyJsonString(onSelectOneRequestsJson));

                List<OnSelectRequest> onSelectOneRequests = List.of(snakeCaseMapper.readValue(onSelectOneRequestsJson, OnSelectRequest[].class));
               /* snakeCaseMapper.readValue(onSelectOneRequestsJson, new TypeReference<List<OnSearchRequest>>() {
                });*/

                log.info("on_select_1 json converted to pojo ===> {}", JsonUtils.toPrettyJsonString(onSelectOneRequests));

                try {

                    List<OnSelectRequest> onSelectTwoRequests = selectTwoService.performSelectTwo(onSelectOneRequests);
                    log.info("on_select_2 response {}", JsonUtils.toJsonString(onSelectTwoRequests));

                    String offers = snakeCaseMapper.writeValueAsString(onSelectTwoRequests);

                    applicantDetailsService.updateApplicantStatus(headers, LoanStatusType.OFFER.value(), null);

                    log.info("returning offers to UI : {}", offers);
                    return offers;

                } catch (JsonProcessingException e) {
                    log.error("Error from get offfer service {}", ExceptionUtils.getStackTrace(e));
                }
            }
        } else {
            throw new GenericException("No Api Audit log found on_select_1 for given txn id");
        }

        return null;
    }
}
