package com.Formation.Gestion.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "apprenants")
public class Apprenant {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    @Setter
    @Column(name = "nom")
    private String nom;

    @Setter
    @Getter
    @Column(name = "prenom")
    private String prenom;


    @Setter
    @Getter
    @Column(name = "email")
    private String email;

    @Setter
    @Getter
    @Column(name = "niveau")
    private String niveau;


    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;


    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;


}
