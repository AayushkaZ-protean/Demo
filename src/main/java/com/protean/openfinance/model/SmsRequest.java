
package com.protean.openfinance.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SmsRequest {

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("msg")
    private String msg;

}
