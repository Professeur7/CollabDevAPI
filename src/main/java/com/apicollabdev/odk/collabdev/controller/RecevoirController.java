package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Recevoir;
import com.apicollabdev.odk.collabdev.service.Interfaces.RecevoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/recevoirs")
@RestController
public class RecevoirController {
    @Autowired
    private RecevoirService recevoirService;

    @PostMapping
    public ResponseEntity<Recevoir> create(@RequestBody Recevoir recevoir) {
        return ResponseEntity.ok(recevoirService.createRecevoir(recevoir));
    }

    @GetMapping
    public List<Recevoir> getAll() {
        return recevoirService.getAllRecevoir();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recevoir> getById(@PathVariable Long id) {
        return ResponseEntity.ok(recevoirService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        recevoirService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
