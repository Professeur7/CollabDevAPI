package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Badge;
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

    @PostMapping
    public ResponseEntity<Badge> create(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.createBadge(badge));
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
