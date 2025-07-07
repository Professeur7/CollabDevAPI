package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Contribution;
import com.apicollabdev.odk.collabdev.entity.Domaine;
import com.apicollabdev.odk.collabdev.service.ContributionService;
import com.apicollabdev.odk.collabdev.service.DomaineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/domaines")
@RestController
public class DomaineController {

    private  DomaineService domaineService;

    @PostMapping
    public ResponseEntity<Domaine> create(@RequestBody Domaine domaine) {
        return ResponseEntity.ok(domaineService.createDomaine(domaine));
    }

    @GetMapping
    public List<Domaine> getAll() {
        return domaineService.getAllDomaine();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domaine> getById(@PathVariable Long id) {
        return ResponseEntity.ok(domaineService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        domaineService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
