package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Contributeur;
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
    public ResponseEntity<IdeeProjet> create(@RequestBody IdeeProjet ideeProjet, Contributeur contributeur) {
        return ResponseEntity.ok(ideeProjetService.createIdeeProjet(ideeProjet, new Contributeur()));
    }

    @GetMapping
    public List<IdeeProjet> getAll() {
        return ideeProjetService.getAllIdeeProjet();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IdeeProjet> getById(@PathVariable int id) {
        return ResponseEntity.ok(ideeProjetService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IdeeProjet> update(@PathVariable int id, @RequestBody IdeeProjet updatedIdeeProjet) {
        IdeeProjet updated = ideeProjetService.updateIdeeProjet(id, updatedIdeeProjet);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        ideeProjetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
