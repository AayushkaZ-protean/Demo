package com.protean.openfinance.dto.searchwrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class SearchWrapperDto {

    @JsonProperty("txId")
    private String txId;

    @JsonProperty("loanType")
    private String loanType;

    @JsonProperty("consentRedirectUrl")
    private String consentRedirectUrl;

    @JsonProperty("applicantInfo")
    private ApplicantInfo applicantInfo;

}
