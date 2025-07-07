package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Fonctionnalite;

import java.util.List;

public interface FonctionnaliteService {
    Fonctionnalite createFonctionnalite(Fonctionnalite fonctionnalite);
    List<Fonctionnalite> getAllFonctionnalite();
    Fonctionnalite getById(Long id);
    void deleteById(Long id);
}
