package com.somesample.restandweb.service;

import com.somesample.restandweb.inter.CommonWebResponse;
import com.somesample.restandweb.model.ApplicationError;
import com.somesample.restandweb.model.CurrencyCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ResponseServiceTest {

    @Autowired
    private ResponseService responseService;

    @Test
    public void testNotFoundError(){
        String message = "Some message";
        ResponseEntity<CommonWebResponse> response1 =
                responseService.getNotFoundError(message);
        assertEquals(((ApplicationError)response1.getBody()).getError(),message);
        assertEquals(response1.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void testBadRequestError(){
        String message = "Some message";
        ResponseEntity<CommonWebResponse> response1 =
                responseService.getBadRequestError(message);
        assertEquals(((ApplicationError)response1.getBody()).getError(),message);
        assertEquals(response1.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testInternalServerError(){
        String message = "Some message";
        ResponseEntity<CommonWebResponse> response1 =
                responseService.getInternalServerError(message);
        assertEquals(((ApplicationError)response1.getBody()).getError(),message);
        assertEquals(response1.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void testCorectResponse(){
        String code = "COD", num = "567", e = "3", currency = "Yet Another Currency";
        CurrencyCode cc = new CurrencyCode(code,num,e,currency);
        ResponseEntity<CommonWebResponse> response1 =
                responseService.getCorrectCurrencyCodeAnswer(cc);
        assertEquals(((CurrencyCode)response1.getBody()).getCode(),code);
        assertEquals(((CurrencyCode)response1.getBody()).getNum(),num);
        assertEquals(((CurrencyCode)response1.getBody()).getE(),e);
        assertEquals(((CurrencyCode)response1.getBody()).getCurrency(),currency);
        assertEquals(response1.getStatusCode(), HttpStatus.OK);
    }

}
