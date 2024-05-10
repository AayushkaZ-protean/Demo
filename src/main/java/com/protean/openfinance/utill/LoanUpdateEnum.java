package com.protean.openfinance.utill;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LoanUpdateEnum {

    MISSED_EMI_PAYMENT("MISSED_EMI_PAYMENT"),
    FORECLOSURE("FORECLOSURE"),
    PRE_PART_PAYMENT("PRE_PART_PAYMENT"),
    INSTALLMENT("INSTALLMENT");
    private final String value;

    LoanUpdateEnum(String value) {
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
