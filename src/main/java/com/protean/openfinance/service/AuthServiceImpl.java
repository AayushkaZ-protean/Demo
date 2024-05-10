package com.protean.openfinance.service;


import com.jayway.jsonpath.JsonPath;
import com.protean.openfinance.dto.auth.UserLoginDto;
import com.protean.openfinance.exception.GenericException;
import com.protean.openfinance.utill.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.*;
import java.util.function.Predicate;


@Service
@Slf4j
@Component
public class AuthServiceImpl {

    @Value("${keyCloak.keycloakURL}")
    private String keycloakURL;

    @Value("${keyCloak.keyCloakUrlSuffix}")
    private String keyCloakUrlSuffix;

    private UserLoginDto userLoginDto;

    private Predicate<UserLoginDto> validateUseAuthDetails = userLoginDto -> {
       return  StringUtils.isNotBlank(userLoginDto.getUserName()) && StringUtils.isNotBlank(userLoginDto.getPassword());
    };
    public String generateToken(UserLoginDto userLoginDto) throws IOException, InterruptedException {

        if(!validateUseAuthDetails.test(userLoginDto)){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }

        String realm = userLoginDto.getRealm();
        String uriString = this.keycloakURL+realm+"/protocol/openid-connect/token";
        Map<Object, Object> data = new HashMap<>();
        data.put("grant_type", "password");
        data.put("client_id", userLoginDto.getClientId());
        data.put("username",userLoginDto.getUserName());
        data.put("password", userLoginDto.getPassword());

        String urlEncodedData = getFormDataString(data);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriString))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(urlEncodedData))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        log.info("generateToken Username: {}, StatusCode: {}", userLoginDto.getUserName(), response.statusCode());
        return response.body();
    }


    private static String getFormDataString(Map<Object, Object> data) throws UnsupportedEncodingException {
        // Convert the map into a URL-encoded string
        StringBuilder formData = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (formData.length() > 0) {
                formData.append("&");
            }
            formData.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8.name()));
            formData.append("=");
            formData.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8.name()));
        }
        return formData.toString();
    }

    public boolean validateToken(ServletRequest servletRequest) throws IOException, InterruptedException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String authorizationToken = httpServletRequest.getHeader(Constant.AUTH_HEADER);
        String realm = "";
        String requestedURI = httpServletRequest.getRequestURI();


        String [] rolesSpart = decodeTokenAndExtractRealmName(authorizationToken);

        if(null != rolesSpart && rolesSpart.length > 1){

            realm = rolesSpart[0];


        } else {
            log.info("empty role array after token split");
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);

        }

        if("paynearbyAdmin".equals(realm)) {

            if(!hasAccess(rolesSpart, requestedURI, (HttpServletRequest) servletRequest)) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
            }
        }
        else if("paynearby".equals(realm)){

            if(Constant.API_REPORT.equals(requestedURI)){
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
            }
        }

        log.info("Realm: {}", realm);

        String uriString = MessageFormat.format("{0}{1}{2}", this.keycloakURL, realm, this.keyCloakUrlSuffix);

        // Create HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriString))
                //.header("Authorization", "Bearer " + authorizationToken)
                .header(Constant.AUTH_HEADER, authorizationToken)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        // Send the request and capture the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        log.info("Response StatusCode: {}", response.statusCode());
        if(response.statusCode() >= 400) {
            throw new GenericException("UNAUTHORIZED");
            //throw new HttpClientErrorException(HttpStatus.valueOf(response.statusCode()), HttpStatus.UNAUTHORIZED);
        }
        log.info("Response Body: {}", response.body());

        return true;
    }

    private static boolean hasAccess(String[] rolesSpart, String requestedURI, HttpServletRequest servletRequest) {
        if (rolesSpart == null || rolesSpart.length < 2) {
            return false;
        }

        String role = rolesSpart[1];


        Map<String, Set<String>> roleApiMapping = null;
        if ("paynearbyAdmin".equals(rolesSpart[0])) {
            if ("superadmin".equals(role)) {
                roleApiMapping = Constant.roleApiMappingSuper;
            } else if ("reportadmin".equals(role)) {
                roleApiMapping = Constant.roleApiMappingReport;
            } else if ("techadmin".equals(role)) {
                roleApiMapping = Constant.roleApiMappingTech;
            }
        }

        if (roleApiMapping != null) {
            Set<String> allowedEndpoints = roleApiMapping.get(role);
            return allowedEndpoints != null && allowedEndpoints.contains(requestedURI);
        }

        return false; // Access denied
    }



    public String[] decodeTokenAndExtractRealmName(String authorizationToken/*, *//*String realm*/) {

        String[] rolesSplit = null;
        if(Objects.nonNull(authorizationToken)) {
            String[] jwtParts = authorizationToken.split("\\.");
            // Decoding the payload
            byte[] payloadBytes = Base64.getUrlDecoder().decode(jwtParts[1]);
            String payload = new String(payloadBytes);
            log.info("Payload: {}", payload);
            Object document = JsonPath.parse(payload).json();

            String role = JsonPath.read(document, "$.realm_access.roles[0]");//role name pattern - realnname_role
            //List<Object> role1 = JsonPath.read(document, "$.realm_access.roles[*]");


            if (role != null) {
                // Split the role value with '_'
                String[] parts = role.split("_");
                if (parts.length > 0) {
                    //realm = parts[0];
                }
                return parts;
            }

            //return rolesSplit;
        }
        return rolesSplit;
    }
}