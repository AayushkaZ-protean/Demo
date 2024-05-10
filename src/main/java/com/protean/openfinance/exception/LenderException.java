package com.protean.openfinance.exception;

import com.nsdl.beckn.api.model.common.NackResponseModel;

public class LenderException extends RuntimeException {
    private NackResponseModel error;

    public LenderException(String message, Throwable t) {
        super(message, t);
    }

    public NackResponseModel getError() {
        return this.error;
    }

    public LenderException(NackResponseModel error) {
        super();
        this.error = error;
    }


}
