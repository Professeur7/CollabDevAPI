package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Contribution;
import com.apicollabdev.odk.collabdev.entity.Recevoir;
import com.apicollabdev.odk.collabdev.repository.ContributionRepository;
import com.apicollabdev.odk.collabdev.repository.RecevoirRepository;

import java.util.List;

public class RecevoirServiceImpl implements RecevoirService{

    private RecevoirRepository recevoirRepository;

    @Override
    public Recevoir createRecevoir(Recevoir recevoir) {
        return recevoirRepository.save(recevoir);
    }

    @Override
    public List<Recevoir> getAllRecevoir() {
        return recevoirRepository.findAll();
    }

    @Override
    public Recevoir getById(Long id) {
        return recevoirRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Recevoir non trouvée"));
    }

    @Override
    public void deleteById(Long id) {
        recevoirRepository.deleteById(Math.toIntExact(id));
    }
}
