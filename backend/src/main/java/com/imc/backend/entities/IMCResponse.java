package com.imc.backend.entities;

public class IMCResponse {
    private double imc;
    private String categorie;

    public IMCResponse(double imc, String categorie) {
        this.imc = imc;
        this.categorie = categorie;
    }

    public double getImc() {
        return imc;
    }

    public String getCategorie() {
        return categorie;
    }
}