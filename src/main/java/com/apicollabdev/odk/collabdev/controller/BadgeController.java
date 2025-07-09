package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Badge;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.repository.BadgeRepository;
import com.apicollabdev.odk.collabdev.service.BadgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
@RequiredArgsConstructor
public class BadgeController {


    private  final BadgeService badgeService;
    private final BadgeRepository badgeRepository;
    private final AdministrateurRepository administrateurRepository;

    @PostMapping("/administrateur/{idadmin}")
    public ResponseEntity<Badge> create(@RequestBody Badge badge,@PathVariable("idadmin") long idAmin ) {
        Administrateur a = administrateurRepository.findById(idAmin)
                .orElseThrow( ()-> new RuntimeException("Administrateur non trouvé"));
        return ResponseEntity.ok(badgeService.createBadge(badge, idAmin));
    }

    @GetMapping
    public List<Badge> getAll() {
        return badgeService.getAllBadges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Badge> getById(@PathVariable Long id) {
        return ResponseEntity.ok(badgeService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        badgeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
