package com.protean.openfinance.utill;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LoanStatusType {

    PERSONAL_INFO("personal_info"),
    OFFER("offer"),
    FORM_LOAN_AMT("form_loan_amt"),
    KYC("kyc"),
    ENACH("enach"),
    ESIGN_CONFIRM("esign_confirm"),
    CONFIRM("confirm"),
    STATUS("status"),
    TRACK("track"),
    CANCEL("cancel"),
    ;
    private final String value;

    LoanStatusType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

}
