package com.somesample.restandweb.model;

import com.somesample.restandweb.inter.CommonWebResponse;

public class ApplicationError implements CommonWebResponse {
    private String error;

    public ApplicationError(String error){
        this.error=error;
    }

    public String getError() { return error; }

    public void setError(String error) {
        this.error = error;
    }
}
