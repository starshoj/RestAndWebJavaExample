package com.somesample.restandweb.controller;

import com.somesample.restandweb.model.LogRecord;
import com.somesample.restandweb.repository.LogRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebLogController {

    @Autowired
    private LogRecordRepository logRecordRepository;

    private List<LogRecord> logRecords;

    @GetMapping("/log")
    public String main(Model model) {
        logRecords = logRecordRepository.findAllByOrderByDateTimeAsc();
        model.addAttribute("logRecords", logRecords);

        return "log"; //view
    }

}