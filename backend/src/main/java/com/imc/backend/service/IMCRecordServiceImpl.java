package com.imc.backend.service;

import com.imc.backend.entities.IMCRecord;
import com.imc.backend.repository.IMCRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IMCRecordServiceImpl implements IMCRecordService {

    @Autowired
    private IMCRecordRepository repository;

    @Override
    public IMCRecord saveRecord(IMCRecord record) {
        return repository.save(record);
    }

    @Override
    public List<IMCRecord> getAllRecords() {
        return repository.findAll();
    }
}