package com.protean.openfinance.dto.searchwrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nsdl.beckn.api.model.oninit.OnInitRequest;
import lombok.Data;


@Data
public class ConfirmLoanApplicationDto {

    @JsonProperty("loan_status")
    private OnInitRequest loanStatus;

}
