package com.somesample.restandweb.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isCodeValid(String s){
        if(s==null||s.length()>3||s.length()<3)
            return false;
        else return true;
    }
}
