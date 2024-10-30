package com.Formation.Gestion.service;

import com.Formation.Gestion.model.entity.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantService extends JpaRepository<Apprenant, Integer> {
}
