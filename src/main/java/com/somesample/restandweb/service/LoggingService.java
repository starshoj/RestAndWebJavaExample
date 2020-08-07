package com.somesample.restandweb.service;

import com.somesample.restandweb.model.LogRecord;
import com.somesample.restandweb.repository.LogRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoggingService {

    @Autowired
    private LogRecordRepository logRecordRepository;

    public void logRequest(String code, String ip){
        LogRecord lr = new LogRecord();
        lr.setDateTime(LocalDateTime.now());
        lr.setCode(code);
        lr.setIp(ip);
        logRecordRepository.save(lr);
    }

}
