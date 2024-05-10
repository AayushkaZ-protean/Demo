package com.protean.openfinance.dto.wrapper.onsearch; 
import lombok.Data;

import java.util.List;
@Data
public class Provider{
    public String id;
    public Descriptor descriptor;
    public List<Category> categories;
    public List<Item> items;
    public List<Payment> payments;
    public List<Tag> tags;
}
