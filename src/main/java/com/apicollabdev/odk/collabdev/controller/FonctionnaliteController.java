package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Fonctionnalite;
import com.apicollabdev.odk.collabdev.service.FonctionnaliteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/fonctionnalites")
@RestController
public class FonctionnaliteController {

    private FonctionnaliteService fonctionnaliteService;

    @PostMapping
    public ResponseEntity<Fonctionnalite> create(@RequestBody Fonctionnalite fonctionnalite) {
        return ResponseEntity.ok(fonctionnaliteService.createFonctionnalite(fonctionnalite));
    }

    @GetMapping
    public List<Fonctionnalite> getAll() {
        return fonctionnaliteService.getAllFonctionnalite();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fonctionnalite> getById(@PathVariable Long id) {
        return ResponseEntity.ok(fonctionnaliteService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fonctionnaliteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
