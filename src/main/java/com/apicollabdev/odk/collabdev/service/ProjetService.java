package com.apicollabdev.odk.collabdev.service;


import com.apicollabdev.odk.collabdev.entity.Projet;
import java.util.List;

public interface ProjetService {
    public Projet createProjet(Projet projet);
    public Projet getProjetById(int idProjet);
    public List<Projet> getAllProjets();
    public void deleteProjet(int idProjet);
}
