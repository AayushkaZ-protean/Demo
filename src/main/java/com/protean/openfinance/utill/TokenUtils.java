package com.protean.openfinance.utill;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.function.Function;

@Slf4j
@Component
public class TokenUtils {

    private static Set<String> openApi = Set.of("/login","/api-key/validate");

    public static final Function<HttpServletRequest, Boolean> logInApiValidation = httpServletRequest ->
        openApi.stream().anyMatch(api -> httpServletRequest.getRequestURI().contains(api));


    private TokenUtils(){
        super();

    }





}
