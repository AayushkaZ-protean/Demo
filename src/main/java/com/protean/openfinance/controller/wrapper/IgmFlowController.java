package com.protean.openfinance.controller.wrapper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsdl.beckn.api.model.issue.IssueRequest;
import com.nsdl.beckn.api.model.onissuestatus.OnIssueStatusRequest;
import com.protean.openfinance.dto.issue.IgmIssueList;
import com.protean.openfinance.dto.issue.IssueCloseRequestDto;
import com.protean.openfinance.dto.issue.IssueResponseDto;
import com.protean.openfinance.service.wrappers.IgmIssueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@Slf4j
@RequestMapping(value = "/igm/issue", produces = "application/json")
public class IgmFlowController {

    @Autowired
    @Qualifier("snakeCaseObjectMapper")
    public ObjectMapper snakeCaseMapper;

    @Autowired
    private IgmIssueService igmIssueService;

    @PostMapping
    public ResponseEntity<String> createIssue(@RequestParam (value = "issue", required = true) String issue,
                                                        @RequestHeader HttpHeaders headers,
                                                        @RequestParam(value = "files", required = false) List<MultipartFile> files) throws Exception {

        return new ResponseEntity<>(igmIssueService.createIssue(issue, headers, files), HttpStatus.CREATED);
    }

    @Deprecated
    @GetMapping("/list")
    public ResponseEntity<String> getIssueDetails(@RequestHeader HttpHeaders headers) throws JsonProcessingException {

        List<IssueResponseDto> issueDetails = igmIssueService.getIssueDetails(headers);
        IgmIssueList issueList = new IgmIssueList();
        issueList.setIssues(issueDetails);

        return new ResponseEntity<>(snakeCaseMapper.writeValueAsString(issueList), HttpStatus.OK);
    }

    @PostMapping("/status")
    public ResponseEntity<OnIssueStatusRequest> issueStatus(@RequestBody IssueRequest issueRequest, @RequestHeader HttpHeaders headers) throws Exception {

        return new ResponseEntity<>(igmIssueService.issueStatus(issueRequest, headers), HttpStatus.CREATED);
    }

    @GetMapping("/{status}")
    public ResponseEntity<String> getIssueDetails(@RequestHeader HttpHeaders headers, @PathVariable(value = "status") String status) throws Exception {

        List<IssueResponseDto> issueDetails = igmIssueService.getIssueDetailsByStatus(headers, status);
        IgmIssueList issueList = new IgmIssueList();
        issueList.setIssues(issueDetails);

        return new ResponseEntity<>(snakeCaseMapper.writeValueAsString(issueList), HttpStatus.OK);
    }

    @PutMapping("/close")
    public ResponseEntity<String> closeIssue(@RequestHeader HttpHeaders headers,
                                             @RequestBody IssueCloseRequestDto issueCloseRequest) throws Exception {

        igmIssueService.closeIssue(issueCloseRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> getAllIssueWithStatus(@RequestHeader HttpHeaders headers) throws Exception {

        List<IssueResponseDto> issueDetails = igmIssueService.getAllIssueWithStatus(headers);
        IgmIssueList issueList = new IgmIssueList();
        issueList.setIssues(issueDetails);

        return new ResponseEntity<>(snakeCaseMapper.writeValueAsString(issueList), HttpStatus.OK);
    }
}
