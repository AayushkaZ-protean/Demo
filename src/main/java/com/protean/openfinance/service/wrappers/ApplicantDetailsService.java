package com.protean.openfinance.service.wrappers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.Descriptor;
import com.nsdl.beckn.api.model.common.Order;
import com.nsdl.beckn.api.model.common.Provider;
import com.nsdl.beckn.api.model.onconfirm.OnConfirmRequest;
import com.nsdl.beckn.api.model.onselect.OnSelectMessage;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import com.nsdl.beckn.common.exception.ApplicationException;
import com.nsdl.beckn.common.exception.ErrorCode;
import com.protean.openfinance.entity.ApiAudit;
import com.protean.openfinance.entity.ApplicantDetails;
import com.protean.openfinance.repository.ApplicantDetailsPagingRepository;
import com.protean.openfinance.utill.Constant;
import com.protean.openfinance.utill.LoanStatusType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

import static java.text.MessageFormat.format;
import static java.util.Optional.ofNullable;

@Service
@Slf4j
public class ApplicantDetailsService extends BaseService {

    @Autowired
    private ApplicantDetailsPagingRepository applicantDetailsPagingRepository;

    public static final Predicate<Optional<ApiAudit>> isOnConfirmPresent = apiAudit -> apiAudit.isPresent() && StringUtils.isNotBlank(apiAudit.get().getJson());

    public void updateApplicantStatus(HttpHeaders headers, String status, OnSelectRequest onSelectRequest) {

        String txnId = openFinanceUtils.getHeaderByName(Constant.HEADER_TRANSACTION_ID, headers);
        String contactNumber = openFinanceUtils.getHeaderByName(Constant.HEADER_CONTACT_NUMBER, headers);

        if (StringUtils.isNotEmpty(txnId) && StringUtils.isNotEmpty(contactNumber)) {

            Optional<ApplicantDetails> applicantToUpdate = getMostRecentApplicantDetails(txnId, contactNumber);

            applicantToUpdate.ifPresentOrElse(applicant -> {
                applicant.setStatus(status);
                applicant.setUpdatedOn(LocalDateTime.now());
                populateBppDetails(onSelectRequest, applicant);//populated only for select offer api
                applicantDetailsRepository.save(applicant);

            }, () -> {
                String error = format("No transaction record found for contact number");
                throw new ApplicationException(ErrorCode.JSON_PROCESSING_ERROR, error);
            });
        } else {
            throw new ApplicationException(ErrorCode.HEADER_PARSING_FAILED, "Requested header not found");
        }
    }

    public ApplicantDetails getByContactNumberAndStatus(String contactNumber, String status) {

        Optional<ApplicantDetails> esignSubmittedOnConfirmRecord = applicantDetailsRepository.findByContactNumberAndStatus(contactNumber, LoanStatusType.ESIGN_CONFIRM.value())
                .stream()
                .max(Comparator.comparing(ApplicantDetails::getCreatedOn));

        if (!esignSubmittedOnConfirmRecord.isPresent()) {

            log.info("no matching sanctioned loan application found for contact number {} and status {}", contactNumber, status);
            String message = format("No previous sanctioned confirmed loan application found for contact number {0}", contactNumber);
            throw new ApplicationException(ErrorCode.INVALID_ACTION, message);
        }
        return esignSubmittedOnConfirmRecord.get();
    }

    public OnConfirmRequest getOnConfirmByTransactionIdAndContactNumber(HttpHeaders headers) throws JsonProcessingException {

        OnConfirmRequest onConfirmRequest = null;
        String contactNumber = openFinanceUtils.getHeaderByName(Constant.HEADER_CONTACT_NUMBER, headers);
        String transactionId = applicantDetailsService.getByContactNumberAndStatus(contactNumber, LoanStatusType.ESIGN_CONFIRM.value()).getTransactionId();

        log.info("fetching on confirm for txn_id {}, contactNumber {}", transactionId, contactNumber);

        Optional<ApiAudit> apiAudit = apiAuditRepository
                .findByTransactionIdAndContactNumberAndActionIgnoreCase(transactionId, contactNumber, ContextAction.ON_CONFIRM.value())
                .stream()
                .max(Comparator.comparing(ApiAudit::getCreatedOn));

        if (isOnConfirmPresent.test(apiAudit)) {
            onConfirmRequest = snakeCaseMapper.readValue(apiAudit.get().getJson(), OnConfirmRequest.class);
        } else {
            String message = format("No previous sanctioned confirmed loan application found for contact number {0} and transaction {1}", contactNumber, transactionId);
            throw new ApplicationException(ErrorCode.INVALID_ACTION, message);
        }
        return onConfirmRequest;
    }

    @NotNull
    public Optional<ApplicantDetails> getMostRecentApplicantDetails(String txnId, String contactNumber) {
        return applicantDetailsRepository
                .findAllByTransactionIdAndContactNumber(txnId, contactNumber)
                .stream().max(Comparator.comparing(ApplicantDetails::getCreatedOn));
    }

    private void populateBppDetails(OnSelectRequest onSelectRequest, ApplicantDetails applicant) {

        if(Objects.nonNull(onSelectRequest)){
            applicant.setBppId(onSelectRequest.getContext().getBppId());

            String bppName = ofNullable(onSelectRequest)
                        .map(OnSelectRequest::getMessage)
                        .map(OnSelectMessage::getOrder)
                        .map(Order::getProvider)
                        .map(Provider::getDescriptor)
                        .map(Descriptor::getName)
                    .orElse("UNKNOWN BPP");

            applicant.setBppName(bppName);
        }
    }

    public Page<ApplicantDetails> getPaginatedApplicants(int page, int size) {
        return applicantDetailsPagingRepository.findAll(PageRequest.of(page, size));
    }

    public Page<ApplicantDetails> searchApplicants(String searchPhrase, LocalDateTime fromDate, LocalDateTime toDate, int page, int size) {
        return applicantDetailsPagingRepository.findAll(searchPhrase, fromDate, toDate, PageRequest.of(page, size));
    }


}
