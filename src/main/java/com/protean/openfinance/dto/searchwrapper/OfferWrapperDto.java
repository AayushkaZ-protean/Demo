package com.protean.openfinance.dto.searchwrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import lombok.Data;

import java.util.List;

@Data
public class OfferWrapperDto {

	@JsonProperty("transactionId")
    private String transactionId;
	
	@JsonProperty("action")
    private String action; //should be FETCH_OFFER

//    @JsonProperty("offers")
//    private List<OnSelectRequest> offers;
}
