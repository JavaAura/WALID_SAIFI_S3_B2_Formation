package com.Formation.Gestion;

import com.Formation.Gestion.model.entity.Formation;
import com.Formation.Gestion.repository.FormationRepo;
import com.Formation.Gestion.service.FormationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FormationServiceTest {

    @InjectMocks
    private FormationService formationService;

    @Mock
    private FormationRepo formationRepo;

    private Formation formation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        formation = new Formation();
        formation.setId(1L);
        formation.setTitre("Java Programming");
    }

    @Test
    void testGetAll() {
        when(formationRepo.findAll()).thenReturn(Arrays.asList(formation));

        assertEquals(1, formationService.getAll().size());
    }

    @Test
    void testGetById() {
        when(formationRepo.findById(1L)).thenReturn(Optional.of(formation));

        Formation found = formationService.getById(1L);
        assertEquals(formation, found);
    }

    @Test
    void testGetByIdNotFound() {
        when(formationRepo.findById(1L)).thenReturn(Optional.empty());

        Formation found = formationService.getById(1L);
        assertNull(found);
    }

    @Test
    void testCreateFormation() {
        when(formationRepo.save(any(Formation.class))).thenReturn(formation);

        Formation saved = formationService.createFormation(formation);
        assertEquals(formation, saved);
        verify(formationRepo, times(1)).save(formation);
    }

    @Test
    void testModifierFormation() {
        when(formationRepo.existsById(1L)).thenReturn(true);
        when(formationRepo.save(any(Formation.class))).thenReturn(formation);

        formation.setTitre("Java Programming");

        Formation updated = formationService.ModifierFormation(1L, formation);
        assertEquals("Java Programming", updated.getTitre());
        verify(formationRepo, times(1)).save(any(Formation.class));
    }

    @Test
    void testModifierFormationNotFound() {
        when(formationRepo.existsById(1L)).thenReturn(false);

        Formation updated = formationService.ModifierFormation(1L, formation);
        assertNull(updated);
    }

    @Test
    void testDeleteFormation() {
        doNothing().when(formationRepo).deleteById(1L);

        formationService.deleteFormation(1L);
        verify(formationRepo, times(1)).deleteById(1L);
    }
}
