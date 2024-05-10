package com.protean.openfinance.dto.wrapper.onsearch; 
import lombok.Data;

import java.util.List;
@Data
public class Catalog {
    public Descriptor descriptor;
    public List<Provider> providers;
}
