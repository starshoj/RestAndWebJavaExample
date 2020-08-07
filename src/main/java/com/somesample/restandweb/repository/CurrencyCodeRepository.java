package com.somesample.restandweb.repository;

import com.somesample.restandweb.model.CurrencyCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyCodeRepository extends CrudRepository<CurrencyCode, Long> {

    public CurrencyCode findByCode(String code);

}
