package com.somesample.restandweb.repository;


import com.somesample.restandweb.model.LogRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRecordRepository extends CrudRepository<LogRecord, Long> {

    public List<LogRecord> findAllByOrderByDateTimeAsc();

}
