package com.Formation.Gestion.service;

import com.Formation.Gestion.model.entity.Classe;
import com.Formation.Gestion.model.entity.Formateur;
import com.Formation.Gestion.model.entity.Formation;
import com.Formation.Gestion.repository.ClasseRepo;
import com.Formation.Gestion.repository.FormateurRepo;
import com.Formation.Gestion.repository.FormationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FormateurService {

    @Autowired
    FormateurRepo formateurRepo;

    @Autowired
    private FormationRepo formationRepository;

    @Autowired
    private ClasseRepo classeRepository;



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


    public Formateur affecterFormation(Long formateurId, Long formationId) {
        Optional<Formateur> formateurOpt = formateurRepo.findById(formateurId);
        Optional<Formation> formationOpt = formationRepository.findById(formationId);

        if (formateurOpt.isPresent() && formationOpt.isPresent()) {
            Formateur formateur = formateurOpt.get();
            formateur.setFormation(formationOpt.get());
            return formateurRepo.save(formateur);
        }
        return null;
    }

    public Formateur affecterClasse(Long formateurId, Long classeId) {
        Optional<Formateur> formateurOpt = formateurRepo.findById(formateurId);
        Optional<Classe> classeOpt = classeRepository.findById(classeId);

        if (formateurOpt.isPresent() && classeOpt.isPresent()) {
            Formateur formateur = formateurOpt.get();
            formateur.setClasse(classeOpt.get());
            return formateurRepo.save(formateur);
        }
        return null;
    }
}

