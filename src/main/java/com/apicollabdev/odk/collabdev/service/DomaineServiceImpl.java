package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Domaine;
import com.apicollabdev.odk.collabdev.repository.DomaineRepository;

import java.util.List;

public class DomaineServiceImpl implements DomaineService {

    private DomaineRepository domaineRepository;

    @Override
    public Domaine createDomaine(Domaine domaine) {
        return domaineRepository.save(domaine);
    }

    @Override
    public List<Domaine> getAllDomaine() {
        return domaineRepository.findAll();
    }

    @Override
    public Domaine getById(Long id) {
        return domaineRepository.findById((id))
                .orElseThrow(() -> new RuntimeException("Domaine non trouvé avec l'id : " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!domaineRepository.existsById((id))) {
            throw new RuntimeException("Le domaine avec l'id " + id + " n'existe pas.");
        }
        domaineRepository.deleteById((id));
    }
}
