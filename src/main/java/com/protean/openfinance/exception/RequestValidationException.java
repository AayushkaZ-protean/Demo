package com.protean.openfinance.exception;

import com.nsdl.beckn.api.model.common.Error;

public class RequestValidationException extends RuntimeException {
    private Error error;


    public RequestValidationException(String message, Throwable t) {
        super(message, t);
    }

    public Error getError() { return this.error; }

    public RequestValidationException(Error error) {
        super();
        this.error = error;
    }


}
