package com.protean.openfinance.dto.searchwrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import lombok.Data;

@Data
public class SelectOfferDto {

    @JsonProperty("selected_offer")
    private OnSelectRequest selectedOffer;

    @JsonProperty("loan_amount_adjusted")
    private String loanAmountAdjusted;

   /*@JsonProperty("loan_tenure_adjusted")
    private String loanTenureAdjusted;*/

}
