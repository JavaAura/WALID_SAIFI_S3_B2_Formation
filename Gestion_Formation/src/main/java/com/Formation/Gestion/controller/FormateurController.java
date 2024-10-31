package com.Formation.Gestion.controller;

import com.Formation.Gestion.model.dto.FormateurDto;
import com.Formation.Gestion.model.entity.Formateur;
import com.Formation.Gestion.service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/formateur")
public class FormateurController {
    @Autowired
    private FormateurService formateurService;

    @GetMapping("/getAll")
    private ResponseEntity<List<FormateurDto>> getAll() {
        List<Formateur> formateurs = formateurService.getAll();

        List<FormateurDto> formateurDtos = formateurs.stream()
                .map(FormateurDto::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(formateurDtos, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<FormateurDto> getById(@PathVariable long id) {
        Formateur formateur = formateurService.getById(id);
        if (formateur == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        FormateurDto formateurDto = FormateurDto.toDto(formateur);
        return new ResponseEntity<>(formateurDto, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<FormateurDto> ajouterFormateur(@RequestBody FormateurDto formateurDto) {
        Formateur formateur = formateurDto.toEntity(formateurDto);
        Formateur savedFormateur = formateurService.ajouterFormateur(formateur);
        FormateurDto savedFormateurDto = FormateurDto.toDto(savedFormateur);
        return new ResponseEntity<>(savedFormateurDto, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<FormateurDto> modifierFormateur(@PathVariable long id, @RequestBody FormateurDto formateurDto) {
        Formateur formateur = formateurDto.toEntity(formateurDto);
        Formateur updatedFormateur = formateurService.ModiferFormateur(formateur, id);
        if (updatedFormateur == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        FormateurDto updatedFormateurDto = FormateurDto.toDto(updatedFormateur);
        return new ResponseEntity<>(updatedFormateurDto, HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerFormateur(@PathVariable long id) {
        formateurService.supprimerFormateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
