package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Domaine;

import java.util.List;

public interface DomaineService {
    Domaine createDomaine(Domaine domaine);
    List<Domaine> getAllDomaine();
    Domaine getById(Long id);
    void deleteById(Long id);
}
