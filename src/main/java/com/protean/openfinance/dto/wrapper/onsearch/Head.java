package com.protean.openfinance.dto.wrapper.onsearch; 
import lombok.Data;

import java.util.List;

@Data

public class Head{
    public Descriptor descriptor;
    public Index index;
    public List<String> headings;
}
