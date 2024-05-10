package com.protean.openfinance.dto.searchwrapper;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nsdl.beckn.api.model.common.PaymentParams;
import com.nsdl.beckn.api.model.onconfirm.OnConfirmRequest;
import com.nsdl.beckn.api.model.onstatus.OnStatusRequest;
import lombok.Data;

@Data
public class LoanUpdateDto {

    @JsonProperty("updateType")
    private String updateType;

    @JsonProperty("payment_params_amount")
    private String amount;

    @JsonProperty("payment_params_currency")
    private String currency;

    @JsonProperty("on_status")
    private OnStatusRequest onStatusRequest;

}
