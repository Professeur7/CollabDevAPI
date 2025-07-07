package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Gestionnaire;

import java.util.List;

public interface GestionnaireService {
    Gestionnaire createGestionnaire(Gestionnaire g);
    List<Gestionnaire> getAllGestionnaires();
    Gestionnaire getGestionnaireById(Long id);
    Gestionnaire updateGestionnaire(Long id, Gestionnaire g);
    void deleteGestionnaire(Long id);
}
