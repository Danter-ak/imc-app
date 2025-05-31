package com.imc.backend.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class IMCRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double taille;
    private double poids;
    private double imc;
    private String categorie;
    private LocalDateTime dateCalcul;

    public IMCRecord() {}

    public IMCRecord(double taille, double poids, double imc, String categorie) {
        this.taille = taille;
        this.poids = poids;
        this.imc = imc;
        this.categorie = categorie;
        this.dateCalcul = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public LocalDateTime getDateCalcul() {
        return dateCalcul;
    }

    public void setDateCalcul(LocalDateTime dateCalcul) {
        this.dateCalcul = dateCalcul;
    }

    @Override
    public String toString() {
        return "IMCRecord{" +
                "id=" + id +
                ", taille=" + taille +
                ", poids=" + poids +
                ", imc=" + imc +
                ", categorie='" + categorie + '\'' +
                ", dateCalcul=" + dateCalcul +
                '}';
    }
}