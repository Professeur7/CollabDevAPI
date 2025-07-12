package com.apicollabdev.odk.collabdev.service;


import com.apicollabdev.odk.collabdev.entity.Contributeur;

import com.apicollabdev.odk.collabdev.entity.IdeeProjet;

import java.util.List;

public interface IdeeProjetService {
    IdeeProjet createIdeeProjet(IdeeProjet ideeProjet, Contributeur contributeur);
    List<IdeeProjet> getAllIdeeProjet();

    IdeeProjet getById(Long id);
    IdeeProjet updateIdeeProjet(Long id, IdeeProjet updatedIdeeProjet);
    void deleteById(Long id);

}
