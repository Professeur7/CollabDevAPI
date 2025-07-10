package com.apicollabdev.odk.collabdev.service;


import com.apicollabdev.odk.collabdev.entity.Contributeur;

import java.util.List;

public interface ContributeurService {
    Contributeur inscription(Contributeur contributeur);
    Contributeur connexion(String email, String password);
    Void deconnexion(Long idContributeur);
    Contributeur createContributeur();
    Contributeur getContributeurById(Long id);
    List<Contributeur> getAllContributeurs();
    void deleteContributeur(Long id);

    boolean existsByNom(String nom);
}

