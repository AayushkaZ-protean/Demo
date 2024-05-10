package com.protean.openfinance.dto.wrapper.onsearch; 
import lombok.Data;

import java.util.List;
@Data

public class Item{
    public String id;
    public Descriptor descriptor;
    public List<String> category_ids;
    public List<Tag> tags;
    public boolean matched;
    public boolean recommended;
    public Xinput xinput;
}
