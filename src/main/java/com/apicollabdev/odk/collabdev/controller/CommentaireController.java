package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Commentaire;
import com.apicollabdev.odk.collabdev.service.CommentaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaires")
@RequiredArgsConstructor
public class CommentaireController {

    private final CommentaireService commentaireService;

    @PostMapping
    public ResponseEntity<Commentaire> create(@RequestBody Commentaire commentaire) {
        return ResponseEntity.ok(commentaireService.createCommentaire(commentaire));
    }

    @GetMapping
    public List<Commentaire> getAll() {
        return commentaireService.getAllCommentaires();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getById(@PathVariable Long id) {
        return ResponseEntity.ok(commentaireService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        commentaireService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
