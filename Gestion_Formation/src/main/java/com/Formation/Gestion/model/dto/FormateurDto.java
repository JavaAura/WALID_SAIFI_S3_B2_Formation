package com.Formation.Gestion.model.dto;
import com.Formation.Gestion.model.entity.Formateur;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FormateurDto {


    private Long id;
    private  String nom;
    private  String prenom;

    private String email;

    private String specialite;

    private Long formationId;
    private Long classeId;


    public FormateurDto toDto(Formateur entity) {
         return FormateurDto.builder()
                 .id(entity.getId())
                 .nom(entity.getNom())
                 .prenom(entity.getPrenom())
                 .email(entity.getEmail())
                 .specialite(entity.getSpecialite())
                 .build();
    }

    public  Formateur toEntity(FormateurDto dto) {
          Formateur formateur = new Formateur();
          formateur.setId(dto.getId());
          formateur.setNom(dto.getNom());
          formateur.setPrenom(dto.getPrenom());
          formateur.setEmail(dto.getEmail());
          formateur.setSpecialite(dto.getSpecialite());
          return formateur;
    }
}
