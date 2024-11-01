package com.Formation.Gestion.controller;

import com.Formation.Gestion.model.dto.ApprenantDto;
import com.Formation.Gestion.model.entity.Apprenant;
import com.Formation.Gestion.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/apprenants")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ApprenantDto>> getAllApprenants() {
        List<Apprenant> apprenants = apprenantService.getAllApprenants();
        List<ApprenantDto> apprenantDtos = apprenants.stream()
                .map(ApprenantDto::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(apprenantDtos, HttpStatus.OK);
    }

    @GetMapping("getByid/{id}")
    public ResponseEntity<ApprenantDto> getApprenantById(@PathVariable Long id) {
        Optional<Apprenant> apprenant = Optional.ofNullable(apprenantService.getApprenantById(id));
        return apprenant.map(value -> new ResponseEntity<>(ApprenantDto.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/ajouter")
    public ResponseEntity<ApprenantDto> ajouterApprenant(@Valid @RequestBody ApprenantDto apprenantDto) {
        Apprenant apprenant = ApprenantDto.toEntity(apprenantDto);
        Apprenant savedApprenant = apprenantService.ajouterApprenant(apprenant);
        return new ResponseEntity<>(ApprenantDto.toDto(savedApprenant), HttpStatus.CREATED);
    }

    @PutMapping("modifier/{id}")
    public ResponseEntity<ApprenantDto> modifierApprenant(@PathVariable Long id,
                                                          @Valid @RequestBody ApprenantDto apprenantDto) {
        Apprenant apprenant = ApprenantDto.toEntity(apprenantDto);
        Apprenant modifiedApprenant = apprenantService.modifierApprenant(apprenant, id);
        return new ResponseEntity<>(ApprenantDto.toDto(modifiedApprenant), HttpStatus.OK);
    }

    @DeleteMapping("supprimer/{id}")
    public ResponseEntity<Void> supprimerApprenant(@PathVariable Long id) {
        apprenantService.supprimerApprenant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/affecterClasse/{apprenantId}/{classeId}")
    public ResponseEntity<ApprenantDto> affecterClasse(@PathVariable Long apprenantId, @PathVariable Long classeId) {
        Apprenant apprenant = apprenantService.affecterClasse(apprenantId, classeId);
        if (apprenant != null) {
            return new ResponseEntity<>(ApprenantDto.toDto(apprenant), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/affecterFormation/{apprenantId}/{formationId}")
    public ResponseEntity<ApprenantDto> affecterFormation(@PathVariable Long apprenantId, @PathVariable Long formationId) {
        Apprenant apprenant = apprenantService.affecterFormation(apprenantId, formationId);
        if (apprenant != null) {
            return new ResponseEntity<>(ApprenantDto.toDto(apprenant), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
