package com.protean.openfinance.controller;


import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsdl.beckn.api.model.oninit.OnInitRequest;
import com.nsdl.beckn.common.exception.ApplicationException;
import com.nsdl.beckn.common.exception.ErrorCode;
import com.nsdl.beckn.common.model.JsonResponseModel;
import com.nsdl.beckn.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequestMapping(value = "/static", produces = "application/json")
public class StaticDataController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("snakeCaseObjectMapper")
    private ObjectMapper mapper;

    @Value("${spring.profiles.active}")
    private String activeProfile;


    @GetMapping("/loan-types")
    public String loanTypes() {
        return readJsonFile("/wrapper/loan-types_v1.json");
    }

    @GetMapping("/aa-types")
    public String aaTypes() {
        return readJsonFile("/wrapper/aa-types.json");
    }

    @GetMapping("/issue-categories")
    public String issueCategories() {
        return readJsonFile("/wrapper/igm/igm_cat_subcat_map.json");
    }

    @GetMapping("/issue-categories/v1")
    public String issueCategoriesV1() {
        return readJsonFile("/wrapper/igm/igm_cat_subcat_map_v1.json");
    }

    @GetMapping("/subscriber-config")
    public String getEnvironmentConfig() {

        if (activeProfile.equalsIgnoreCase("preprod")) {
            return readJsonFile("/wrapper/config/preprod.json");
        } else {
            return readJsonFile("/wrapper/config/qa.json");
        }
    }

    public String readJsonFile(String filePath) {
        Object inputJSON = JsonUtils.classpathToObject(filePath);
        return JsonUtils.toPrettyJsonString(inputJSON);
    }

    @GetMapping("/on-init")
    public String loanT() throws JsonProcessingException {
        String json = readJsonFile("/wrapper/on_init.json");


        // List<JsonResponseModel> list = this.service.getApiResponse(model);
        //log.debug("size of response list is {}", list.size());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(json);
        log.debug("Serialized JSON: {}", jsonString);

        JsonNode arrayNode = objectMapper.readTree(jsonString);

        // Get the value of the "json" field and convert it to a JSON string without escape characters
        String innerJson = arrayNode.textValue();
        String unescapedJson = innerJson.replace("\\", "");


        OnInitRequest onInitRequest = mapper.readValue(unescapedJson, OnInitRequest.class);
        return unescapedJson;

    }

    public <schemaClass> schemaClass convertToRequest(String body, Class<?> schemaClass) {
        try {
            schemaClass model = (schemaClass) this.mapper.readValue(body, schemaClass);
            log.debug("The {} model in validate schema is {}", schemaClass, model);
            return model;
        } catch (Exception e) {
            log.error("Error while json processing for {}. Not a valid json {}", schemaClass, e);
            throw new ApplicationException(ErrorCode.SCHEMA_VALIDATION_FAILED, e.getMessage());
        }

    }


}
