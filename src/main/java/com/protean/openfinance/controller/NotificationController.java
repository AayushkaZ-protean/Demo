package com.protean.openfinance.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.protean.openfinance.model.SmsRequest;
import com.protean.openfinance.service.SmsService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(value = "/notification", produces = "application/json")
public class NotificationController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    //@Qualifier("snakeCaseObjectMapper")
    private ObjectMapper mapper;

    @Autowired
    private SmsService smsService;

    @PostMapping("/sendSMS")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest request) throws IOException {
        log.info("sendSms : {}" + request);
        smsService.sendSms(request);
        return new ResponseEntity<String>(HttpStatus.CREATED);
        
    }

}
