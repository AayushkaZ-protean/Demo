package com.protean.openfinance.service.wrappers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.nsdl.beckn.api.enums.ContextAction;
import com.nsdl.beckn.api.model.common.*;
import com.nsdl.beckn.api.model.issue.IssueMessage;
import com.nsdl.beckn.api.model.issue.IssueRequest;
import com.nsdl.beckn.api.model.issuestatus.IssueStatusMessage;
import com.nsdl.beckn.api.model.issuestatus.IssueStatusRequest;
import com.nsdl.beckn.api.model.onissue.OnIssueRequest;
import com.nsdl.beckn.api.model.onissuestatus.OnIssueStatusRequest;
import com.nsdl.beckn.common.exception.ApplicationException;
import com.nsdl.beckn.common.exception.ErrorCode;
import com.protean.openfinance.dto.issue.IssueCloseRequestDto;
import com.protean.openfinance.dto.issue.IssueRequestDto;
import com.protean.openfinance.dto.issue.IssueResponseDto;
import com.protean.openfinance.entity.ApplicantDetails;
import com.protean.openfinance.entity.IgmIssue;
import com.protean.openfinance.exception.GenericException;
import com.protean.openfinance.utill.Constant;
import com.protean.openfinance.utill.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;

@Service
@Slf4j
public class IgmIssueService extends BaseService {

    @Autowired
    private FileUtils fileUtils;

    public String createIssue(String issueJson, HttpHeaders headers, List<MultipartFile> files) throws Exception {

        Optional<ApplicantDetails> applicantOptional = fetchApplicantByTxnIdAndContactNumber(headers);

        IssueRequestDto issue = snakeCaseMapper.readValue(issueJson, IssueRequestDto.class);
        IssueRequest issueRequest = new IssueRequest();

        Context context = openFinanceUtils.prepareRrquestContext(issue.getOnStatusRequest().getContext(), ContextAction.ISSUE.value());

        issueRequest.setContext(context);
        issueRequest.setMessage(prepareIssueMessage(issue, headers, files, applicantOptional));

        //prepare and send issue req and response
        IssueResponseDto issueResponseDto = new IssueResponseDto();
            String onIssueResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(issueRequest), ContextAction.ISSUE.value(), "IGM_CREATE", context);
            OnIssueRequest onIssueRequest = snakeCaseMapper.readValue(onIssueResponseString, OnIssueRequest.class);

            saveIgmIssue(issueRequest, onIssueRequest, applicantOptional);

            issueResponseDto.setIssueRequest(issueRequest);
            issueResponseDto.setIssueResponse(onIssueRequest);

            //String s = readJsonFile("/wrapper/fileupload.json");
            //IssueResponseDto issueResponseDto1 = snakeCaseMapper.readValue(s, IssueResponseDto.class);

