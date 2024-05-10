package com.protean.openfinance.dto.wrapper.onsearch;

import com.nsdl.beckn.api.model.common.Context;
import lombok.Data;

@Data
public class OnSearchRequestDto {

    private Context context;
    private OnSearchMessageDto message;

}
