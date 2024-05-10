package com.protean.openfinance.utill;

import java.util.Map;
import java.util.Set;

public interface Constant {

    public static final String AA_CODE_FINVU = "aa_01";
    public static final String AA_FINVU_ID = "@finvu";
    public static final String HEADER_TRANSACTION_ID = "txn_id";
    public static final String HEADER_CONTACT_NUMBER = "contact_number";
    public static final String AUTH_HEADER= "Authorization";


    public static final String GRANT_TYPE_SUPER_ADMIN = "superadmin";
    public static final String GRANT_TYPE_REPORT_ADMIN = "reportadmin";
    public static final String GRANT_TYPE_TECHNICAL_SUPPORT = "techadmin";

//    public static final String[] API_REPORT = {"/openfinance/report/applicant","/openfinance/pagination"};

    public static final String API_REPORT = "/openfinance/report/applicant";
    Set<String> REPORT_ADMIN_GRANT = Set.of(API_REPORT);

    Set<String> TECH_SUPPORT_GRANT = Set.of(API_REPORT);

    Set<String> SUPER_ADMIN_GRANT = Set.of(API_REPORT);

    Map<String, Set<String>> roleApiMappingSuper = Map.of(GRANT_TYPE_SUPER_ADMIN ,SUPER_ADMIN_GRANT);

    Map<String, Set<String>> roleApiMappingTech = Map.of(GRANT_TYPE_TECHNICAL_SUPPORT ,TECH_SUPPORT_GRANT);

    Map<String, Set<String>> roleApiMappingReport = Map.of(GRANT_TYPE_REPORT_ADMIN ,REPORT_ADMIN_GRANT);



}
