package com.protean.openfinance.dto.searchwrapper;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.nsdl.beckn.api.model.onselect.OnSelectRequest;
import lombok.Data;

@Data
public class PostKycAndBankDetailsDto {

    @JsonProperty("postKyc")
    private OnSelectRequest postKyc;

    @JsonProperty("acc_holder_name")
    private String accHolderName;

    @JsonProperty("acc_type")
    private String acctype;

    @JsonProperty("acc_no")
    private String accNo;

    @JsonProperty("ifsc_code")
    private String ifscCode;

}
