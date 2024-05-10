package com.protean.openfinance.dto.issue;

import com.nsdl.beckn.api.model.issue.IssueRequest;
import com.nsdl.beckn.api.model.onissue.OnIssueRequest;
import lombok.Data;

import java.util.List;

@Data
public class IgmIssueList {

   private List<IssueResponseDto> issues;
}
