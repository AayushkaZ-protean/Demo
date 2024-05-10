package com.protean.openfinance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    public Long id;
    public String applicantName;
    public String phoneNumber;
    public String userCode;
    public String firstName;
    public String middleName;
    public String lastName;
    public String dob;
    public String addressLine1;
    public String addressLine2;
    public String addressLine3;
    public String cityOrTownOrDistrict;
    public String city;
    public String town;
    public String district;
    public String pinCode;
    public String employmentType;
    public String income;
    public String companyName;
    public String accountAggregatorId;

}
