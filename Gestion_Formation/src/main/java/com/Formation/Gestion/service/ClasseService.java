package com.Formation.Gestion.service;

import com.Formation.Gestion.model.entity.Classe;
import com.Formation.Gestion.repository.ClasseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepo classeRepo;

    public List<Classe> getAllClasse(){
       return this.classeRepo.findAll();
    }

    public Classe ajouterClasse(Classe classe){
        this.classeRepo.save(classe);
        return classe;
    }

    public Classe modifierClasse(Classe classe){
        this.classeRepo.save(classe);

        return classe;
    }


    public Classe getClasseById(long id){
        return this.classeRepo.findById(id).get();
    }
    public  void deleteClasseById(long id){
        this.classeRepo.deleteById(id);
    }

}
