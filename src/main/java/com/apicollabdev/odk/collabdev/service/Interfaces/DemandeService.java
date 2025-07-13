package com.apicollabdev.odk.collabdev.service.Interfaces;

import com.apicollabdev.odk.collabdev.dto.DemandeDTO;
import com.apicollabdev.odk.collabdev.entity.Demande;

import java.util.List;

public interface DemandeService {
    Demande createDemande(DemandeDTO demandeDTO, long idContributeur, long idProjet);
    List<Demande> getAllDemandes();
    Demande getById(Long id);
    void deleteById(Long id);
}

