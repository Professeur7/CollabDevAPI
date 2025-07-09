package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.IdeeProjet;

import java.util.List;

public interface IdeeProjetService {
    IdeeProjet createIdeeProjet(IdeeProjet ideeProjet);
    List<IdeeProjet> getAllIdeeProjet();
    IdeeProjet getById(Long id);
    void deleteById(Long id);
    IdeeProjet updateIdeeProjet(Long id, IdeeProjet updatedIdee);
}
