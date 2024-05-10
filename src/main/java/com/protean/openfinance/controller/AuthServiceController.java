package com.protean.openfinance.controller;

import com.protean.openfinance.dto.auth.UserLoginDto;
import com.protean.openfinance.service.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthServiceController {


    @Autowired
    private AuthServiceImpl authServiceImpl;

    @PostMapping(path = "/authenticate", produces = {"application/json"})
    public ResponseEntity<String> token(@RequestBody UserLoginDto userLoginDto)
            throws IOException, InterruptedException {
        String token = authServiceImpl.generateToken(userLoginDto);
        return ResponseEntity.ok(token);
    }
}
