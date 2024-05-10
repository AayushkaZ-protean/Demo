package com.protean.openfinance.dto.searchwrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nsdl.beckn.api.model.onconfirm.OnConfirmRequest;
import lombok.Data;


@Data
public class LoanStatusDto {

    @JsonProperty("on_confirm")
    private OnConfirmRequest onConfirmResponse;

}
