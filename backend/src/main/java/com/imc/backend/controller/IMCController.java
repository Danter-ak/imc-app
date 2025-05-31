package com.imc.backend.controller;

import com.imc.backend.entities.IMCRecord;
import com.imc.backend.entities.IMCRequest;
import com.imc.backend.entities.IMCResponse;
import com.imc.backend.repository.IMCRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imc")
@CrossOrigin(origins = "http://localhost:4200")
public class IMCController {

    @Autowired
    private IMCRecordRepository repository;

    @PostMapping
    public IMCResponse calculerIMC(@RequestBody IMCRequest request) {
        double imc = request.getPoids() / (request.getTaille() * request.getTaille());
        String categorie;

        if (imc < 18.5) {
            categorie = "Insuffisance pondérale";
        } else if (imc < 25) {
            categorie = "Poids normal";
        } else if (imc < 30) {
            categorie = "Surpoids";
        } else {
            categorie = "Obésité";
        }

        // Enregistrement
        IMCRecord record = new IMCRecord(request.getTaille(), request.getPoids(), imc, categorie);
        repository.save(record);

        return new IMCResponse(imc, categorie);
    }
}