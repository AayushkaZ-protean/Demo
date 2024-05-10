package com.protean.openfinance.dto.issue;

import com.nsdl.beckn.api.model.issue.IssueRequest;
import com.nsdl.beckn.api.model.onissue.OnIssueRequest;
import com.nsdl.beckn.api.model.onissuestatus.OnIssueStatusRequest;
import lombok.Data;

@Data
public class IssueResponseDto {

    private IssueRequest issueRequest;
    private OnIssueRequest issueResponse;
    private OnIssueStatusRequest onIssueStatusRequest;
}
