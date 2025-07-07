package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Domaine;
import com.apicollabdev.odk.collabdev.entity.Fonctionnalite;
import com.apicollabdev.odk.collabdev.repository.DomaineRepository;
import com.apicollabdev.odk.collabdev.repository.FonctionnaliteRepository;

import java.util.List;

public class FonctionnaliteServiceImpl implements FonctionnaliteService {

    private FonctionnaliteRepository fonctionnaliteRepository;

    @Override
    public Fonctionnalite createFonctionnalite(Fonctionnalite fonctionnalite) {
        return fonctionnaliteRepository.save(fonctionnalite);
    }

    @Override
    public List<Fonctionnalite> getAllFonctionnalite() {
        return fonctionnaliteRepository.findAll();
    }

    @Override
    public Fonctionnalite getById(Long id) {
        return fonctionnaliteRepository.findById(Math.toIntExact((id)))
                .orElseThrow(() -> new RuntimeException("Fonctionnalite non trouvé avec l'id : " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!fonctionnaliteRepository.existsById(Math.toIntExact(id))) {
            throw new RuntimeException("Le Fonctionnalite avec l'id " + id + " n'existe pas.");
        }
        fonctionnaliteRepository.deleteById(Math.toIntExact((id)));
    }

}
