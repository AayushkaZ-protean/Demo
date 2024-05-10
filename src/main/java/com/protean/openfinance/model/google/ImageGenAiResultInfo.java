package com.protean.openfinance.model.google;

import lombok.Data;

import java.util.List;

@Data
public class ImageGenAiResultInfo {
	
	private String deployedModelId;
	private List<String> predictions;
	
	private String content;

}
