package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Commentaire;

import java.util.List;

public interface CommentaireService {
    Commentaire createCommentaire(Commentaire commentaire);
    List<Commentaire> getAllCommentaires();
    Commentaire getById(Long id);
    void deleteById(Long id);
}
