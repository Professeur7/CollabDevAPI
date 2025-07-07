package com.apicollabdev.odk.collabdev.service;


import com.apicollabdev.odk.collabdev.entity.Projet;
import java.util.List;

public interface ProjetService {
    Projet createProjet(Projet projet);
    Projet getProjetById(Long id);
    List<Projet> getAllProjets();
    void deleteProjet(Long id);
}
