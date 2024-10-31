package com.Formation.Gestion.model.dto;

import com.Formation.Gestion.model.entity.Formation;
import com.Formation.Gestion.model.entity.Formateur;
import com.Formation.Gestion.model.entity.Classe;
import com.Formation.Gestion.model.entity.Statut;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class FormationDto {

    private long id;
    private String titre;
    private String niveau;
    private String prerequis;
    private Integer capaciteMin;
    private Integer capaciteMax;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Classe classe;
    private Formateur formateur;
    private List<Long> apprenantsId; // Liste utilisée uniquement en lecture
    private Statut statut;

    // Conversion de l'entité Formation vers FormationDto
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
                .classe(entity.getClasse())
                .formateur(entity.getFormateur())
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
