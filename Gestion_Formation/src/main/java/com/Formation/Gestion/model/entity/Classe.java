package com.Formation.Gestion.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "classe")
@Entity
@Data
@Builder
public class Classe {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "nom")
    private String nom;

    @Getter
    @Setter
    @Column(name = "num_salle")
    private int numSalle;

    public Classe(Long id, String nom, int numSalle, List<Apprenant> apprenants, List<Formateur> formateurs) {
        this.id = id;
        this.nom = nom;
        this.numSalle = numSalle;
        this.apprenants = apprenants;
        this.formateurs = formateurs;
    }

    @Getter
    @Setter
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apprenant> apprenants;


    @Getter
    @Setter
    @OneToMany(mappedBy = "classe")
    private List<Formateur> formateurs;

    public Classe() {

    }

    @Override
    public String toString() {
        return "Classe: " + nom + ", Salle: " + numSalle;
    }
}
