package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Contribution;
import com.apicollabdev.odk.collabdev.service.ContributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributions")
@RequiredArgsConstructor
public class ContributionController {

    private final ContributionService contributionService;

    @PostMapping
    public ResponseEntity<Contribution> create(@RequestBody Contribution contribution) {
        return ResponseEntity.ok(contributionService.createContribution(contribution));
    }

    @GetMapping
    public List<Contribution> getAll() {
        return contributionService.getAllContributions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contribution> getById(@PathVariable Long id) {
        return ResponseEntity.ok(contributionService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contributionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
