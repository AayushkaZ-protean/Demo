package com.protean.openfinance.dto.wrapper.onsearch;

import com.nsdl.beckn.api.model.common.Context;
import com.nsdl.beckn.api.model.onsearch.OnSearchRequest;
import lombok.Data;

import java.util.List;


@Data
public class SearchResponse {
    private Context context;
    private List<OnSearchRequest> responses;
}
