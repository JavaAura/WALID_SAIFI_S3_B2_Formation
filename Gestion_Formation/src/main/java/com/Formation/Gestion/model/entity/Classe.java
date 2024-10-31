package com.Formation.Gestion.model.entity;

import com.Formation.Gestion.model.dto.ClasseDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "classe")
@Entity
@Data
@Builder
@AllArgsConstructor

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


    public static Classe toEntity(ClasseDto classeDto) {
        Classe classe = new Classe();
        classe.setId(classeDto.getId());
        classe.setNom(classeDto.getNom());
        classe.setNumSalle(classeDto.getNumSalle());
        return classe;
    }

}
