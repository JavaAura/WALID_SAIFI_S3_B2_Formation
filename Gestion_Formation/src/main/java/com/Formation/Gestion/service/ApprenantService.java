package com.Formation.Gestion.service;

import com.Formation.Gestion.model.entity.Apprenant;
import com.Formation.Gestion.model.entity.Classe;
import com.Formation.Gestion.model.entity.Formation;
import com.Formation.Gestion.repository.ApprenantRepo;
import com.Formation.Gestion.repository.ClasseRepo;
import com.Formation.Gestion.repository.FormationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ApprenantService {

    @Autowired
    private ApprenantRepo apprenantRepository;
    @Autowired
    private ClasseRepo classeRepo;
    @Autowired
    FormationRepo formationRepo;

    public List<Apprenant> getAllApprenants() {
        return this.apprenantRepository.findAll();
    }

    public Apprenant getApprenantById(Long id) {
        return apprenantRepository.findById(Math.toIntExact(id)).get();

    }

    public  Apprenant ajouterApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    public  Apprenant modifierApprenant(Apprenant apprenant,long id) {
        Apprenant apprenant1 = apprenantRepository.findById(Math.toIntExact(id)).get();
        apprenant1.setNom(apprenant.getNom());
        apprenant1.setPrenom(apprenant.getPrenom());
        apprenant1.setEmail(apprenant.getEmail());
       return  apprenantRepository.save(apprenant);
    }

    public  void supprimerApprenant(long id) {
       Apprenant apprenant = apprenantRepository.findById(Math.toIntExact(id)).get();
       apprenantRepository.delete(apprenant);
    }



    @Transactional
    public Apprenant affecterClasse(Long apprenantId, Long classeId) {
        Optional<Apprenant> apprenantOpt = apprenantRepository.findById(Math.toIntExact(apprenantId));
        Optional<Classe> classeOpt = classeRepo.findById(classeId);

        if (apprenantOpt.isPresent() && classeOpt.isPresent()) {
            Apprenant apprenant = apprenantOpt.get();
            Classe classe = classeOpt.get();
            apprenant.setClasse(classe);
            return apprenantRepository.save(apprenant);
        } else {
            return null;
        }
    }

    @Transactional
    public Apprenant affecterFormation(Long apprenantId, Long formationId) {
        Optional<Apprenant> apprenantOpt = apprenantRepository.findById(Math.toIntExact(apprenantId));
        Optional<Formation> formationOpt = formationRepo.findById(formationId);

        if (apprenantOpt.isPresent() && formationOpt.isPresent()) {
            Apprenant apprenant = apprenantOpt.get();
            Formation formation = formationOpt.get();
            apprenant.setFormation(formation);
            return apprenantRepository.save(apprenant);
        } else {
            return null;
        }
    }





}


