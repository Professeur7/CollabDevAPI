package com.apicollabdev.odk.collabdev.service;


import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.repository.ContributeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributeurServiceImpl implements ContributeurService {

    private ContributeurRepository repository;

    @Override
    public Contributeur inscription(Contributeur contributeur) {
        // Tu peux ajouter des validations ici
        return repository.save(contributeur);
    }

    @Override
    public Contributeur connexion(String email, String password) {
        return repository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuntimeException("Identifiants invalides"));
    }

    @Override
    public Void deconnexion(Long idContributeur) {
        // logique à adapter selon gestion des sessions
        return null;
    }


    @Override
    public Contributeur createContributeur(Contributeur c) {
        return repository.save(c);
    }

    @Override
    public Contributeur getContributeurById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Contributeur> getAllContributeurs() {
        return repository.findAll();
    }

    @Override
    public void deleteContributeur(Long id) {
        repository.deleteById(id);
    }
}

