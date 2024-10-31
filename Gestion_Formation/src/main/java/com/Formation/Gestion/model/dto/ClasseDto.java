package com.Formation.Gestion.model.dto;
import com.Formation.Gestion.model.entity.Apprenant;
import com.Formation.Gestion.model.entity.Classe;
import com.Formation.Gestion.model.entity.Formateur;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClasseDto {



    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "Le numero de salle est obligatoire")
    private int numSalle;

    private List<Long> apprenantsIds;
    private List<Long> formateursIds;

    public static ClasseDto toDto(Classe entity) {
        return ClasseDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .numSalle(entity.getNumSalle())
                .apprenantsIds(entity.getApprenants().stream().map(Apprenant::getId).collect(Collectors.toList()))
                .formateursIds(entity.getFormateurs().stream().map(Formateur::getId).collect(Collectors.toList()))
                .build();
    }



}
