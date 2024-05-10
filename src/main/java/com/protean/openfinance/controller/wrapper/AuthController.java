package com.protean.openfinance.controller.wrapper;

import com.protean.openfinance.dto.auth.UserLoginDto;
import com.protean.openfinance.service.AuthServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    @Value("${openfinance.api-key}")
    private String apiKeyFromConfig;

    @Autowired
    private AuthServiceImpl authServiceImpl;


    @GetMapping(value = "/api-key/validate",produces = {"application/json"})
    public ResponseEntity<String> acceptApiKey(@RequestParam(required = true) String apiKey, @RequestHeader HttpHeaders headers){

        HttpHeaders httpHeaders = headers;
        httpHeaders.set("Content-Type", "application/json; charset=utf-8");
        boolean valid = StringUtils.isNotBlank(apiKey) && apiKeyFromConfig.equalsIgnoreCase(apiKey);
        return new ResponseEntity<>(httpHeaders, valid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(path = "/login", produces = {"application/json"})
    public ResponseEntity<String> token(@RequestBody UserLoginDto userLoginDto)
            throws IOException, InterruptedException {
        String token = authServiceImpl.generateToken(userLoginDto);
        return ResponseEntity.ok(token);
    }
}
