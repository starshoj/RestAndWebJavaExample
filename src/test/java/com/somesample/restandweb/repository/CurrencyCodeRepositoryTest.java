package com.somesample.restandweb.repository;

import com.somesample.restandweb.model.CurrencyCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CurrencyCodeRepositoryTest {

    @Autowired
    private CurrencyCodeRepository currencyCodeRepository;

    @Test
    public void testSaveAnGetCurrencyCode(){
        CurrencyCode currencyCode =
                new CurrencyCode("ABC", "111", "5","Test currency");
        currencyCodeRepository.save(currencyCode);
        CurrencyCode currencyCode2 = currencyCodeRepository.findByCode("ABC");
        assertNotNull(currencyCode);
        assertEquals(currencyCode2.getNum(), currencyCode.getNum());
        assertEquals(currencyCode2.getE(), currencyCode.getE());
        assertEquals(currencyCode2.getCurrency(), currencyCode.getCurrency());
    }

}
