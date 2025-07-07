package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Gestionnaire;
import com.apicollabdev.odk.collabdev.service.GestionnaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/gestionnaires")
@RestController
public class GestionnaireController {

    private GestionnaireService gestionnaireService;

    @PostMapping
    public ResponseEntity<Gestionnaire> createGestionnaire(@RequestBody Gestionnaire gestionnaire) {
        Gestionnaire saved = gestionnaireService.createGestionnaire(gestionnaire);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Gestionnaire>> getAllGestionnaires() {
        return ResponseEntity.ok(gestionnaireService.getAllGestionnaires());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Gestionnaire> getGestionnaireById(@PathVariable Long id) {
        return ResponseEntity.ok(gestionnaireService.getGestionnaireById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Gestionnaire> updateGestionnaire(
            @PathVariable Long id,
            @RequestBody Gestionnaire updatedGestionnaire) {

        Gestionnaire updated = gestionnaireService.updateGestionnaire(id, updatedGestionnaire);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGestionnaire(@PathVariable Long id) {
        gestionnaireService.deleteGestionnaire(id);
        return ResponseEntity.noContent().build();
    }
}
