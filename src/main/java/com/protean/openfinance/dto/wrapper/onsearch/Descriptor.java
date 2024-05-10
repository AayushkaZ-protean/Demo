package com.protean.openfinance.dto.wrapper.onsearch; 
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class Descriptor{
    public String name;
    public String code;
    public ArrayList<Image> images;
    public String short_desc;
    public String long_desc;
}
