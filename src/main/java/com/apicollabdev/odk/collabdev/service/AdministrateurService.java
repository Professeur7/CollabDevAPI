package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Badge;

import java.util.List;

public interface AdministrateurService {
    Administrateur administrateur(Administrateur administrateur);
    List<Administrateur> getAllAdministrateurs();
    Administrateur getById(Long idAdmin);
    void deleteById(Long idAdmin);
}
