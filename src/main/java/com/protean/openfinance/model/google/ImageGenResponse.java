package com.protean.openfinance.model.google;

import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
public class ImageGenResponse {
	
	private String productType;
	private String title;
	private String description;
	
	@ToString.Exclude
	private String b64Image;
	private boolean validImage;
	private Map<String, List<String>> attributes;
	
	private String titleInml;
	private String descriptionInml;
	private Map<String, List<String>> attributesInml;
	
	

}
