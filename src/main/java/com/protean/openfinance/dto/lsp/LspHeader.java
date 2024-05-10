package com.protean.openfinance.dto.lsp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LspHeader {
    private String rid;
    private String ts;//date

    @JsonProperty("channelId")
    private String channelId;
}
