package com.somesample.restandweb.service;

import com.somesample.restandweb.model.LogRecord;
import com.somesample.restandweb.repository.LogRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LoggingServiceTest {

    @Autowired
    private LogRecordRepository logRecordRepository;

    @Autowired
    private LoggingService loggingService;

    @Test
    public void testSaveLogRecord(){
        logRecordRepository.deleteAll();
        String code = "AAA", ip = "10.10.10.10";
        loggingService.logRequest(code,ip);
        LogRecord logRecord = logRecordRepository.findAllByOrderByDateTimeAsc().get(0);
        assertEquals(logRecord.getCode(), code);
        assertEquals(logRecord.getIp(), ip);
        assertNotNull(logRecord.getDateTime());
        assertNotNull(logRecord.getId());
    }

}
