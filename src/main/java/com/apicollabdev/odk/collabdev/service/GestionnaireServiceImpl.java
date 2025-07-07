package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Gestionnaire;
import com.apicollabdev.odk.collabdev.repository.GestionnaireRepository;

import java.util.List;

public class GestionnaireServiceImpl implements GestionnaireService {

    private GestionnaireRepository repository;

    @Override
    public Gestionnaire createGestionnaire(Gestionnaire g) {
        return repository.save(g);
    }

    @Override
    public List<Gestionnaire> getAllGestionnaires() {
        return repository.findAll();
    }

    @Override
    public Gestionnaire getGestionnaireById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gestionnaire non trouvé"));
    }

    @Override
    public Gestionnaire updateGestionnaire(Long id, Gestionnaire g) {
        Gestionnaire existant = getGestionnaireById(id);
        existant.setValiderContribution(g.isValiderContribution());
        existant.setValiderCommentaire(g.isValiderCommentaire());
        existant.setValiderDemande(g.isValiderDemande());
        existant.setNom(g.getNom());
        existant.setPrenom(g.getPrenom());
        existant.setEmail(g.getEmail());
        existant.setPassword(g.getPassword());
        // Tu peux compléter avec plus de champs si nécessaire
        return repository.save(existant);
    }

    @Override
    public void deleteGestionnaire(Long id) {
        repository.deleteById(id);
    }
}
