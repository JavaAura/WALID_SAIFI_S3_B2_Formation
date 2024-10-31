package com.Formation.Gestion.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "formation")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(name = "titre")
    private String titre;


    @Getter
    @Setter
    @Column(name = "niveau")
    private String niveau;


    @Getter
    @Setter
    @Column(name = "prerequis")
    private String prerequis;

    @Getter
    @Setter
    @Column(name = "capaciteMin")
    private Integer capaciteMin;

    @Getter
    @Setter
    @Column(name = "capaciteMax")
    private Integer capaciteMax;


    @Getter
    @Setter
    @Column(name = "dateDebut")
    private LocalDate dateDebut;

    @Getter
    @Setter
    @Column(name = "dateFin")
    private LocalDate dateFin;

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

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    @Getter
    @Setter
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    private List<Apprenant> apprenants;


    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false)
    private Statut statut;


}
