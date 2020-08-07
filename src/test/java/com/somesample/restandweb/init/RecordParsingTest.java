package com.somesample.restandweb.init;

import com.somesample.restandweb.model.CurrencyCode;
import com.somesample.restandweb.repository.CurrencyCodeRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RecordParsingTest {

    @Autowired
    private WikiLoader wikiLoader;

    @Autowired
    private CurrencyCodeRepository currencyCodeRepository;

    @Test
    public void testTableStringParsing(){
        currencyCodeRepository.deleteAll();
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head><title>a</title></head>\n" +
                "<body>\n" +
                "<table>\n" +
                "<tr>\n" +
                "                <td>AMD</td>\n" +
                "                <td>051</td>\n" +
                "                <td>2</td>\n" +
                "                <td><a href=\"/wiki/Armenian_dram\" title=\"Armenian dram\">Armenian dram</a></td> \n" +
                "                <td><span class=\"flagicon\"><img alt=\"\" src=\"/upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Flag_of_Armenia.svg/23px-Flag_of_Armenia.svg.png\" decoding=\"async\" width=\"23\" height=\"12\" class=\"thumbborder\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Flag_of_Armenia.svg/35px-Flag_of_Armenia.svg.png 1.5x, /upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Flag_of_Armenia.svg/46px-Flag_of_Armenia.svg.png 2x\" data-file-width=\"1200\" data-file-height=\"600\">&nbsp;</span><a href=\"/wiki/Armenia\" title=\"Armenia\">Armenia</a> </td>\n" +
                "                </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
        Document doc = Jsoup.parse(html);
        Element row = doc.select("table").get(0).select("tr").get(0);
        wikiLoader.loadOneRecord(row);
        CurrencyCode cc = currencyCodeRepository.findByCode("AMD");
        assertNotNull(cc);
    }

}
