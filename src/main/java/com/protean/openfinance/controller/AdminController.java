package com.protean.openfinance.controller;

import com.protean.openfinance.entity.ApplicantDetails;
import com.protean.openfinance.exception.GenericException;
import com.protean.openfinance.service.wrappers.ApplicantDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class AdminController {



    @Autowired
    private ApplicantDetailsService service;



//    @GetMapping("/pagination")
//    public ResponseEntity<Page<ApplicantDetails>> getPaginatedApplicants(@RequestParam int page, @RequestParam int size) {
//        try {
//            return ResponseEntity.ok(service.getPaginatedApplicants(page, size));
//        } catch (Exception ex) {
//            throw new GenericException("Data not found");
//        }
//    }



    @GetMapping("/report/applicant")
    public ResponseEntity<Page<ApplicantDetails>> searchByCriteria(
            @RequestParam(required = false) String searchPhrase, // Optional
            @RequestParam(required = false) String fromDate, // Optional query param for start date (format: yyyy-MM-dd)
            @RequestParam(required = false) String toDate,   // Optional query param for end date (format: yyyy-MM-dd)
            @RequestParam int page,
            @RequestParam int size) throws ParseException {
        try {
            LocalDateTime localFromDate = null;
            LocalDateTime localToDate = null;
            if (fromDate != null) {
                localFromDate = LocalDate.parse(fromDate, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay();
            }
            if (toDate != null) {
                localToDate = LocalDate.parse(toDate, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay();
            }
            return ResponseEntity.ok(service.searchApplicants(searchPhrase, localFromDate, localToDate, page, size));
        } catch (Exception ex) {
            throw new GenericException("Data not found");
        }
    }


}
