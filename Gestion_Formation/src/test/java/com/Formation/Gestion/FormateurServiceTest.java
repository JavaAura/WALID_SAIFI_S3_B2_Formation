package com.Formation.Gestion;

import com.Formation.Gestion.model.entity.Classe;
import com.Formation.Gestion.model.entity.Formateur;
import com.Formation.Gestion.model.entity.Formation;
import com.Formation.Gestion.repository.ClasseRepo;
import com.Formation.Gestion.repository.FormateurRepo;
import com.Formation.Gestion.repository.FormationRepo;
import com.Formation.Gestion.service.FormateurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FormateurServiceTest {

    @InjectMocks
    private FormateurService formateurService;

    @Mock
    private FormateurRepo formateurRepo;

    @Mock
    private FormationRepo formationRepo;

    @Mock
    private ClasseRepo classeRepo;

    private Formateur formateur;
    private Formation formation;
    private Classe classe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        formateur = new Formateur();
        formateur.setId(1L);
        formateur.setNom("Doe");
        formateur.setPrenom("John");
        formateur.setEmail("john.doe@example.com");
        formateur.setSpecialite("Java");

        formation = new Formation();
        formation.setId(1L);

        classe = new Classe();
        classe.setId(1L);
        classe.setNom("Java Class 101");
    }

    @Test
    void testGetAll() {
        when(formateurRepo.findAll()).thenReturn(Arrays.asList(formateur));

        assertEquals(1, formateurService.getAll().size());
    }

    @Test
    void testGetById() {
        when(formateurRepo.getById(1L)).thenReturn(formateur);

        Formateur found = formateurService.getById(1L);
        assertEquals(formateur, found);
    }

    @Test
    void testAjouterFormateur() {
        when(formateurRepo.save(any(Formateur.class))).thenReturn(formateur);

        Formateur saved = formateurService.ajouterFormateur(formateur);
        assertEquals(formateur, saved);
        verify(formateurRepo, times(1)).save(formateur);
    }

    @Test
    void testModiferFormateur() {
        when(formateurRepo.getById(1L)).thenReturn(formateur);
        when(formateurRepo.save(any(Formateur.class))).thenReturn(formateur);

        formateur.setNom("Smith");
        formateur.setPrenom("Jane");

        Formateur updated = formateurService.ModiferFormateur(formateur, 1L);
        assertEquals("Smith", updated.getNom());
        assertEquals("Jane", updated.getPrenom());
        verify(formateurRepo, times(1)).save(any(Formateur.class));
    }

    @Test
    void testSupprimerFormateur() {
        when(formateurRepo.findById(1L)).thenReturn(Optional.of(formateur));
        formateurService.supprimerFormateur(1L);
        verify(formateurRepo, times(1)).deleteById(1L);
    }

    @Test
    void testAffecterFormation() {
        when(formateurRepo.findById(1L)).thenReturn(Optional.of(formateur));
        when(formationRepo.findById(1L)).thenReturn(Optional.of(formation));
        when(formateurRepo.save(any(Formateur.class))).thenReturn(formateur);

        Formateur updatedFormateur = formateurService.affecterFormation(1L, 1L);
        assertEquals(formation, updatedFormateur.getFormation());
        verify(formateurRepo, times(1)).save(formateur);
    }

    @Test
    void testAffecterClasse() {
        when(formateurRepo.findById(1L)).thenReturn(Optional.of(formateur));
        when(classeRepo.findById(1L)).thenReturn(Optional.of(classe));
        when(formateurRepo.save(any(Formateur.class))).thenReturn(formateur);

        Formateur updatedFormateur = formateurService.affecterClasse(1L, 1L);
        assertEquals(classe, updatedFormateur.getClasse());
        verify(formateurRepo, times(1)).save(formateur);
    }

    @Test
    void testAffecterFormationNotFound() {
        when(formateurRepo.findById(1L)).thenReturn(Optional.empty());
        when(formationRepo.findById(1L)).thenReturn(Optional.of(formation));

        Formateur result = formateurService.affecterFormation(1L, 1L);
        assertNull(result);
    }

    @Test
    void testAffecterClasseNotFound() {
        when(formateurRepo.findById(1L)).thenReturn(Optional.empty());
        when(classeRepo.findById(1L)).thenReturn(Optional.of(classe));

        Formateur result = formateurService.affecterClasse(1L, 1L);
        assertNull(result);
    }
}

