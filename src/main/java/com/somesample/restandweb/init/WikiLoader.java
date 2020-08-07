package com.somesample.restandweb.init;

import com.somesample.restandweb.model.CurrencyCode;
import com.somesample.restandweb.repository.CurrencyCodeRepository;
import com.somesample.restandweb.repository.LogRecordRepository;
import com.somesample.restandweb.service.LoggingService;
import com.somesample.restandweb.service.ValidationService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class WikiLoader {

    @Autowired
    private CurrencyCodeRepository currencyCodeRepository;

    @Autowired
    private LogRecordRepository logRecordRepository;

    @Autowired
    private LoggingService loggingService;

    @Autowired
    private ValidationService validationService;

    private static final Logger log = LoggerFactory.getLogger(WikiLoader.class);

    @PostConstruct
    private void init() {
        log.info("Starting wiki data loader ...");
        loadData();
        log.info("Wiki data loaded");
    }

    private void loadData(){
        try {
            Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/ISO_4217").get();
            //Needed table is second in the list
            Element table = doc.select("table").get(1);

            Elements rows = table.select("tr");

            for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
                loadOneRecord(rows.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("a");
    }

    public void loadOneRecord(Element row){
        try {
            Elements cols = row.select("td");
            String code = cleanValue(cols.get(0).text());
            String num = cols.get(1).text();
            String ecolumn = cleanValue(cols.get(2).text());
            String currency = cleanValue(cols.get(3).text());

            CurrencyCode cc = new CurrencyCode(code, num, ecolumn, currency);
            currencyCodeRepository.save(cc);
        } catch (Exception e){
            log.error("Currency parsing error for {}", row);
            e.printStackTrace();
        }
    }

    public static String cleanValue(String s){
        //replacing content of square brackets
        return s.replaceAll("\\[\\w+\\]", "");
    }

    //for test reasons
    /*private void sampleData(){
        CurrencyCode cc = new CurrencyCode();
        cc.setCode("ABC");
        currencyCodeRepository.save(cc);
        LogRecord lr = new LogRecord();
        lr.setDateTime(parseDateTime("1980-01-01 23:01"));
        lr.setIp("1.1.1.1");
        LogRecord lr2 = new LogRecord();
        lr2.setDateTime(parseDateTime("1970-01-01 22:59"));
        lr2.setIp("2.2.2.3");
        LogRecord lr3 = new LogRecord();
        lr3.setDateTime(parseDateTime("1990-02-06 08:00"));
        lr3.setIp("3.3.3.3");
        logRecordRepository.save(lr);
        logRecordRepository.save(lr2);
        logRecordRepository.save(lr3);
    }*/



}