package com.protean.openfinance.dto.searchwrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class ApplicantInfo {

        @JsonProperty("firstName")
        private String firstName;

        @JsonProperty("lastName")
        private String lastName;

        @JsonProperty("dob")
        private String dob;

        @JsonProperty("pan")
        private String pan;//required

        @JsonProperty("contactNumber")
        private String contactNumber;//required

        @JsonProperty("employmentType")
        private String employmentType;

        @JsonProperty("income")
        private String income;//required

        @JsonProperty("companyName")
        private String companyName;

        @JsonProperty("email")
        private String email;//required

        @JsonProperty("officialemail")
        private String officialemail;

        @JsonProperty("udyamNumber")
        private String udyamNumber;

        @JsonProperty("addressL1")
        private String addressL1;

        @JsonProperty("addressL2")
        private String addressL2;

        @JsonProperty("city")
        private String city;

        @JsonProperty("state")
        private String state;

        @JsonProperty("pincode")
        private String pincode;

        @JsonProperty("aa_id")
        private String aa_id;//required

        @JsonProperty("aa_code")
        private String aaCode;//required

        @JsonProperty("bureauConsent")
        private String bureauConsent;//required

        @JsonProperty("agent_id")
        private String agentId;//required



}
