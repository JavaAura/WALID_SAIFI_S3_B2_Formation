package com.Formation.Gestion.service;

import com.Formation.Gestion.model.entity.Formateur;
import com.Formation.Gestion.repository.FormateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FormateurService {

    @Autowired
    FormateurRepo formateurRepo;

    public List<Formateur> getAll(){
        return formateurRepo.findAll();
    }

    public Formateur getById(long id){
        return formateurRepo.getById(id);
    }

    public  Formateur ajouterFormateur(Formateur formateur){
        return  formateurRepo.save(formateur);
    }

    public Formateur ModiferFormateur(Formateur formateur,long id){
        Formateur formateurModif = formateurRepo.getById(id);
        formateurModif.setNom(formateur.getNom());
        formateurModif.setPrenom(formateur.getPrenom());
        formateurModif.setEmail(formateur.getEmail());
        formateurModif.setSpecialite(formateur.getSpecialite());
        return formateurRepo.save(formateurModif);
    }
    public  void  supprimerFormateur(long id){
        formateurRepo.deleteById(id);
    }

}
