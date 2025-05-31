package com.imc.backend.service;

import com.imc.backend.entities.IMCRecord;

import java.util.List;

public interface IMCRecordService {
    IMCRecord saveRecord(IMCRecord record);
    List<IMCRecord> getAllRecords();
}