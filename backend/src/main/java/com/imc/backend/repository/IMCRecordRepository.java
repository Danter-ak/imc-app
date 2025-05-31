package com.imc.backend.repository;

import com.imc.backend.entities.IMCRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMCRecordRepository extends JpaRepository<IMCRecord, Long> {
}
