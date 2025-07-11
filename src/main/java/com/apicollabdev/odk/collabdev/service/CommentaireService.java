package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Commentaire;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.entity.Projet;

import java.util.List;

public interface CommentaireService {

    Commentaire createCommentaire(Commentaire commentaire, long contributeur, long projet);
    List<Commentaire> getAllCommentaires(Long idContributeur);
    Commentaire getById(Long idn, Long idContributeur);
    void deleteById(Long id, Long idContributeur);
}
