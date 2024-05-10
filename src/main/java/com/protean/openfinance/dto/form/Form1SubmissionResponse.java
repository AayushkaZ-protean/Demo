package com.protean.openfinance.dto.form;

import com.nsdl.beckn.api.model.common.Context;
import com.nsdl.beckn.api.model.common.Descriptor;
import com.nsdl.beckn.api.model.common.Form;
import com.nsdl.beckn.api.model.common.Provider;
import lombok.Data;


@Data
public class Form1SubmissionResponse {

    private Context context;
    private Form form;
    private String submissionId;
    private Descriptor descriptor;
    private Boolean isSubmitted;
    private String response;
    private String itemId;
    private Provider provider;
}
