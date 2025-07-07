package com.apicollabdev.odk.collabdev.controller;


import com.apicollabdev.odk.collabdev.entity.Demande;
import com.apicollabdev.odk.collabdev.service.DemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
@RequiredArgsConstructor
public class DemandeController {

    private final DemandeService demandeService;

    @PostMapping
    public ResponseEntity<Demande> create(@RequestBody Demande demande) {
        return ResponseEntity.ok(demandeService.createDemande(demande));
    }

    @GetMapping
    public List<Demande> getAll() {
        return demandeService.getAllDemandes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demande> getById(@PathVariable Long id) {
        return ResponseEntity.ok(demandeService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        demandeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
