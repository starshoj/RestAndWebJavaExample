package com.somesample.restandweb.repository;

import com.somesample.restandweb.model.CurrencyCode;
import com.somesample.restandweb.model.LogRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class LogRecordRepositoryTest {

    @Autowired
    private LogRecordRepository logRecordRepository;

    @Test
    public void testSaveLogRecordsAndGetInRightOrder(){
        //3 records created, 2 with current timestamp and 1 in the past
        //In result they should be sorted by date
        LogRecord logRecord = new LogRecord(LocalDateTime.now(), "XYZ", "5.5.5.5");
        logRecordRepository.save(logRecord);
        LogRecord logRecord2 = new LogRecord(LocalDateTime
                .of(1980,1,1,1,1), "qqq", "1.1.1.1");
        logRecordRepository.save(logRecord2);
        LogRecord logRecord3 = new LogRecord(LocalDateTime.now(), "abc", "2.2.2.2");
        logRecordRepository.save(logRecord3);

        List<LogRecord> logs = logRecordRepository.findAllByOrderByDateTimeAsc();
        assertEquals(logs.size(),3);
        assertEquals(logRecord.getCode(), logs.get(1).getCode());
        assertEquals(logRecord2.getCode(), logs.get(0).getCode());
        assertEquals(logRecord3.getCode(), logs.get(2).getCode());
    }

}
