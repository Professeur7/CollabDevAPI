package com.apicollabdev.odk.collabdev.controller;
import com.apicollabdev.odk.collabdev.entity.DebloqueProjet;
import com.apicollabdev.odk.collabdev.service.DebloqueProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/debloqueProjet")
@RequiredArgsConstructor
public class DebloqueProjetController {

    private DebloqueProjetService debloqueProjetService;

    @PostMapping
    public ResponseEntity<DebloqueProjet> create(@RequestBody DebloqueProjet debloqueProjet) {
        return ResponseEntity.ok(debloqueProjetService.createDebloqueProjet(debloqueProjet));
    }

    @GetMapping
    public List<DebloqueProjet> getAll() {
        return debloqueProjetService.getAllDebloqueProjet();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DebloqueProjet> getById(@PathVariable Long id) {
        return ResponseEntity.ok(debloqueProjetService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        debloqueProjetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
