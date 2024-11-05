package com.Formation.Gestion.IntegrationTest;

import com.Formation.Gestion.model.entity.Formation;
import com.Formation.Gestion.repository.FormationRepo;
import com.Formation.Gestion.service.FormationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FormationServiceIntegrationTest {

    @Autowired
    private FormationService formationService;

    @Autowired
    private FormationRepo formationRepo;

    @BeforeEach
    void setUp() {
        formationRepo.deleteAll();

        Formation formation1 = new Formation();
        formation1.setTitre("Formation Java");
        formationService.createFormation(formation1);

        Formation formation2 = new Formation();
        formation2.setTitre("Formation Spring Boot");
        formationService.createFormation(formation2);
    }

    @Test
    void testGetAllFormations() {
        List<Formation> formations = formationService.getAll();
        assertEquals(2, formations.size());
    }

    @Test
    void testGetFormationById() {
        Formation formation = formationRepo.findAll().get(0);
        Formation foundFormation = formationService.getById(formation.getId());
        assertNotNull(foundFormation);
        assertEquals("Formation Java", foundFormation.getTitre());
    }

    @Test
    void testCreateFormation() {
        Formation newFormation = new Formation();
        newFormation.setTitre("Formation Docker");
        Formation savedFormation = formationService.createFormation(newFormation);

        assertNotNull(savedFormation);
        assertEquals("Formation Docker", savedFormation.getTitre());
        assertEquals(3, formationService.getAll().size());
    }

    @Test
    void testModifierFormation() {
        Formation existingFormation = formationRepo.findAll().get(0);
        existingFormation.setTitre("Formation Java Avancée");

        Formation updatedFormation = formationService.ModifierFormation(existingFormation.getId(), existingFormation);
        assertNotNull(updatedFormation);
        assertEquals("Formation Java Avancée", updatedFormation.getTitre());
    }

    @Test
    void testDeleteFormation() {
        Formation formation = formationRepo.findAll().get(0);
        formationService.deleteFormation(formation.getId());

        List<Formation> formations = formationService.getAll();
        assertEquals(1, formations.size());
    }
}
