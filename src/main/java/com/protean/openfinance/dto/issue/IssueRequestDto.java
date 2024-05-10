package com.protean.openfinance.dto.issue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nsdl.beckn.api.model.common.IssueDescriptor;
import com.nsdl.beckn.api.model.onstatus.OnStatusRequest;
import lombok.Data;

@Data
public class IssueRequestDto {

    @JsonProperty("on_status")
    private OnStatusRequest onStatusRequest;

    @JsonProperty("description")
    private IssueDescriptor description;

    @JsonProperty("category")
    private String category;

    @JsonProperty("sub_category")
    private String subCategory;

}
