package com.somesample.restandweb.controller;

import com.somesample.restandweb.inter.CommonWebResponse;
import com.somesample.restandweb.model.CurrencyCode;
import com.somesample.restandweb.repository.CurrencyCodeRepository;
import com.somesample.restandweb.service.LoggingService;
import com.somesample.restandweb.service.ResponseService;
import com.somesample.restandweb.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CurrencyCodeController {

    @Autowired
    private CurrencyCodeRepository currencyCodeRepository;

    @Autowired
    private LoggingService logingService;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private ResponseService responseService;

    @GetMapping("/api/code/{code}")
    public ResponseEntity<CommonWebResponse> currencyByCode(@PathVariable String code, HttpServletRequest request) {
        try {
            logingService.logRequest(code, request.getRemoteAddr());

            if (!validationService.isCodeValid(code)) {
                return responseService.getBadRequestError("Incorrect code provided");
            }

            CurrencyCode cc = currencyCodeRepository.findByCode(code.toUpperCase());

            if(cc==null){
                return responseService.getBadRequestError("Code not found!");
            }

            return responseService.getCorrectCurrencyCodeAnswer(cc);
        } catch(Exception e){
            return responseService.getInternalServerError(
                    "Internal service error happened. Please contact developer");
        }
    }
}
