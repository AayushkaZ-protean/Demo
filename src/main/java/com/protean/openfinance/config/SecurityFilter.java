package com.protean.openfinance.config;

import com.nsdl.beckn.api.model.common.Error;
import com.protean.openfinance.exception.RequestValidationException;
import com.protean.openfinance.service.AuthServiceImpl;
import com.protean.openfinance.utill.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

@Component
@Slf4j

public class SecurityFilter implements Filter {

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Autowired
    private AuthServiceImpl authService;

    private static final List<String> headerExclusionApi =
            List.of("/static",
                    "/notification",
                    "/summary",
                    "/status",
                    "/uploads",
                    "/poc",
                    "/on_status",
                    "/extract-audit-logs",
                    "/api-key/validate",
                    "/report/applicant",
                    "/login");

    private static final Set<String> openApi = Set.of("/api-key/validate", "/authenticate");
    private static final Predicate<HttpServletRequest> isExcludedPath = request ->
            headerExclusionApi.stream().anyMatch(requestURI -> request.getRequestURI().contains(requestURI));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Validate headers here
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;


        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        //httpServletResponse.setHeader("Access-Control-Allow-Headers","contact_number, content-type, txn_id"); // Adjust headers as needed
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*"); // Adjust headers as needed

        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "false");
        httpServletResponse.setHeader("Access-Control-Max-Age", "7200");


        try {

            if (!httpServletRequest.getMethod().equalsIgnoreCase("options")) {

                if (!httpServletRequest.getRequestURI().contains("/login") && !httpServletRequest.getRequestURI().contains("/api-key/validate") ) {

                   authService.validateToken(httpServletRequest);

                    if (!isExcludedPath.test(httpServletRequest)) {
                        if (isValidHeaders(httpServletRequest)) {
                            // If headers are valid, continue with the filter chain

                        } else {
                            Error error = new Error();
                            error.setMessage("Required headers are missing or invalid");
                            throw new RequestValidationException(error);
                        }
                    }
                }
            }
            chain.doFilter(httpServletRequest, httpServletResponse);
        } catch (Exception e) {

            /*if (e instanceof GenericException) {
                // Handle GenericException*/
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized: Authentication token either missing or invalid");
                return;
         /*   } else {
                // Handle other exceptions (optional)
                resolver.resolveException((HttpServletRequest) request, (HttpServletResponse) response, null, e);
            }*/

        }
    }

    public boolean isValidHeaders(ServletRequest request) {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();

        // Create a map to store lowercase header names and their values
        Map<String, String> lowercaseHeaders = new HashMap<>();

        // Iterate through all headers
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = httpServletRequest.getHeader(headerName);

            // Convert header name to lowercase and store it in the map
            lowercaseHeaders.put(headerName.toLowerCase(), headerValue);
        }

        log.info("request headers {}", lowercaseHeaders.toString());
        String txnId = lowercaseHeaders.get(Constant.HEADER_TRANSACTION_ID);
        String contactNumber = lowercaseHeaders.get(Constant.HEADER_CONTACT_NUMBER);

        return StringUtils.isNotBlank(txnId) && StringUtils.isNotBlank(contactNumber) && !(contactNumber.length() > 13 || contactNumber.length() < 10);
    }

}
