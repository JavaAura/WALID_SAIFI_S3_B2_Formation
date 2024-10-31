package com.Formation.Gestion.model.dto;

import com.Formation.Gestion.model.entity.*;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder

public class FormationDto {


    private int id;

    private String titre;

    private String niveau;


    private String prerequis;


    private Integer capaciteMin;

    private Integer capaciteMax;

    private LocalDate dateDebut;


    private LocalDate dateFin;

    private Formation formation;


    private Classe classe;

    private Formateur formateur;

    private List<Long> apprenantsId;

    private Statut statut;

    public static FormationDto toDto(Formation entity) {
        return FormationDto.builder()
                .id(entity.getId())
                .titre(entity.getTitre())
                .niveau(entity.getNiveau())
                .prerequis(entity.getPrerequis())
                .capaciteMin(entity.getCapaciteMin())
                .capaciteMax(entity.getCapaciteMax())
                .dateDebut(entity.getDateDebut())
                .dateFin(entity.getDateFin())
                .statut(entity.getStatut())
                .build();
    }

    
    public Formation toEntity() {
        Formation formation = new Formation();
        formation.setId(this.id);
        formation.setTitre(this.titre);
        formation.setNiveau(this.niveau);
        formation.setPrerequis(this.prerequis);
        formation.setCapaciteMin(this.capaciteMin);
        formation.setCapaciteMax(this.capaciteMax);
        formation.setDateDebut(this.dateDebut);
        formation.setDateFin(this.dateFin);
        formation.setStatut(this.statut);
        return formation;
    }
}
