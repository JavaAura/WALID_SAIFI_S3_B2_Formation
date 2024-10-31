package com.Formation.Gestion.service;
import com.Formation.Gestion.model.entity.Formation;

import com.Formation.Gestion.repository.FormationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService {

    @Autowired
    FormationRepo formationRepo;

    public List<Formation> getAll() {
        return formationRepo.findAll();
    }

    public Formation getById(long id) {
        Optional<Formation> formation = formationRepo.findById(id);
        return formation.orElse(null); // Return null if not found
    }

    public Formation createFormation(Formation formation) {
        return formationRepo.save(formation);
    }
    @Transactional
    public Formation ModifierFormation(long id, Formation formation) {
        if (formationRepo.existsById(id)) {
            formation.setId(id);
            return formationRepo.save(formation);
        } else {
            return null;
        }
    }

    public void deleteFormation(long id) {
        formationRepo.deleteById(id);
    }



}
