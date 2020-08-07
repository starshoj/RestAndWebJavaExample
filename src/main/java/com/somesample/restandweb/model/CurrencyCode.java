package com.somesample.restandweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.somesample.restandweb.inter.CommonWebResponse;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "CURRENCYCODE")
public class CurrencyCode implements CommonWebResponse {

    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "NUM")
    private String num;

    @Column(name = "E")
    private String e;

    @Column(name = "CURRENCY")
    private String currency;

    public CurrencyCode(){};
    public CurrencyCode(String code, String num, String e, String currency){
        this.code = code;
        this.num = num;
        this.e = e;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNum() { return num; }

    public void setNum(String num) {
        this.num = num;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}

