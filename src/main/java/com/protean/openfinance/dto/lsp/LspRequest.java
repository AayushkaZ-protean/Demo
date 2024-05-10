package com.protean.openfinance.dto.lsp;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LspRequest {

    private LspHeader header;
    private LspBody body;

}
