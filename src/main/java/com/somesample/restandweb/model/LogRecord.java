package com.somesample.restandweb.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LOGRECORD")
public class LogRecord {

    @Id
    @GenericGenerator(name="logrecord" , strategy="increment")
    @GeneratedValue(generator="logrecord")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

    @Column(name = "CODE")
    private String code;

    @Column(name = "IP")
    private String ip;

    public LogRecord(){}
    public LogRecord(LocalDateTime dateTime, String code, String ip){
        this.dateTime = dateTime;
        this.code = code;
        this.ip = ip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String toString(){
        return String.format("DateTime: %s            Code: %s             IP: %s   ",
                             this.getDateTime().toString(),this.getCode(),this.getIp());
    }

}

