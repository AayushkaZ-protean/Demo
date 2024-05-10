package com.protean.openfinance.controller.wrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nsdl.beckn.api.model.onstatus.OnStatusRequest;
import com.protean.openfinance.dto.searchwrapper.*;
import com.protean.openfinance.service.wrappers.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;


@RestController
@Slf4j
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private SelectThreeService selectThreeService;

    @Autowired
    private InitOneService initOneService;

    @Autowired
    private ConfirmService confirmService;

    @Autowired
    private InitThreeService initThreeService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private UpdateService updateService;


    /* @GetMapping(value = "/search/v1", produces = {"application/json"})

     public ResponseEntity<String> search() throws Exception {

         HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.set("Content-Type", "application/json; charset=utf-8");
         return new ResponseEntity<>(searchService.search(null, httpHeaders), httpHeaders, HttpStatus.CREATED);
     }

     @PostMapping(value = "/search_wrapper", produces = {"application/json"})
     public ResponseEntity<String> searchWrapper(@RequestBody SearchWrapperDto searchWrapperDto) throws Exception {

         HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.set("Content-Type", "application/json; charset=utf-8");
         return new ResponseEntity<>(searchService.search(searchWrapperDto, httpHeaders), httpHeaders, HttpStatus.CREATED);
     }
 */
    @PostMapping(value = "/search_wrapper-v1", produces = {"application/json"})
    public ResponseEntity<String> searchWrapperV1(@RequestBody SearchWrapperDto searchWrapperDto,
                                                  @RequestHeader HttpHeaders httpHeaders) throws Exception {

        HttpHeaders headers = new HttpHeaders();

        headers.set("Content-Type", "application/json; charset=utf-8");
        searchService.prepareAaId(searchWrapperDto);
        return new ResponseEntity<>(searchService.search(searchWrapperDto, httpHeaders), HttpStatus.CREATED);
    }

    @PostMapping(value = "/search_wrapper-v2", produces = {"application/json"})
    public ResponseEntity<String> searchWrapperV2(@RequestBody SearchWrapperDto searchWrapperDto,
                                                  @RequestHeader HttpHeaders httpHeaders) throws Exception {

        HttpHeaders headers = new HttpHeaders();

        headers.set("Content-Type", "application/json; charset=utf-8");
        searchService.prepareAaId(searchWrapperDto);
        return new ResponseEntity<>("Hey Dude !", HttpStatus.CREATED);
    }

    @PostMapping(value = "/offers", produces = {"application/json"})
    public ResponseEntity<?> offers(@RequestBody OfferWrapperDto offerWrapperDto, @RequestHeader HttpHeaders headers) throws JsonProcessingException {

        HttpHeaders httpHeaders = headers;
        httpHeaders.set("Content-Type", "application/json; charset=utf-8");

        if (offerWrapperDto.getAction() != null && offerWrapperDto.getAction().equalsIgnoreCase("FETCH_OFFER")) {
            return new ResponseEntity<>("Invalid Action. Unable to process your request. Please try again.", httpHeaders, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(offerService.offers(offerWrapperDto, headers), HttpStatus.CREATED);
    }

    @PostMapping(value = "/select-offer", produces = {"application/json"})
    public ResponseEntity<?> selectOffer(@RequestBody SelectOfferDto selectOfferDto, @RequestHeader HttpHeaders headers) throws Exception {

        HttpHeaders httpHeaders = headers;
        httpHeaders.set("Content-Type", "application/json; charset=utf-8");

        return new ResponseEntity<>(selectThreeService.orchestratorSelect3(selectOfferDto, headers), HttpStatus.CREATED);
    }

    @PostMapping(value = "/post-kyc/disbursement", produces = {"application/json"})
    public ResponseEntity<?> disbursement(@RequestBody PostKycAndBankDetailsDto postKycAndBankDetailsDto, @RequestHeader HttpHeaders headers) throws Exception {

        HttpHeaders httpHeaders = headers;
        httpHeaders.set("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<>(initOneService.orchestratorInitOne(postKycAndBankDetailsDto, httpHeaders), HttpStatus.CREATED);
    }

    @PostMapping(value = "/post-enach/final-agreement", produces = {"application/json"})
    public ResponseEntity<?> postEnach(@RequestBody PostEnachFinalAgreementDto postEnachDto, @RequestHeader HttpHeaders httpHeaders) throws Exception {

        HttpHeaders headers = httpHeaders;
        httpHeaders.set("Content-Type", "application/json; charset=utf-8");

        return new ResponseEntity<>(initThreeService.orchestratorInitThree(postEnachDto, httpHeaders), HttpStatus.CREATED);
    }

    @PostMapping(value = "/on_status")
    public String action(@RequestBody OnStatusRequest onStatusFromAdaptor) throws JsonProcessingException {

        selectThreeService.saveOnStatusResponse(onStatusFromAdaptor);
        return "saved";
    }

    @PostMapping(value = "/confirm", produces = {"application/json"})
    public ResponseEntity<?> confirmAction(@RequestBody ConfirmLoanApplicationDto loanStatusDto, @RequestHeader HttpHeaders httpHeaders) throws Exception {
        return new ResponseEntity<>(confirmService.orchestratorConfirm(loanStatusDto, httpHeaders), HttpStatus.CREATED);
    }

    @GetMapping(value = "/my-loan/summary", produces = {"application/json"})
    public ResponseEntity<?> loanSummary(@RequestHeader HttpHeaders headers) throws Exception {
        return new ResponseEntity<>(statusService.loanSummary(headers), HttpStatus.OK);
    }

    @PostMapping(value = "/my-loan/status", produces = {"application/json"})
    public ResponseEntity<?> loanStatus(@RequestBody LoanStatusDto loanStatusDto) throws Exception {
        log.info("loan status dto {}", loanStatusDto.toString());
        return new ResponseEntity<>(statusService.loanStatus(loanStatusDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/my-loan/update", produces = {"application/json"})
    public ResponseEntity<?> loanUpdate(@RequestBody LoanUpdateDto loanUpdate) throws Exception {
        return new ResponseEntity<>(updateService.loanUpdate(loanUpdate), HttpStatus.CREATED);
    }

    @PostMapping(value = "/extract-audit-logs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> fetchOnStatus(@RequestHeader HttpHeaders headers, @RequestBody String body) throws AccessDeniedException, JsonProcessingException {

        return new ResponseEntity<>(statusService.fetchOnStatus(headers, body), HttpStatus.OK);
    }
}
