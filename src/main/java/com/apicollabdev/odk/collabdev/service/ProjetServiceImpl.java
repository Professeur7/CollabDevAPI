package com.apicollabdev.odk.collabdev.service;


import com.apicollabdev.odk.collabdev.entity.Projet;
import com.apicollabdev.odk.collabdev.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjetServiceImpl implements ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    @Override
    public Projet createProjet(Projet projet) {

        return projetRepository.save(projet);
    }

    @Override
    public Projet getProjetById(Long id) {

        return projetRepository.findById(id).orElse(null);
    }

    @Override
    public List<Projet> getAllProjets() {

        return projetRepository.findAll();
    }

    @Override
    public void deleteProjet(Long id) {

        projetRepository.deleteById(id);
    }
}
