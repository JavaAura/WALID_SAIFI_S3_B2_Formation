package com.Formation.Gestion.controller;

import com.Formation.Gestion.model.dto.FormationDto;
import com.Formation.Gestion.model.entity.Formation;
import com.Formation.Gestion.service.FormationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/formation")
public class FormationController {

    @Autowired
    private FormationService formationService;

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FormationDto>> getAll() {
        List<Formation> formations = formationService.getAll();
        List<FormationDto> formationDtos = formations.stream()
                .map(FormationDto::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(formationDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormationDto> getById(@PathVariable long id) {
        Formation formation = formationService.getById(id);
        if (formation != null) {
            FormationDto formationDto = FormationDto.toDto(formation);
            return new ResponseEntity<>(formationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/ajouter", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormationDto> createFormation(@Valid @RequestBody FormationDto formationDto) {
        Formation formationEntity = formationDto.toEntity();

        Formation createdFormation = formationService.createFormation(formationEntity);

        if (createdFormation != null) {
            FormationDto createdFormationDto = FormationDto.toDto(createdFormation);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFormationDto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @PutMapping(value = "/modifier/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormationDto> updateFormation(@PathVariable long id, @Valid @RequestBody FormationDto formationDto) {
        Formation formationToUpdate = formationDto.toEntity();
        Formation updatedFormation = formationService.ModifierFormation(id, formationToUpdate);
        if (updatedFormation != null) {
            FormationDto updatedFormationDto = FormationDto.toDto(updatedFormation);
            return new ResponseEntity<>(updatedFormationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable long id) {
        formationService.deleteFormation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
