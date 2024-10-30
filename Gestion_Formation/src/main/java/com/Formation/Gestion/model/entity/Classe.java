package com.Formation.Gestion.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Table(name = "classe")
@Entity
@Data
@Builder
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "num_salle")
    private int numSalle;

    public Classe(Long id, String nom, int numSalle) {
        this.id = id;
        this.nom = nom;
        this.numSalle = numSalle;
    }

    public Classe() {

    }

    public int getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Classe: " + nom + ", Salle: " + numSalle;
    }
}
