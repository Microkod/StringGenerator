package com.example.stringgenerator.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Statement;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;


    public Record addNewRecord(@RequestParam String name) {
        Record r = new Record(name);
        recordRepository.save(r);
        return r;
    }

    public @ResponseBody Iterable<Record> getAllRecords() {
        return recordRepository.findAll();
    }


    public void deleteRecords(){
        recordRepository.deleteAll();
    }
}
