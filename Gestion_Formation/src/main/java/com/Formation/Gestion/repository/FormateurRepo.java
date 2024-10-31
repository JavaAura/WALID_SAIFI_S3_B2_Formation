package com.Formation.Gestion.repository;

import com.Formation.Gestion.model.entity.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurRepo extends JpaRepository<Formateur, Long> {
}
