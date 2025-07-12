package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.dto.GestionnaireDTO;
import com.apicollabdev.odk.collabdev.entity.Gestionnaire;
import com.apicollabdev.odk.collabdev.service.GestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gestionnaires")
public class GestionnaireController {

    private final GestionnaireService gestionnaireService;

    public GestionnaireController(GestionnaireService gestionnaireService) {
        this.gestionnaireService = gestionnaireService;
    }

    @PostMapping("/valider-contribution")
    public void validerContribution(@RequestBody GestionnaireDTO gestionnaireDTO) {
        gestionnaireService.validerContribution(gestionnaireDTO);
    }

    @PostMapping("/valider-demande")
    public void validerDemande(@RequestBody GestionnaireDTO gestionnaireDTO) {
        gestionnaireService.validerDemande(gestionnaireDTO);
    }

    @GetMapping("/{id}")
    public Gestionnaire getGestionnaireById(@PathVariable Long id) {
        return gestionnaireService.getGestionnaireById(id);
    }

    @PutMapping
    public Gestionnaire updateGestionnaire(@RequestBody Gestionnaire gestionnaire) {
        return gestionnaireService.updateGestionnaire(gestionnaire);
    }
}