        return snakeCaseMapper.writeValueAsString(issueResponseDto);
    }


    private IssueMessage prepareIssueMessage(IssueRequestDto issue1, HttpHeaders headers, List<MultipartFile> files, Optional<ApplicantDetails> applicant) throws IOException {

        IssueMessage issueMessage = new IssueMessage();

        Issue issue = new Issue();

        issue.setStatus("OPEN");
        issue.setIssueType("ISSUE");
        issue.setCreatedAt(openFinanceUtils.prepareCurrentDateTimeInZonedDatTime());


        //generate igm issue id
        String igmIssueId = generateAndUpdateIgmUniqueIssueId(headers, applicant);

        List<String> pblicUrls =
                fileUtils.uploadFilesAndGenerateUrisGoogleCloud(files, igmIssueId);

        //upload multipart file
        issue.setId(igmIssueId);
        issue.setCategory(issue1.getCategory());
        issue.setSubCategory(issue1.getSubCategory());


        Time expectedResponseTime = new Time();
        expectedResponseTime.setDuration("PT2H");
        issue.setExpectedResponseTime(expectedResponseTime);

        Time expectedResolutionTime = new Time();
        expectedResolutionTime.setDuration("P1D");
        issue.setExpectedResolutionTime(expectedResolutionTime);

        issue.setDescription(issue1.getDescription());//set description
        issue.getDescription().getImages().clear();// add public images url to issue request
        issue.getDescription().getImages().addAll(pblicUrls);// add public images url to issue request


        IssueSource source = new IssueSource();
        source.setType("CONSUMER");
        source.setNetworkParticipantId(issue1.getOnStatusRequest().getContext().getBapId());
        issue.setSource(source);

        IssueOrderDetails orderDetails = new IssueOrderDetails();
        orderDetails.setId(issue1.getOnStatusRequest().getMessage().getOrder().getId());
        orderDetails.setState(issue1.getOnStatusRequest().getMessage().getOrder().getFulfillments().get(0).getState().getDescriptor().getName());
        orderDetails.setProviderId(issue1.getOnStatusRequest().getMessage().getOrder().getProvider().getId());
        issue.setOrderDetails(orderDetails);

        //ComplainantInfo complainantInfo =
        Customer customer = issue1.getOnStatusRequest().getMessage().getOrder().getFulfillments().get(0).getCustomer();
        ComplainantInfo complainantInfo = new ComplainantInfo();
        complainantInfo.setContact(customer.getContact());
        complainantInfo.setPerson(customer.getPerson());
        issue.setComplainantInfo(complainantInfo);


        //Set complainantAction while opening issue
        ComplainantActions openComplainantActions = new ComplainantActions();
        openComplainantActions.setComplainantAction("OPEN");
        openComplainantActions.setShortDesc("Complaint created");
        openComplainantActions.setUpdatedAt(issue.getCreatedAt());

        UpdatedBy updatedBy = new UpdatedBy();
        updatedBy.setContact(issue1.getOnStatusRequest().getMessage().getOrder().getFulfillments().get(0).getCustomer().getContact());
        updatedBy.setPerson(issue1.getOnStatusRequest().getMessage().getOrder().getFulfillments().get(0).getCustomer().getPerson());

        Organization org = new Organization();
        org.setName(issue1.getOnStatusRequest().getContext().getBapId());
        updatedBy.setOrg(org);

        openComplainantActions.setUpdatedBy(updatedBy);
        IssueActions issueActions = new IssueActions();
        issueActions.setComplainantActions(List.of(openComplainantActions));
        issue.setIssueActions(issueActions);

        issueMessage.setIssue(issue);
        return issueMessage;
    }

    private String generateAndUpdateIgmUniqueIssueId(HttpHeaders headers, Optional<ApplicantDetails> applicantToUpdate) {

        String txnId = openFinanceUtils.getHeaderByName(Constant.HEADER_TRANSACTION_ID, headers);
        String contactNumber = openFinanceUtils.getHeaderByName(Constant.HEADER_CONTACT_NUMBER, headers);

        String igmIssueId = checkIssueIdAlreadyExists(generateIgmUniqueIssueId(contactNumber), contactNumber);

        //Optional<ApplicantDetails> applicantToUpdate = applicantDetailsService.getMostRecentApplicantDetails(txnId, contactNumber);

        applicantToUpdate.ifPresentOrElse(applicant -> {

                    //applicant.setStatus("igm_issue_raised");
                    // applicant.setUpdatedOn(LocalDateTime.now());
                    //applicantDetailsRepository.save(applicant);

                   /* IgmIssue issue = new IgmIssue();
                    issue.setIssueId(igmIssueId);
                    issue.setStatus(status);
                    issue.setCreatedOn(LocalDateTime.now());
                    issue.setApplicantDetails(applicant);
                    issue.setJson("");*/

                },
                () -> {
                    throw new GenericException(MessageFormat
                            .format("No matching loan application found for transaction {0} and contact number {1}", txnId, contactNumber));
                });

        return igmIssueId;
    }

    private String checkIssueIdAlreadyExists(String issueId, String contactNumber) {
        if (!igmIssueRepository.existsByIssueId(issueId)) {
            return issueId;
        }
        String newIssueId = generateIgmUniqueIssueId(contactNumber);
        return checkIssueIdAlreadyExists(newIssueId, contactNumber);
    }

    private String generateIgmUniqueIssueId(String contactNumber) {

        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'Z') // range of characters to include
                .filteredBy(Character::isLetterOrDigit) // filter to include only alphanumeric characters
                .build();

        String randomString = generator.generate(6); // generate a 6-character long random string
        return MessageFormat.format("{0}_{1}", "IGM", randomString);
    }


    private Optional<ApplicantDetails> fetchApplicantByTxnIdAndContactNumber(HttpHeaders headers) {

        String txnId = openFinanceUtils.getHeaderByName(Constant.HEADER_TRANSACTION_ID, headers);
        String contactNumber = openFinanceUtils.getHeaderByName(Constant.HEADER_CONTACT_NUMBER, headers);
        return applicantDetailsService.getMostRecentApplicantDetails(txnId, contactNumber);
    }

    private void saveIgmIssue(IssueRequest issueRequest, OnIssueRequest onIssueRequest, Optional<ApplicantDetails> applicant) throws JsonProcessingException {

        log.info("Saving IGM issue id ad status");
        IgmIssue issue = new IgmIssue();
        issue.setIssueId(onIssueRequest.getMessage().getIssue().getId());
        issue.setStatus(onIssueRequest.getMessage().getIssue().getIssueActions().getRespondentActions().get(0).getRespondentAction());
        issue.setCreatedOn(LocalDateTime.now());
        issue.setApplicantDetails(applicant.get());
        issue.setAction(ContextAction.ISSUE.value());
        issue.setTransactionId(applicant.get().getTransactionId());
        issue.setRequest(snakeCaseMapper.writeValueAsString(issueRequest));
        issue.setResponse(snakeCaseMapper.writeValueAsString(onIssueRequest));

        igmIssueRepository.save(issue);
    }

    public List<IssueResponseDto> getIssueDetails(HttpHeaders headers) {

        String txnId = openFinanceUtils.getHeaderByName(Constant.HEADER_TRANSACTION_ID, headers);

        return igmIssueRepository
                .findAllByTransactionIdAndAction(txnId, ContextAction.ISSUE.value())
                .stream()
                    .filter(issue -> !"CLOSED".equalsIgnoreCase(issue.getStatus()))
                    .map(issue-> {

                        IssueResponseDto issueResponseDto = new IssueResponseDto();
                        try {
                            issueResponseDto.setIssueRequest(snakeCaseMapper.readValue(issue.getRequest(), IssueRequest.class));
                            issueResponseDto.setIssueResponse(snakeCaseMapper.readValue(issue.getResponse(), OnIssueRequest.class));

                        } catch (JsonProcessingException e) {
                            throw new ApplicationException(ErrorCode.UNKNOWN_ERROR, "Something went wrong");
                        }
                        return issueResponseDto;
                    })
                .collect(Collectors.toList());
    }

    public OnIssueStatusRequest issueStatus(IssueRequest issueRequest, HttpHeaders headers) throws Exception {

        log.info("issue status {}", issueRequest);

        IssueStatusRequest issueStatusRequest = new IssueStatusRequest();
        Context context = openFinanceUtils.prepareRrquestContext(issueRequest.getContext(), ContextAction.ISSUE_STATUS.value());
        issueStatusRequest.setContext(context);
        issueStatusRequest.setMessage(prepareIssueStatusMessage(issueRequest));

        //prepare and send issue req and response
        String onIssueStatusResponseString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(issueStatusRequest), ContextAction.ISSUE_STATUS.value(), "IGM_ISSUE_STATUS", context);
        OnIssueStatusRequest onIssueStatusRequest = snakeCaseMapper.readValue(onIssueStatusResponseString, OnIssueStatusRequest.class);

        //update IGM issue_status
        updateIgmIssueStatus(onIssueStatusRequest);
        log.info("on_issue_status {} for headers {}", onIssueStatusRequest, headers.toString());
        return onIssueStatusRequest;

    }


    private IssueStatusMessage prepareIssueStatusMessage(IssueRequest issueRequest) {
        IssueStatusMessage issueStatusMessage = new IssueStatusMessage();
        issueStatusMessage.setIssueId(issueRequest.getMessage().getIssue().getId());
        return issueStatusMessage;
    }


    private void updateIgmIssueStatus(OnIssueStatusRequest onIssueStatusRequest) {

        igmIssueRepository.findByIssueId(onIssueStatusRequest.getMessage().getIssue().getId()).ifPresentOrElse(igmIssueToUpdate -> {

            igmIssueToUpdate.setUpdatedOn(LocalDateTime.now());
            igmIssueToUpdate.setStatus(onIssueStatusRequest.getMessage().getIssue().getIssueActions().getRespondentActions().get(0).getRespondentAction());

            try {
                igmIssueToUpdate.setStatusResponse(snakeCaseMapper.writeValueAsString(onIssueStatusRequest));
            } catch (JsonProcessingException e) {
                throw new ApplicationException(ErrorCode.UNKNOWN_ERROR, ErrorCode.UNKNOWN_ERROR.getMessage());
            }

            igmIssueRepository.save(igmIssueToUpdate);//update igm issue status

        }, () -> {
            String error = format("Invalid IGM issue id provided");
            throw new ApplicationException(ErrorCode.JSON_PROCESSING_ERROR, error);
        });
    }

    public List<IssueResponseDto> getIssueDetailsByStatus(HttpHeaders headers, String status) {
        String txnId = openFinanceUtils.getHeaderByName(Constant.HEADER_TRANSACTION_ID, headers);

        return igmIssueRepository.findAllByTransactionIdAndStatus(txnId, status)
                .stream()
                    .map(this::buildIssueResponseDto)
                .collect(Collectors.toList());
    }

    private IssueResponseDto buildIssueResponseDto(IgmIssue issue) {

        IssueResponseDto issueResponseDto = new IssueResponseDto();
        try {
            issueResponseDto.setIssueRequest(snakeCaseMapper.readValue(issue.getRequest(), IssueRequest.class));
            issueResponseDto.setIssueResponse(snakeCaseMapper.readValue(issue.getResponse(), OnIssueRequest.class));
            issueResponseDto.setOnIssueStatusRequest(snakeCaseMapper.readValue(issue.getStatusResponse(), OnIssueStatusRequest.class));
        } catch (JsonProcessingException e) {
            throw new ApplicationException(ErrorCode.UNKNOWN_ERROR);
        }
        return issueResponseDto;
    }

    public void closeIssue(IssueCloseRequestDto issueCloseRequestDto) {

        Optional<IgmIssue> igmIssueOptional = igmIssueRepository.findByIssueId(issueCloseRequestDto.getIssueId());

        igmIssueOptional.ifPresentOrElse(igmIssue -> {

            IssueRequest closeIssueRequest = new IssueRequest();

            try {
                IssueRequest issueCreationRequest = snakeCaseMapper.readValue(igmIssue.getRequest(), IssueRequest.class);
                closeIssueRequest.setContext(openFinanceUtils.prepareRrquestContext(issueCreationRequest.getContext(), ContextAction.ISSUE.value()));
                closeIssueRequest.setMessage(prepareCloseIssueMessage(igmIssue, issueCloseRequestDto));

                String closeOnIssueRequestString = consumer.postOnAdaptor(snakeCaseMapper.writeValueAsString(closeIssueRequest),ContextAction.ISSUE.value(), "IGM_ISSUE_CLOSE", closeIssueRequest.getContext());

                igmIssue.setStatusResponse(closeOnIssueRequestString);
                igmIssue.setStatus("CLOSED");
                igmIssueRepository.save(igmIssue);

            } catch (Exception e){
                throw new ApplicationException(ErrorCode.UNKNOWN_ERROR, "Error while closing IGM issue");
            }

        }, () -> {
            throw new GenericException("IGM issue does not exists");
        });
    }

    private IssueMessage prepareCloseIssueMessage(IgmIssue igmIssue, IssueCloseRequestDto closeRequestDto) throws JsonProcessingException {

        IssueRequest issueRequest = snakeCaseMapper.readValue(igmIssue.getRequest(), IssueRequest.class);

            IssueMessage closeIssueMessage = new IssueMessage();

                Issue issue = issueRequest.getMessage().getIssue();
                issue.setStatus("CLOSED");
                issue.setIssueType("ISSUE");

                issue.setUpdatedAt(openFinanceUtils.prepareCurrentDateTimeInZonedDatTime());
                issue.setRating(closeRequestDto.getRating());

                IssueSource source = new IssueSource();
                source.setType("CONSUMER");
                source.setNetworkParticipantId(issueRequest.getContext().getBapId());
                issue.setSource(source);

                //Set complainantAction while closing issue
                ComplainantActions closeComplainantActions = new ComplainantActions();
                closeComplainantActions.setComplainantAction("CLOSED");
                closeComplainantActions.setShortDesc("Complaint closed");
                closeComplainantActions.setUpdatedAt(openFinanceUtils.prepareCurrentDateTimeInZonedDatTime());

                UpdatedBy updatedBy = issueRequest.getMessage().getIssue().getIssueActions().getComplainantActions().get(0).getUpdatedBy();
                closeComplainantActions.setUpdatedBy(updatedBy);

                IssueActions issueActions = issue.getIssueActions();
                issueActions.getComplainantActions().add(closeComplainantActions);//adding close issue object in existing[create request]
                issue.setIssueActions(issueActions);

            closeIssueMessage.setIssue(issue);

    return closeIssueMessage;
    }

    public List<IssueResponseDto> getAllIssueWithStatus(HttpHeaders headers) {

        String txnId = openFinanceUtils.getHeaderByName(Constant.HEADER_TRANSACTION_ID, headers);

        return igmIssueRepository
            .findAllByTransactionIdAndAction(txnId, ContextAction.ISSUE.value())
                .stream()
                    .filter(issue -> !"CLOSED".equalsIgnoreCase(issue.getStatus()))
                    .map(issue-> {

                        IssueResponseDto issueResponseDto = new IssueResponseDto();
                        try {

                            IssueRequest issueRequest = snakeCaseMapper.readValue(issue.getRequest(), IssueRequest.class);
                            issueResponseDto.setIssueRequest(issueRequest);

                            issueResponseDto.setIssueResponse(snakeCaseMapper.readValue(issue.getResponse(), OnIssueRequest.class));
                            OnIssueStatusRequest recentOnIssueStatus = issueStatus(issueRequest, headers);

                            issueResponseDto.setOnIssueStatusRequest(recentOnIssueStatus);

                        } catch (Exception e) {
                            throw new ApplicationException(ErrorCode.UNKNOWN_ERROR, ErrorCode.UNKNOWN_ERROR.getMessage());
                        }
                        return issueResponseDto;
                    })
            .collect(Collectors.toList());
    }

}
