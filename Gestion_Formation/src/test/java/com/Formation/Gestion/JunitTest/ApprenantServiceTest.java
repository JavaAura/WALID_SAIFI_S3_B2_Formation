package com.Formation.Gestion.JunitTest;

import com.Formation.Gestion.model.entity.Apprenant;
import com.Formation.Gestion.repository.ApprenantRepo;
import com.Formation.Gestion.repository.ClasseRepo;
import com.Formation.Gestion.repository.FormationRepo;
import com.Formation.Gestion.service.ApprenantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApprenantServiceTest {

    @InjectMocks
    private ApprenantService apprenantService;

    @Mock
    private ApprenantRepo apprenantRepo;

    @Mock
    private ClasseRepo classeRepo;

    @Mock
    private FormationRepo formationRepo;

    private Apprenant apprenant;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        apprenant = new Apprenant();
        apprenant.setId(1L);
        apprenant.setNom("Doe");
        apprenant.setPrenom("John");
        apprenant.setEmail("walid@gmail.com");
    }

    @Test
    void testGetAllApprenants() {
        when(apprenantRepo.findAll()).thenReturn(Arrays.asList(apprenant));

        assertEquals(1, apprenantService.getAllApprenants().size());
    }

    @Test
    void testGetApprenantById() {
        when(apprenantRepo.findById(1)).thenReturn(Optional.of(apprenant));
        Apprenant found = apprenantService.getApprenantById(1L);
        assertEquals(apprenant, found);
    }

    @Test
    void testAjouterApprenant() {
        when(apprenantRepo.save(any(Apprenant.class))).thenReturn(apprenant);
        Apprenant saved = apprenantService.ajouterApprenant(apprenant);
        assertEquals(apprenant, saved);
        verify(apprenantRepo, times(1)).save(apprenant);
    }

    @Test
    void testModifierApprenant() {
        when(apprenantRepo.findById(1)).thenReturn(Optional.of(apprenant));
        when(apprenantRepo.save(any(Apprenant.class))).thenReturn(apprenant);

        Apprenant updated = new Apprenant();
        updated.setNom("Smith");
        updated.setPrenom("Jane");
        updated.setEmail("jane.smith@example.com");

        Apprenant saved = apprenantService.modifierApprenant(updated, 1L);
        assertEquals(updated.getNom(), saved.getNom());
        verify(apprenantRepo, times(1)).save(any(Apprenant.class));
    }

    @Test
    void testSupprimerApprenant() {
        when(apprenantRepo.findById(1)).thenReturn(Optional.of(apprenant));
        apprenantService.supprimerApprenant(1L);
        verify(apprenantRepo, times(1)).delete(apprenant);
    }


}
