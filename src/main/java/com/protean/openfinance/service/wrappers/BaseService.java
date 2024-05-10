package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.NackResponseModel;
import com.protean.openfinance.AdaptorConsumer;
import com.protean.openfinance.exception.LenderException;
import com.protean.openfinance.repository.ApiAuditRepository;
import com.protean.openfinance.repository.ApplicantDetailsRepository;
import com.protean.openfinance.repository.IgmIssueRepository;
import com.protean.openfinance.utill.OpenFinanceUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Objects;

@Slf4j
public class BaseService {

    @Autowired
    @Qualifier("snakeCaseObjectMapper")
    public ObjectMapper snakeCaseMapper;

    @Autowired
    public ObjectMapper objectMapper;

    @Autowired
    public OpenFinanceUtils openFinanceUtils;

    @Autowired
    public LSPClientService lspClientService;

    @Autowired
    public ApiAuditService apiAuditService;

    @Autowired
    public InitTwoService initTwoService;


    @Autowired
    public ApiAuditService apiAudit;

    @Autowired
    public OpenFinanceUtils commonObjectPreparer;

    @Autowired
    public SelectOneService selectService;


    @Autowired
    public SelectTwoService selectTwoService;

    @Autowired
    public SelectThreeService selectThreeService;

    @Autowired
    public ApplicantDetailsRepository applicantDetailsRepository;

    @Autowired
    public ApiAuditService audit;

    @Autowired
    public AdaptorConsumer consumer;

    @Autowired
    public ApiAuditRepository apiAuditRepository;

    @Autowired
    public ApplicantDetailsService applicantDetailsService;

    @Autowired
    public IgmIssueRepository igmIssueRepository;

    public void handleSellerNackIfExists(String response) throws Exception {

        //String response = readJsonFile("/wrapper/errorTest.json");
        //Error error = null;

        NackResponseModel ackNackResponseModel = null;

        if (Objects.nonNull(response) && (response.contains("NACK") || response.contains("error"))) {
            try {
                //String errorField = JsonUtils.toJsonString(JsonPath.read(response, "$.error"));
                //error = objectMapper.readValue(errorField, Error.class);

                 ackNackResponseModel = snakeCaseMapper.readValue(response, NackResponseModel.class);
                log.info("Nack by seller : {}", JsonUtils.toJsonString(ackNackResponseModel));

            } catch (Exception e) {
                log.error("Exception while casting NACK response to ACK-NACK response model : {}", ExceptionUtils.getStackTrace(e));
            }
            if (null != ackNackResponseModel && !ackNackResponseModel.getContext().getAction().equalsIgnoreCase(ContextAction.ON_SELECT.value())) {
                throw new LenderException(ackNackResponseModel);
            }
        }
    }

    public String readJsonFile(String filePath) {
        Object inputJSON = JsonUtils.classpathToObject(filePath);
        return JsonUtils.toPrettyJsonString(inputJSON);
    }
}
