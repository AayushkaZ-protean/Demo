package com.protean.openfinance.service.wrappers;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsdl.beckn.api.model.common.Context;
import com.nsdl.beckn.api.model.object.ObjectRequest;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import com.nsdl.beckn.api.model.onstatus.OnStatusRequest;
import com.nsdl.beckn.api.model.search.SearchRequest;
import com.nsdl.beckn.api.model.select.SelectRequest;
import com.protean.openfinance.dto.form.Form1SubmissionResponse;
import com.protean.openfinance.dto.searchwrapper.SearchWrapperDto;
import com.protean.openfinance.entity.ApiAudit;
import com.protean.openfinance.entity.ApplicantDetails;
import com.protean.openfinance.repository.ApiAuditRepository;
import com.protean.openfinance.repository.ApplicantDetailsRepository;
import com.protean.openfinance.utill.Constant;
import com.protean.openfinance.utill.OpenFinanceUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ApiAuditService {

    @Autowired
    private ApiAuditRepository apiAuditRepository;

    @Autowired
    private ApplicantDetailsRepository applicantDetailsRepository;

    @Autowired
    private OpenFinanceUtils openFinanceUtils;

    @Autowired
    @Qualifier("snakeCaseObjectMapper")
    private ObjectMapper snakeCaseMapper;


    @Autowired
    public ObjectMapper objectMapper;

    public void auditLogs(String action, SearchWrapperDto searchWrapperDto, SearchRequest searchRequest) {
        try {
            ApiAudit logs = new ApiAudit();
            logs.setAction(action);
            logs.setTransactionId(searchWrapperDto.getTxId());
            logs.setAa_id(searchWrapperDto.getApplicantInfo().getAa_id());
            ObjectMapper objectMapper = new ObjectMapper();
            logs.setJson(objectMapper.writeValueAsString(searchWrapperDto));
           // logs.setRequest(objectMapper.writeValueAsString(searchWrapperDto));
            logs.setMessageId(searchRequest.getContext().getMessageId());
            logs.setAa_id(searchWrapperDto.getApplicantInfo().getAa_id());
            logs.setCreatedOn(LocalDateTime.now());
            logs.setContactNumber(searchWrapperDto.getApplicantInfo().getContactNumber());

            apiAuditRepository.save(logs);

            //saveApplicationDetails(searchWrapperDto);

        } catch (Exception e) {
            log.error("Error while saving api audit {}", ExceptionUtils.getStackTrace(e));
        }
    }

    public void saveApplicationDetails(SearchWrapperDto searchWrapperDto, String loanStatusType) {
        ApplicantDetails applicantDetails = new ApplicantDetails();
        applicantDetails.setFirstName(searchWrapperDto.getApplicantInfo().getFirstName());
        applicantDetails.setLastName(searchWrapperDto.getApplicantInfo().getLastName());
        applicantDetails.setDob(searchWrapperDto.getApplicantInfo().getDob());
        applicantDetails.setPan(searchWrapperDto.getApplicantInfo().getPan());
        applicantDetails.setContactNumber(searchWrapperDto.getApplicantInfo().getContactNumber());
        applicantDetails.setEmploymentType(searchWrapperDto.getApplicantInfo().getEmploymentType());
        applicantDetails.setIncome(searchWrapperDto.getApplicantInfo().getIncome());
        applicantDetails.setCompanyName(searchWrapperDto.getApplicantInfo().getCompanyName());
        applicantDetails.setUdyamNumber(searchWrapperDto.getApplicantInfo().getUdyamNumber());
        applicantDetails.setAddressL1(searchWrapperDto.getApplicantInfo().getAddressL1());
        applicantDetails.setAddressL2(searchWrapperDto.getApplicantInfo().getAddressL2());
        applicantDetails.setCity(searchWrapperDto.getApplicantInfo().getBureauConsent());
        applicantDetails.setState(searchWrapperDto.getApplicantInfo().getState());
        applicantDetails.setPincode(searchWrapperDto.getApplicantInfo().getPincode());
        applicantDetails.setAa_id(searchWrapperDto.getApplicantInfo().getAa_id());
        applicantDetails.setAaCode(searchWrapperDto.getApplicantInfo().getAaCode());
        applicantDetails.setTransactionId(searchWrapperDto.getTxId());
        applicantDetails.setBureauConsent(searchWrapperDto.getApplicantInfo().getBureauConsent());
        applicantDetails.setCreatedOn(LocalDateTime.now());
        applicantDetails.setStatus(loanStatusType);
        applicantDetails.setAgentId(searchWrapperDto.getApplicantInfo().getAgentId());
        applicantDetailsRepository.save(applicantDetails);
    }

    public void auditLogs(Context context, Form1SubmissionResponse form1Response, SearchWrapperDto searchWrapperDto, SelectRequest selectRequest_1) {
    	 ApiAudit logs = new ApiAudit();
         logs.setTransactionId(context.getTransactionId());
         logs.setAa_id(searchWrapperDto.getApplicantInfo().getAa_id());
         logs.setJson(JsonUtils.toJsonString(selectRequest_1));
         logs.setMessageId(context.getMessageId());        
         logs.setCreatedOn(LocalDateTime.now());
         apiAuditRepository.save(logs);
    }

	public void auditLogs(String action, SearchRequest searchRequest, Object result) throws JsonProcessingException {
		ApiAudit logs = new ApiAudit();
		logs.setAction(action);
        logs.setTransactionId(searchRequest.getContext().getTransactionId());                
        logs.setJson(JsonUtils.toJsonString(result));
        //logs.setJson(objectMapper.writeValueAsString(result));
        logs.setMessageId(searchRequest.getContext().getMessageId());        
        logs.setCreatedOn(LocalDateTime.now());
        apiAuditRepository.save(logs);
    }

	public void auditLogs(String action, SearchRequest searchRequest, String result) {
		ApiAudit logs = new ApiAudit();
		logs.setAction(action);
        logs.setTransactionId(searchRequest.getContext().getTransactionId());                
        logs.setJson(JsonUtils.toJsonString(result));           
        logs.setMessageId(searchRequest.getContext().getMessageId());        
        logs.setCreatedOn(LocalDateTime.now());
        apiAuditRepository.save(logs);
	}

	
	public void auditLogs(String action, SearchWrapperDto searchWrapperDto, List<OnSelectRequest> onSelect_1_Requests) throws JsonProcessingException {
		ApiAudit logs = new ApiAudit();
		logs.setAction(action);
        logs.setTransactionId(searchWrapperDto.getTxId());
        //logs.setRequest(snakeCaseMapper.writeValueAsString(onSelect_1_Requests));
        //logs.setJson(JsonUtils.toJsonString(onSelect_1_Requests));
        logs.setJson(snakeCaseMapper.writeValueAsString(onSelect_1_Requests));
        logs.setTransactionId(searchWrapperDto.getTxId());       
        logs.setCreatedOn(LocalDateTime.now());
        apiAuditRepository.save(logs);
	}


    public void auditOnSelect3(String action, OnSelectRequest onSelect_3_Request, HttpHeaders headers) throws JsonProcessingException {

        String contactNumber = openFinanceUtils.getHeaderByName(Constant.HEADER_CONTACT_NUMBER, headers);

        ApiAudit logs = new ApiAudit();
        logs.setAction(action);
        logs.setTransactionId(onSelect_3_Request.getContext().getTransactionId());
        logs.setMessageId(onSelect_3_Request.getContext().getMessageId());
        logs.setContactNumber(contactNumber);
        logs.setJson(snakeCaseMapper.writeValueAsString(onSelect_3_Request));
        logs.setCreatedOn(LocalDateTime.now());
        apiAuditRepository.save(logs);
    }

    public void saveOnStatusResponse(OnStatusRequest onStatusFromAdaptor) throws JsonProcessingException {

//        OnStatusRequest onStatusRequest = snakeCaseMapper.readValue(onStatusFromAdaptor, OnStatusRequest.class);
        Context context = onStatusFromAdaptor.getContext();

        ApiAudit apiAudit = new ApiAudit();

        apiAudit.setTransactionId(context.getTransactionId());
        apiAudit.setAction(context.getAction());
        apiAudit.setJson(snakeCaseMapper.writeValueAsString(onStatusFromAdaptor));
        apiAudit.setCreatedOn(LocalDateTime.now());
        apiAudit.setMessageId(context.getMessageId());


        apiAuditRepository.save(apiAudit);
    }

    public List<ApiAudit> getApiAudits(Context context)
    {
        String transactionId = context.getTransactionId();
        String action = "on_status";

//        Not taking for now as per the query
//        String sellerId = onSelectRequest.getContext().getBppId();


        List<ApiAudit> apiAuditList = apiAuditRepository.findApiAuditByTransactionId(transactionId, action)
                .stream()
                .sorted(Comparator.comparing(ApiAudit::getCreatedOn)).collect(Collectors.toList());
        return apiAuditRepository.findApiAuditByTransactionId(transactionId, action);
    }



    @Async(value = "commonExecutor")
    public void adaptorAuditBefore(String requestBody, String action, String eventDescriptor, Context context) {
        log.info("adaptor audit before");
        try {
            ApiAudit auditBefore = new ApiAudit();
            auditBefore.setTransactionId(context.getTransactionId());
            auditBefore.setMessageId(context.getMessageId());
            auditBefore.setAction(MessageFormat.format("{0}{1}", "on_", action));
            //auditBefore.setJson(snakeCaseMapper.writeValueAsString(requestBody));
            auditBefore.setJson(requestBody);
            auditBefore.setCreatedOn(LocalDateTime.now());
            auditBefore.setSellerId(context.getBppId());
            auditBefore.setBuyerId(context.getBapId());
            auditBefore.setEventDescriptor(eventDescriptor);
            apiAuditRepository.save(auditBefore);

        } catch (Exception e) {
            log.error("Exception while auditingBefore {}", ExceptionUtils.getStackTrace(e));
        }
    }

    @Async(value = "commonExecutor")
    public void adaptorAuditAfter(String requestBody, String action, String eventDescriptor, Context context) {
        log.info("adaptor audit after");
        try {

            if (Objects.nonNull(requestBody) && !(requestBody.contains("NACK") || requestBody.contains("error"))) {
                ObjectRequest objectRequest = snakeCaseMapper.readValue(requestBody, ObjectRequest.class);

                ApiAudit auditBefore = new ApiAudit();
                auditBefore.setTransactionId(objectRequest.getContext().getTransactionId());
                auditBefore.setMessageId(objectRequest.getContext().getMessageId());
                auditBefore.setAction(MessageFormat.format("{0}{1}", "on_", action));
//                auditBefore.setJson(snakeCaseMapper.writeValueAsString(requestBody));
                auditBefore.setJson(requestBody);
                auditBefore.setCreatedOn(LocalDateTime.now());
                auditBefore.setSellerId(objectRequest.getContext().getBppId());
                auditBefore.setBuyerId(objectRequest.getContext().getBapId());
                auditBefore.setEventDescriptor(MessageFormat.format("{0}{1}", "on_", eventDescriptor));
                apiAuditRepository.save(auditBefore);
            }

        } catch (Exception e) {
            log.error("Exception while auditingBefore {}", ExceptionUtils.getStackTrace(e));
        }
    }

    @Async(value = "commonExecutor")
    public void apiAuditLoanSummary(String requestBody, String action, String eventDescriptor, Context context, String contactNumber) {
        log.info("adaptor audit after");
        try {

            if (Objects.nonNull(requestBody) && !(requestBody.contains("NACK") || requestBody.contains("error"))) {
                ObjectRequest objectRequest = snakeCaseMapper.readValue(requestBody, ObjectRequest.class);

                ApiAudit auditBefore = new ApiAudit();
                auditBefore.setTransactionId(objectRequest.getContext().getTransactionId());
                auditBefore.setMessageId(objectRequest.getContext().getMessageId());
                auditBefore.setAction(action);
                auditBefore.setJson(requestBody);
                auditBefore.setSellerId(objectRequest.getContext().getBppId());
                auditBefore.setCreatedOn(LocalDateTime.now());
                auditBefore.setBuyerId(objectRequest.getContext().getBapId());
                auditBefore.setContactNumber(contactNumber);
                auditBefore.setEventDescriptor(eventDescriptor);
                apiAuditRepository.save(auditBefore);
            }

        } catch (Exception e) {
            log.error("Exception while auditingBefore {}", ExceptionUtils.getStackTrace(e));
        }
    }
}
