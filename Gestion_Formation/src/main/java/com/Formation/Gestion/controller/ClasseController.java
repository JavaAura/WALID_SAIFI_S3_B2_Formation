package com.Formation.Gestion.controller;


import com.Formation.Gestion.model.dto.ClasseDto;
import com.Formation.Gestion.model.entity.Classe;
import com.Formation.Gestion.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/classe")
@RestController


public class ClasseController {

    @Autowired
    private ClasseService classeService;;


    @GetMapping("/all")
    public List<ClasseDto> getAllClasses() {
        List<ClasseDto> classeDtos = new ArrayList<>();
        classeService.getAllClasse().forEach(classe -> classeDtos.add(ClasseDto.toDto(classe)));
        return classeDtos;
    }


    @PostMapping("/ajouter")
    public ResponseEntity<Classe> ajouterClasse(@RequestParam String name, @RequestParam int numSalle) {
        ClasseDto classeDto = new ClasseDto();
        classeDto.setNom(name);
        classeDto.setNumSalle(numSalle);
        Classe savedClasse = this.classeService.ajouterClasse(Classe.toEntity(classeDto));
        return ResponseEntity.ok(savedClasse);
    }



    @PutMapping("/modifier/{id}")
    public ResponseEntity<Map<String, Object>> modifierClasse(@PathVariable Long id, @RequestParam String name, @RequestParam int numSalle) {
        Optional<Classe> optionalClasse = Optional.ofNullable(classeService.getClasseById(id));

        Classe classe = optionalClasse.get();
        classe.setNom(name);
        classe.setNumSalle(numSalle);
        Classe updatedClasse = this.classeService.modifierClasse(classe);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Classe modifiée avec succès.");
        response.put("classe", updatedClasse);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClasse(@PathVariable long id) {
        try {
            this.classeService.deleteClasseById(id);
            return ResponseEntity.ok("Classe supprimée avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Classe non trouvée.");
        }
    }





}
