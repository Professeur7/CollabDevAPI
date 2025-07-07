package com.apicollabdev.odk.collabdev.controller;


import com.apicollabdev.odk.collabdev.entity.Projet;
import com.apicollabdev.odk.collabdev.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projets")
@CrossOrigin("*")
public class ProjetController {


    private final ProjetService projetService;

    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @PostMapping
    public Projet create(@RequestBody Projet p) {
        return projetService.createProjet(p);
    }

    @GetMapping("/{id}")
    public Projet getById(@PathVariable Long id) {
        return projetService.getProjetById(id);
    }

    @GetMapping
    public List<Projet> getAll() {
        return projetService.getAllProjets();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projetService.deleteProjet(id);
    }
}
