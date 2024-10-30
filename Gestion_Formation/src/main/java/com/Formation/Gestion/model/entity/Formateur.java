package com.Formation.Gestion.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "formateur")
@Entity
public class Formateur {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Getter
    @Setter
    @Column(name = "nom")
    private  String nom;


    @Getter
    @Setter
    @Column(name = "prenom")
    private  String prenom;


    @Getter
    @Setter
    @Column(name ="Email")
    private String email;

    @Getter
    @Setter
    @Column(name = "specialite")
    private String specialite;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;



}
