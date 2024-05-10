package com.protean.openfinance.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.protean.openfinance.model.google.ImageGenAiRequest;
import com.protean.openfinance.model.google.ImageGenAiResponse;
import com.protean.openfinance.model.google.ImageGenResponse;
import com.protean.openfinance.model.google.TranslatorResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoogleService {

	private static final String FILE_NAME = "/Users/raviv/Downloads/images/image-1.txt";

	public static void main(String[] args) throws IOException {
		GoogleService service = new GoogleService();
		/*FileInputStream fisTargetFile = new FileInputStream(new File(FILE_NAME));
		String targetFileStr = IOUtils.toString(fisTargetFile, "UTF-8");
		ImageGenAiRequest request = new ImageGenAiRequest();
		request.setB64Image(targetFileStr);
		request.setLang("en");
		ImageGenResponse igResponse = service.genAiImageCaption(request);
		
		System.out.println(igResponse.getTitle());
		System.out.println(getCropIdentifier(igResponse.getTitle()));
		*/
//		String identifiersFileDt = IOUtils.resourceToString("/static-json/agriIdentifiers.txt", StandardCharsets.UTF_8);
//		String[] identifiers = identifiersFileDt.split("\n");
//		    for(String s: identifiers){
//		      System.out.println(s);
//		    }
//		    System.out.println(identifiers.length);
		
		String catalogue = "\n\nQuantity:\n- 1 kg\n- 2 kg\n- 5 kg\n\nSuitableFor:\n- adults\n- children\n- pregnant women\n\nOrganic:\n- yes\n- no\n\nFormFactor:\n- round\n- oval\n- long\n\nPackaging:\n- plastic bag\n- cardboard box\n- paper bag\n\nFreshness:\n- fresh\n- slightly bruised\n- rotten\n\nStorageCondition:\n- room temperature\n- refrigerator\n- freezer\n\nColour:\n- purple\n- green\n- white\n\nSize:\n- small\n- medium\n- large\n\nBest before:\n- 1 week\n- 2 weeks\n- 3 weeks\n\nCleanliness:\n- clean\n- slightly dirty\n- dirty";
		catalogue = "{\n  \"Quantity\": [\"1kg\", \"2kg\", \"5kg\"],\n  \"SuitableFor\": [\"Vegetarians\", \"Vegans\", \"Everyone\"],\n  \"Organic\": [\"yes\", \"no\"],\n  \"FormFactor\": [\"Whole\", \"Halved\", \"Quartered\"],\n  \"Packaging\": [\"Plastic bag\", \"Cardboard box\", \"Reusable container\"],\n  \"Freshness\": [\"Fresh\", \"Frozen\", \"Canned\"],\n  \"StorageCondition\": [\"Refrigerated\", \"Dried\", \"Canned\"],\n  \"Colour\": [\"Purple\", \"Green\", \"White\"],\n  \"Size\": [\"Small\", \"Medium\", \"Large\"],\n  \"Best before\": [\"1 week\", \"2 weeks\", \"3 weeks\"],\n  \"Cleanliness\": [\"Clean\", \"Dirty\"]\n}";
		catalogue = "* Quantity: [1, 2, 3]\n* SuitableFor: [adults, children, everyone]\n* Organic: [yes, no]\n* FormFactor: [whole, sliced, diced]\n* Packaging: [plastic bag, cardboard box, paper box]\n* Freshness: [fresh, frozen, canned]\n* StorageCondition: [refrigerated, room temperature, frozen]\n* Colour: [purple, green, white]\n* Size: [small, medium, large]\n* Best before: [1 day, 3 days, 7 days]\n* Cleanliness: [clean, dirty]";
		catalogue = "Quantity:\n- 1kg\n- 500g\n- 250g\n\nSuitableFor:\n- Vegetarian\n- Non-vegetarian\n- Vegan\n\nOrganic:\n- Yes\n- No\n\nFormFactor:\n- Whole\n- Chopped\n- Sliced\n\nPackaging:\n- Plastic bag\n- Cardboard box\n- Paper bag\n\nFreshness:\n- Fresh\n- Frozen\n- Dried\n\nStorageCondition:\n- Room temperature\n- Fridge\n- Freezer\n\nColour:\n- Purple\n- Green\n- White\n\nSize:\n- Small\n- Medium\n- Large\n\nBest before:\n- 1 week\n- 2 weeks\n- 3 weeks\n\nCleanliness:\n- Clean\n- Dirty";
		catalogue = "{\"Quantity\": [\"1kg\", \"500g\", \"250g\"]}\n{\"SuitableFor\": [\"Vegetarians\", \"Vegans\", \"Everyone\"]}\n{\"Organic\": [\"Yes\", \"No\"]}\n{\"FormFactor\": [\"Whole\", \"Sliced\", \"Diced\"]}\n{\"Packaging\": [\"Plastic bag\", \"Paper bag\", \"Cardboard box\"]}\n{\"Freshness\": [\"Fresh\", \"Frozen\", \"Canned\"]}\n{\"StorageCondition\": [\"Refrigerated\", \"Airtight container\", \"At room temperature\"]}\n{\"Colour\": [\"Purple\", \"Green\", \"White\"]}\n{\"Size\": [\"Small\", \"Medium\", \"Large\"]}\n{\"Best before\": [\"1 week\", \"2 weeks\", \"3 weeks\"]}\n{\"Cleanliness\": [\"Clean\", \"Dirty\"]}";
		attributeGeneration(catalogue, "te");
		//		System.out.println(catalogueGeneration(catalogue));
		
		System.out.println(getCropIdentifier("a field of tall plants with white flowers and Apple leaves"));
		
		List<String> requests = new ArrayList<String>();
		requests.add("farmer");
		requests.add("farming");
		System.out.println(service.translate("en", "te", requests));
		
	}

	public List<String> translate(String src, String trg, List<String> request) throws IOException {
		return callTranslate(src, trg, request);
	}

	public ImageGenResponse genAiImageCaption(ImageGenAiRequest request) throws IOException {
		log.info("Image Length--> : {}",  request.getB64Image().length());
		ImageGenAiResponse responseGai = callImageGenCaption(request);
		ImageGenResponse response = new ImageGenResponse();
		
		response.setB64Image(request.getB64Image());
		if(CollectionUtils.isEmpty(responseGai.getResults().getPredictions())) {
			return response;
		}
		
		response.setTitle(responseGai.getResults().getPredictions().get(0));
		String identifier = getCropIdentifier(response.getTitle());
		String attributes = "";
		if(!identifier.equals("NONE")) {
			response.setValidImage(true);
			attributes = callProductAttributesInStr(identifier);
			response.setTitle(identifier);
			response.setDescription(getTitleDescription(identifier));
		} else {
			response.setValidImage(false);
			response.setDescription(response.getTitle());
			response.setAttributes(getTitleDescriptionArrtibutes(identifier).getAttributes());
			
			response.setTitleInml(response.getTitle());
			response.setDescriptionInml(response.getTitle());
			response.setAttributesInml(getTitleDescriptionArrtibutes(identifier).getAttributes());
			
		}
			
		response.setProductType(identifier);
		
		
		// Set multiLingual
		if(!request.getLang().equalsIgnoreCase("en") && !identifier.equals("NONE") && !CollectionUtils.isEmpty(responseGai.getResults().getPredictions())) {
			List<String> sourceLang = new ArrayList<>();
			sourceLang.add(response.getTitle());
			sourceLang.add(response.getDescription());
			List<String> predictionInml =  callTranslate("en", request.getLang(), sourceLang);
			Map<String, List<String>> attrMap = attributeGeneration(attributes, request.getLang());
			response.setTitleInml(predictionInml.get(0));
			response.setDescriptionInml(predictionInml.get(1));
			response.setAttributesInml(attrMap);
		}
		
		
		if(!identifier.equals("NONE") && !CollectionUtils.isEmpty(responseGai.getResults().getPredictions())) {
			try {
				response.setAttributes(attributeGeneration(attributes));
//				response.setDescription(responseGai.getResults().getPredictions().get(1));
				
				log.info("Response--> : identifier: {}",  identifier);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return response;
	}
	
	public ImageGenResponse genAiImageCaptionV2(ImageGenAiRequest request) throws IOException {
		
		log.info("Image Length--> : {}",  request.getB64Image().length());
		ImageGenAiResponse responseGai = callImageGenCaption(request);
		ImageGenResponse response = new ImageGenResponse();
		
		response.setB64Image(request.getB64Image());
		if(CollectionUtils.isEmpty(responseGai.getResults().getPredictions())) {
			return response;
		}
		
		response.setTitle(responseGai.getResults().getPredictions().get(0));
		String identifier = getCropIdentifier(response.getTitle());
		String attributes = "";
		if(!identifier.equals("NONE")) {
			response.setValidImage(true);
			ImageGenResponse tda = getTitleDescriptionArrtibutes(identifier);
			response.setTitle(tda.getTitle());
			response.setDescription(tda.getDescription());
			response.setAttributes(tda.getAttributes());
		} else {
			response.setValidImage(false);
			response.setDescription(response.getTitle());
			response.setAttributes(getTitleDescriptionArrtibutes(identifier).getAttributes());
			
			response.setTitleInml(response.getTitle());
			response.setDescriptionInml(response.getTitle());
			response.setAttributesInml(getTitleDescriptionArrtibutes(identifier).getAttributes());
		}
			
		response.setProductType(identifier);
		
		
		// Set multiLingual
		if(!request.getLang().equalsIgnoreCase("en") && !CollectionUtils.isEmpty(responseGai.getResults().getPredictions())) {
			List<String> sourceLang = new ArrayList<>();
			sourceLang.add(response.getTitle());
			sourceLang.add(response.getDescription());
			List<String> predictionInml =  callTranslate("en", request.getLang(), sourceLang);
//			Map<String, List<String>> attrMap = attributeGeneration(attributes, request.getLang());
			response.setTitleInml(predictionInml.get(0));
			response.setDescriptionInml(predictionInml.get(1));
//			response.setAttributesInml(attrMap);
		}
		
//		response.setB64Image(request.getB64Image());
		if(!CollectionUtils.isEmpty(responseGai.getResults().getPredictions())) {
			try {
//				response.setAttributes(attributeGeneration(attributes));
//				response.setDescription(responseGai.getResults().getPredictions().get(1));
				
				log.info("Response--> : identifier: {}",  identifier);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return response;
	}
	
	public static List<String> callTranslate(String src, String trg, List<String> request)  {
		log.info("callTranslate Request--> : {}",  request);
		RestTemplate restTemplate = new RestTemplate();
		String url = String.format("https://translatelib-ylyc3objva-el.a.run.app/translate/text?src=%s&trg=%s", src, trg);
		long startTime = System.currentTimeMillis();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<List<String>> entity = new HttpEntity<>(request, headers);
		ResponseEntity<TranslatorResponse> responseBody = restTemplate.exchange(url, HttpMethod.POST, entity, TranslatorResponse.class);
		TranslatorResponse response = responseBody.getBody();
		
		List<String> targetResponse = response.getResults().stream().map(e -> e.getTarget()).collect(Collectors.toList());
		log.debug("Response--> : StatusCode: {}, Body: {}",  responseBody.getStatusCode(), response);
		long endTime = System.currentTimeMillis();
		log.info("============>> url: {}, TimeTaken: {}ms",  url, endTime-startTime);
		return targetResponse;
	}

	private static ImageGenAiResponse callImageGenCaption(ImageGenAiRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://genai-imagelib-ylyc3objva-el.a.run.app/genai/image/caption";
		long startTime = System.currentTimeMillis();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("samplecount", "3");
//		headers.add("languagecode", request.getLang());
		headers.add("languagecode", "en");
		String body  = "{\"instances\":[{\"image\":{\"bytesBase64Encoded\":\""+ request.getB64Image() +"\"}}]}";
		log.debug("Request: " + body);
		HttpEntity<String> entity = new HttpEntity<>(body, headers);
		ResponseEntity<ImageGenAiResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, ImageGenAiResponse.class);
		log.debug("Response--> : StatusCode: {}, Body: {}",  response.getStatusCode(), response.getBody().getResults().getPredictions());
		long endTime = System.currentTimeMillis();
		log.info("============>> url: {}, TimeTaken: {}ms",  url, endTime-startTime);
		return response.getBody();
	}
	
	private static String callProductAttributesInStr(String productName) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://sellergenie-ylyc3objva-el.a.run.app/product/attribs";
//		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
		long startTime = System.currentTimeMillis();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		String body  = "{\n"
				+ "    \"attributes\": \"Quantity, SuitableFor, Organic, FormFactor, Packaging, Freshness, StorageCondition, Colour, Size, Best before\",\n"
				+ "    \"prompt\": \"Context: Create 3 values for set of attributes for creating " + productName + " crop catalogue for selling\",\n"
				+ "    \"desc\": \"Format: {\\\"Organic\\\": [\\\"\\\",\\\"\\\"]}\""
				+ "}";
		log.debug("Request: " + body);
		HttpEntity<String> entity = new HttpEntity<>(body, headers);
		ResponseEntity<ImageGenAiResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, ImageGenAiResponse.class);
		log.debug("Response--> : StatusCode: {}, Body: {}",  response.getStatusCode(), response.getBody().getResults().getContent());
		long endTime = System.currentTimeMillis();
		log.info("============>> url: {}, TimeTaken: {}ms",  url, endTime-startTime);
		return response.getBody().getResults().getContent();
	}
	
	private static String getCropIdentifier(String title) throws IOException {
		String identifiersFileDt = IOUtils.resourceToString("/static-json/agriIdentifiers.txt", StandardCharsets.UTF_8);
		String[] identifiers = identifiersFileDt.split("\n");
		String identifier = "NONE";
	    for(String idtfr: identifiers) {
	    	if(title.toLowerCase().contains(idtfr.toLowerCase())) {
	    		identifier = idtfr;
		    	break;
	    	}
	    }
		return identifier;
	}
	
	private static Map<String, List<String>> attributeGeneration(String catalogue) {
		log.debug("Catalogue:{}", catalogue);
		Map<String, List<String>> catalogues = new HashMap<>();
		try {
			String[] ct = catalogue.split("\n");
			for(String keyValue: ct) {
				String key = keyValue.split(":")[0];
				List<String> values = new ArrayList<>();
				String valueArrayStr = keyValue.split(":")[1];
				List<String> valueList = Arrays.asList(valueArrayStr.split(","));
				for(String value: valueList) {
					if(!StringUtils.isEmpty(value)) {
						value = value.trim();
						//value = value.replaceAll("\\W", ""); 
						value = value.replace("-", "").replace("[", "").replace("\"", "").replace("]", "").replace("}", "");
						values.add(value);
					}
				}
				key = key.replaceAll("\\W", "");
				catalogues.put(key, values);
//				System.out.println(String.format("-->>Key:%s, Value%s", key, values));
			}
		} catch (Exception e) {
			log.error("Error while preparing Catalogue Map: " + e.getMessage());
		}
		return catalogues;
	}
	
	private static Map<String, List<String>> attributeGeneration(String catalogue, String lang) {
		log.debug("Catalogue:{}", catalogue);
		Map<String, List<String>> catalogues = new HashMap<>();
		try {
			String[] ct = catalogue.split("\n");
			for(String keyValue: ct) {
				String key = keyValue.split(":")[0];
				List<String> values = new ArrayList<>();
				String valueArrayStr = keyValue.split(":")[1];
				valueArrayStr = valueArrayStr.replace("-", "").replace("[", "").replace("\"", "").replace("]", "").replace("}", "");
				List<String> valueList = Arrays.asList(valueArrayStr.split(","));
				valueList = callTranslate("en", lang,valueList);
				for(String value: valueList) {
					if(!StringUtils.isEmpty(value)) {
						value = value.trim();
						//value = value.replaceAll("\\W", ""); 
//						value = value.replace("-", "").replace("[", "").replace("\"", "").replace("]", "").replace("}", "");
						values.add(value);
					}
				}
				key = key.replaceAll("\\W", "");
				catalogues.put(key, values);
//				System.out.println(String.format("-->>Key:%s, Value%s", key, values));
			}
		} catch (Exception e) {
			log.error("Error while preparing Catalogue Map: " + e.getMessage());
		}
		return catalogues;
	}
	
	private static final String getTitleDescription(String title) throws IOException {
		String identifiersFileDt = IOUtils.resourceToString("/static-json/title_description.txt", StandardCharsets.UTF_8);
		String[] titleDescription = identifiersFileDt.split("\n");
		String description = "NONE";
	    for(String td: titleDescription) {
	    	String[] t1tdAr = td.split("\\|");
	    	String t = t1tdAr[0];
	    	String d = t1tdAr[1];
	    	if(t.toLowerCase().contains(title.toLowerCase())) {
	    		description = d;
		    	break;
	    	}
	    }
		return description.trim();
	}
	
	private static final ImageGenResponse getTitleDescriptionArrtibutes(String identifier) throws IOException {
		String identifiersFileDt = IOUtils.resourceToString("/static-json/title_desc_attr.txt", StandardCharsets.UTF_8);
		String[] titleDescription = identifiersFileDt.split("\n");
		ImageGenResponse tda = new ImageGenResponse();
	    for(String td: titleDescription) {
	    	String[] t1tdAr = td.split("\\|");
	    	String t = t1tdAr[0];
	    	String d = t1tdAr[1];
	    	if(t.equalsIgnoreCase(identifier)) {
	    		tda.setTitle(t);
	    		tda.setDescription(d);
	    		Map<String, List<String>> attrs = new HashMap<>();
	    		attrs.put("Size", Arrays.asList(t1tdAr[2],t1tdAr[3],t1tdAr[4]));
	    		attrs.put("Colour", Arrays.asList(t1tdAr[5],t1tdAr[6],t1tdAr[7]));
	    		attrs.put("Organic", Arrays.asList(t1tdAr[8],t1tdAr[9],t1tdAr[10]));
	    		tda.setAttributes(attrs);
	    		break;
	    	}
	    }
		return tda;
	}
	
	private static final ImageGenResponse getFilterB64Images(String identifier) throws IOException {
		String identifiersFileDt = IOUtils.resourceToString("/static-images/" + identifier + ".png", StandardCharsets.UTF_8);
		String[] titleDescription = identifiersFileDt.split("\n");
		ImageGenResponse tda = new ImageGenResponse();
	    for(String td: titleDescription) {
	    	String[] t1tdAr = td.split("\\|");
	    	String t = t1tdAr[0];
	    	String d = t1tdAr[1];
	    	if(t.equalsIgnoreCase(identifier)) {
	    		tda.setTitle(t);
	    		tda.setDescription(d);
	    		Map<String, List<String>> attrs = new HashMap<>();
	    		attrs.put("Size", Arrays.asList(t1tdAr[2],t1tdAr[3],t1tdAr[4]));
	    		attrs.put("Colour", Arrays.asList(t1tdAr[5],t1tdAr[6],t1tdAr[7]));
	    		attrs.put("Organic", Arrays.asList(t1tdAr[8],t1tdAr[9],t1tdAr[10]));
	    		tda.setAttributes(attrs);
	    		break;
	    	}
	    }
		return tda;
	}
	
	
	
}
