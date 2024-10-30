package com.Formation.Gestion.controller;


import com.Formation.Gestion.model.entity.Classe;
import com.Formation.Gestion.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/classe")
@RestController


public class ClasseController {

    @Autowired
    private ClasseService classeService;;


    @GetMapping("/all")
    public List<Classe> getAllClasses() {
        return classeService.getAllClasse();
    }

    @PostMapping("/ajouter")
    public ResponseEntity<String> ajouterClasse(@RequestParam String name, @RequestParam int  numSalle){
        Classe classe = new Classe();
        classe.setNom(name);
        classe.setNumSalle(numSalle);
        this.classeService.ajouterClasse(classe);
        return ResponseEntity.ok("Classe ajoutée avec succès.   " +classe);
    }


    @PutMapping("/modifier/{id}")
    public ResponseEntity<String> modifierClasse(@PathVariable Long id,@RequestParam String name, @RequestParam int  numSalle){
        Classe classe = classeService.getClasseById(id);
        if (classe == null) {
            return ResponseEntity.status(404).body("Classe non trouvée.");
        }
        classe.setNom(name);
        classe.setNumSalle(numSalle);
        this.classeService.modifierClasse(classe);
        return ResponseEntity.ok("Classe modifiée avec succès.");

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
