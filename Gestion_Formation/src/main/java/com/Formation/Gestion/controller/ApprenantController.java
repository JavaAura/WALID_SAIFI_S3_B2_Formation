package com.Formation.Gestion.controller;

import com.Formation.Gestion.model.dto.ApprenantDto;
import com.Formation.Gestion.model.entity.Apprenant;
import com.Formation.Gestion.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apprenants")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;


}
