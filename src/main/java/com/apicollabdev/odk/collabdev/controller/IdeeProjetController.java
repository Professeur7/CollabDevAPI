package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.entity.IdeeProjet;
import com.apicollabdev.odk.collabdev.service.Interfaces.IdeeProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ideeProjets")
public class IdeeProjetController {

    private final IdeeProjetService ideeProjetService;

    //  Constructeur pour injecter le service
    @Autowired
    public IdeeProjetController(IdeeProjetService ideeProjetService) {
        this.ideeProjetService = ideeProjetService;
    }

    // Créer une idée de projet
    @PostMapping
    public ResponseEntity<IdeeProjet> create(@RequestBody IdeeProjet ideeProjet, Contributeur contributeur) {
        return ResponseEntity.ok(ideeProjetService.createIdeeProjet(ideeProjet, new Contributeur()));
    }

    // Obtenir toutes les idées
    @GetMapping
    public ResponseEntity<List<IdeeProjet>> getAll() {
        List<IdeeProjet> list = ideeProjetService.getAllIdeeProjet();
        return ResponseEntity.ok(list);
    }

    //  Obtenir une idée par ID
    @GetMapping("/{id}")
    public ResponseEntity<IdeeProjet> getById(@PathVariable Long id) {
        IdeeProjet idee = ideeProjetService.getById(id);
        return ResponseEntity.ok(idee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ideeProjetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    // Mettre à jour une idée
    @PutMapping("/{id}")
    public ResponseEntity<IdeeProjet> update(@PathVariable Long id, @RequestBody IdeeProjet updated) {
        IdeeProjet ideeUpdated = ideeProjetService.updateIdeeProjet(id, updated);
        return ResponseEntity.ok(ideeUpdated);
    }

}
