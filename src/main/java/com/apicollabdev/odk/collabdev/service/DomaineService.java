package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Domaine;

import java.util.List;

public interface DomaineService {
    Domaine createDomaine(Domaine domaine, long idAdmin);
    List<Domaine> getAllDomaine();
    Domaine getById(Long id);
    void deleteById(Long id);
    Domaine updateDomaine(Long idDomaine, Domaine newDomaineData, Administrateur admin);
}
