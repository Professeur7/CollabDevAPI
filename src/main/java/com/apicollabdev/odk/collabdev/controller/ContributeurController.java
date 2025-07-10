package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.dto.ContributeurDTO;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.mapper.ContributeurMapper;
import com.apicollabdev.odk.collabdev.service.ContributeurService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contributeurs")
public class ContributeurController {

    private final ContributeurService contributeurService;



    @PostMapping("/inscription")
    public Contributeur inscription(@RequestBody ContributeurDTO dto) {
        Contributeur contributeur = ContributeurMapper.toEntity(dto);
        return contributeurService.inscription(contributeur);
    }

    @PostMapping("/connexion")
    public Contributeur connexion(@RequestParam String email, @RequestParam String password) {
        return contributeurService.connexion(email, password);
    }

    @GetMapping("/deconnexion/{id}")
    public void deconnexion(@PathVariable Long id) {
        contributeurService.deconnexion(id);
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('id')")
    public Contributeur create(@RequestBody ContributeurDTO dto) {
        return contributeurService.createContributeur();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('id')")
    public Contributeur getById(@PathVariable Long id) {
        return contributeurService.getContributeurById(id);
    }

    @GetMapping
    public List<Contributeur> getAll() {
        return contributeurService.getAllContributeurs();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('id')")
    public void delete(@PathVariable Long id) {
        contributeurService.deleteContributeur(id);
    }
}
