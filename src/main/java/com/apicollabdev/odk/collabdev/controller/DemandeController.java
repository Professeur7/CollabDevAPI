package com.apicollabdev.odk.collabdev.controller;


import com.apicollabdev.odk.collabdev.dto.DemandeDTO;
import com.apicollabdev.odk.collabdev.entity.Demande;
import com.apicollabdev.odk.collabdev.service.DemandeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/demandes")
public class DemandeController {
    @Autowired
    private final DemandeService demandeService;

    @PostMapping("/{idcontributeur}/projets/{idprojet}")
    public ResponseEntity<Demande> create(@RequestBody DemandeDTO demandeDTO, @PathVariable("idcontributeur") long idContributeur, @PathVariable("idprojet") long idProjet) {
        return ResponseEntity.ok(demandeService.createDemande(demandeDTO, idContributeur, idProjet));
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
