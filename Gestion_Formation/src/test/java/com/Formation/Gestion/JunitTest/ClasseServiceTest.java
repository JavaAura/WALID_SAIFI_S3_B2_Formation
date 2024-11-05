package com.Formation.Gestion.JunitTest;

import com.Formation.Gestion.model.entity.Classe;
import com.Formation.Gestion.repository.ClasseRepo;
import com.Formation.Gestion.service.ClasseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClasseServiceTest {

    @InjectMocks
    private ClasseService classeService;

    @Mock
    private ClasseRepo classeRepo;

    private Classe classe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        classe = new Classe();
        classe.setId(1L);
        classe.setNom("Math 101");
    }

    @Test
    void testGetAllClasse() {
        when(classeRepo.findAll()).thenReturn(Arrays.asList(classe));

        List<Classe> classes = classeService.getAllClasse();
        assertEquals(1, classes.size());
    }

    @Test
    void testGetClasseById() {
        when(classeRepo.findById(1L)).thenReturn(Optional.of(classe));

        Classe found = classeService.getClasseById(1L);
        assertEquals(classe, found);
    }

    @Test
    void testAjouterClasse() {
        when(classeRepo.save(any(Classe.class))).thenReturn(classe);

        Classe saved = classeService.ajouterClasse(classe);
        assertEquals(classe, saved);
        verify(classeRepo, times(1)).save(classe);
    }

    @Test
    void testModifierClasse() {
        when(classeRepo.findById(1L)).thenReturn(Optional.of(classe));
        when(classeRepo.save(any(Classe.class))).thenReturn(classe);

        Classe updated = new Classe();
        updated.setId(1L);
        updated.setNom("Advanced Math");

        Classe saved = classeService.modifierClasse(updated);
        assertEquals(updated.getNom(), saved.getNom());
        verify(classeRepo, times(1)).save(any(Classe.class));
    }

    @Test
    void testDeleteClasseById() {
        when(classeRepo.findById(1L)).thenReturn(Optional.of(classe));
        classeService.deleteClasseById(1L);
        verify(classeRepo, times(1)).deleteById(1L);
    }
}
