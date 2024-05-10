package com.protean.openfinance.dto.wrapper.onsearch;

import lombok.Data;

@Data

public class Form{
    public String id;
    public String mime_type;
    public String url;
    public boolean resubmit;
    public boolean multiple_sumbissions;
}
