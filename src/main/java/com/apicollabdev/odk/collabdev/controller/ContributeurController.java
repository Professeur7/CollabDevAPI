package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.dto.ContributeurDTO;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.mapper.ContributeurMapper;
import com.apicollabdev.odk.collabdev.service.ContributeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributeurs")
public class ContributeurController {

    private ContributeurService service;

    @PostMapping("/inscription")
    public Contributeur inscription(@RequestBody ContributeurDTO dto) {
        Contributeur contributeur = ContributeurMapper.toEntity(dto);
        return service.inscription(contributeur);
    }

    @PostMapping("/connexion")
    public Contributeur connexion(@RequestParam String email, @RequestParam String password) {
        return service.connexion(email, password);
    }

    @GetMapping("/deconnexion/{id}")
    public void deconnexion(@PathVariable Long id) {
         service.deconnexion(id);
    }

    @PostMapping("/")
    public Contributeur create(@RequestBody ContributeurDTO dto) {
        return service.createContributeur(ContributeurMapper.toEntity(dto));
    }

    @GetMapping("/{id}")
    public Contributeur getById(@PathVariable Long id) {
        return service.getContributeurById(id);
    }

    @GetMapping
    public List<Contributeur> getAll() {
        return service.getAllContributeurs();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteContributeur(id);
    }
}
