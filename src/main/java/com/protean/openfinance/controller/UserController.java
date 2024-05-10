package com.protean.openfinance.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.protean.openfinance.dto.UserDto;
import com.protean.openfinance.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UserService userService;


    @GetMapping(path = "/user/{usercode}", produces={"application/json"})
    public ResponseEntity<UserDto> getByUserCode(@PathVariable(value = "usercode") String userCode) throws Exception {

        return new ResponseEntity<>(userService.getByUserCode(userCode), HttpStatus.OK);
    }
    @PostMapping(value = "/personal-info", produces={"application/json"})
    public ResponseEntity<UserDto> save(@RequestBody UserDto user) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<>(userService.save(user), httpHeaders, HttpStatus.CREATED);
    }
}
