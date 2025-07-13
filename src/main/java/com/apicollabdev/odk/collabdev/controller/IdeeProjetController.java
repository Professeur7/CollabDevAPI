package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.entity.Domaine;
import com.apicollabdev.odk.collabdev.entity.IdeeProjet;
import com.apicollabdev.odk.collabdev.repository.ContributeurRepository;
import com.apicollabdev.odk.collabdev.repository.DomaineRepository;
import com.apicollabdev.odk.collabdev.service.ContributeurService;
import com.apicollabdev.odk.collabdev.service.DomaineService;
import com.apicollabdev.odk.collabdev.service.IdeeProjetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/ideeProjets")
public class IdeeProjetController {
    @Autowired
    private IdeeProjetService ideeProjetService;

    @Autowired
    private ContributeurService contributeurService;
     @Autowired
     private ContributeurRepository contributeurRepository;
     @Autowired
     private DomaineRepository domaineRepository;

     @Autowired
     private DomaineService domaineService;


     private Domaine domaine;
     //  Constructeur pour injecter le service
    @Autowired
    public IdeeProjetController(IdeeProjetService ideeProjetService) {
        this.ideeProjetService = ideeProjetService;
    }

    // Créer une idée de projet
    @Transactional
    @PostMapping("/contributeur/{idContributeur}/domaine/{idDomaine}")
    public ResponseEntity<IdeeProjet> create(@RequestBody IdeeProjet ideeProjet,@PathVariable("idContributeur") long idContributeur, @PathVariable("idDomaine") long idDomaine) {
        Contributeur c = contributeurRepository.findById(idContributeur)
                .orElseThrow( ()-> new RuntimeException("Contributeur non trouvé"));
        Domaine d = domaineRepository.findById(idDomaine)
                .orElseThrow( ()-> new RuntimeException("Domaine non trouvé"));
        return ResponseEntity.ok(ideeProjetService.createIdeeProjet(ideeProjet, idContributeur, idDomaine));
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
