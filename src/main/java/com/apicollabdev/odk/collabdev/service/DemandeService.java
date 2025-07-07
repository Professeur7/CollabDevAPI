package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Demande;

import java.util.List;

public interface DemandeService {
    Demande createDemande(Demande demande);
    List<Demande> getAllDemandes();
    Demande getById(Long id);
    void deleteById(Long id);
}

