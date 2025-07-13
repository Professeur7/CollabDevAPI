package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Contribution;
import com.apicollabdev.odk.collabdev.entity.Domaine;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.service.AdministrateurService;
import com.apicollabdev.odk.collabdev.service.ContributionService;
import com.apicollabdev.odk.collabdev.service.DomaineService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RequestMapping("/api/domaines")
@RestController
public class DomaineController {

    private final DomaineService domaineService;
    private final AdministrateurService administrateurService;
    private final AdministrateurRepository administrateurRepository;

    @PostMapping("/administrateur/{idAdmin}")
    public ResponseEntity<Domaine> create(@RequestBody Domaine domaine, @PathVariable("idAdmin") long idAdmin) {
        Administrateur a = administrateurRepository.findById(idAdmin).orElseThrow( ()-> new RuntimeException("Administrateur non trouvé"));
        return ResponseEntity.ok(domaineService.createDomaine(domaine, idAdmin));
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

    @PutMapping("/administrateur/{idAdmin}/{idDomaine}")
    public ResponseEntity<Domaine> updateDomaine(
            @PathVariable("idAdmin") Long idAdmin,
            @PathVariable("idDomaine") Long idDomaine,
            @RequestBody Domaine domaine) {

        Administrateur admin = administrateurRepository.findById(idAdmin)
                .orElseThrow(() -> new RuntimeException("Administrateur non trouvé"));

        Domaine updated = domaineService.updateDomaine(idDomaine, domaine, admin);
        return ResponseEntity.ok(updated);
    }

}
