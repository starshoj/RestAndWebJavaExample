package com.somesample.restandweb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ValidationServiceTest {

    @Autowired
    private ValidationService validationService;

    @Test
    public void testCodeValidation(){
        assertTrue(validationService.isCodeValid("AAA"));
        assertFalse(validationService.isCodeValid("BB"));
        assertFalse(validationService.isCodeValid("CCCC"));
    }
}

