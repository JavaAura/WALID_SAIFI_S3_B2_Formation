package com.Formation.Gestion.model.dto;

import com.Formation.Gestion.model.entity.Apprenant;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApprenantDto {

    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @Email(message = "Email invalide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    private String niveau;

    private Long classeId;

    private Long formationId;

    public static ApprenantDto toDto(Apprenant apprenant) {
        return ApprenantDto.builder()
                .id(apprenant.getId())
                .nom(apprenant.getNom())
                .prenom(apprenant.getPrenom())
                .email(apprenant.getEmail())
                .niveau(apprenant.getNiveau())
                .classeId(apprenant.getClasse().getId())
                .formationId(Long.valueOf(apprenant.getFormation().getId()))
                .build();
    }


    public static Apprenant toEntity(ApprenantDto dto) {
        Apprenant apprenant = new Apprenant();
        apprenant.setId(dto.getId());
        apprenant.setNom(dto.getNom());
        apprenant.setPrenom(dto.getPrenom());
        apprenant.setEmail(dto.getEmail());
        apprenant.setNiveau(dto.getNiveau());
        return apprenant;
    }
}
