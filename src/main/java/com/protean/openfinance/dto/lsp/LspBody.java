package com.protean.openfinance.dto.lsp;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LspBody {

    private String userId;
    private String password;
    private String token;

    //below params used in the request to get return url
    private String lspId;
    private List<String> consentHandles;
    private String url;
    private String returnUrl;
}

