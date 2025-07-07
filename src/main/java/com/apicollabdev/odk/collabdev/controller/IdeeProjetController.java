package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Fonctionnalite;
import com.apicollabdev.odk.collabdev.entity.IdeeProjet;
import com.apicollabdev.odk.collabdev.service.FonctionnaliteService;
import com.apicollabdev.odk.collabdev.service.IdeeProjetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/ideeProjets")
@RestController
public class IdeeProjetController {
    private IdeeProjetService ideeProjetService;

    @PostMapping
    public ResponseEntity<IdeeProjet> create(@RequestBody IdeeProjet ideeProjet) {
        return ResponseEntity.ok(ideeProjetService.createIdeeProjet(ideeProjet));
    }

    @GetMapping
    public List<IdeeProjet> getAll() {
        return ideeProjetService.getAllIdeeProjet();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IdeeProjet> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ideeProjetService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ideeProjetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
