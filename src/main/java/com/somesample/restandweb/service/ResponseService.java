package com.somesample.restandweb.service;

import com.somesample.restandweb.inter.CommonWebResponse;
import com.somesample.restandweb.model.ApplicationError;
import com.somesample.restandweb.model.CurrencyCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public ResponseEntity<CommonWebResponse> getCorrectCurrencyCodeAnswer(CurrencyCode cc){
        return new ResponseEntity<CommonWebResponse>(cc, HttpStatus.OK);
    }

    public ResponseEntity<CommonWebResponse> getBadRequestError(String message){
        return new ResponseEntity<CommonWebResponse>(new ApplicationError(message),
                HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<CommonWebResponse> getNotFoundError(String message){
        return new ResponseEntity<CommonWebResponse>(new ApplicationError(message),
                HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<CommonWebResponse> getInternalServerError(String message){
        return new ResponseEntity<CommonWebResponse>(new ApplicationError(message),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
