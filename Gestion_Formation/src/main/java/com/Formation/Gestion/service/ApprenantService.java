package com.Formation.Gestion.service;

import com.Formation.Gestion.model.entity.Apprenant;
import com.Formation.Gestion.repository.ApprenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprenantService {

    @Autowired
    private ApprenantRepo apprenantRepository;
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




}
