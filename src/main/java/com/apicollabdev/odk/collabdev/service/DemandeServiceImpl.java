package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.dto.DemandeDTO;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.entity.Demande;
import com.apicollabdev.odk.collabdev.entity.Projet;
import com.apicollabdev.odk.collabdev.repository.ContributeurRepository;
import com.apicollabdev.odk.collabdev.repository.DemandeRepository;
import com.apicollabdev.odk.collabdev.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeServiceImpl implements DemandeService {

    private final DemandeRepository demandeRepository;
    private final ContributeurRepository contributeurRepository;
    private final ProjetRepository projetRepository;

    @Autowired
    public DemandeServiceImpl(ContributeurRepository contributeurRepository, DemandeRepository demandeRepository, ProjetRepository projetRepository) {
        this.contributeurRepository = contributeurRepository;
        this.demandeRepository = demandeRepository;
        this.projetRepository = projetRepository;
    }

    @Override
    public Demande createDemande(DemandeDTO demandeDTO, long idContributeur, long idProjet) {
         Contributeur c = contributeurRepository.findById(idContributeur)
                 .orElseThrow(() -> new RuntimeException("Contributeur Introuvable"));
            Projet p = projetRepository.findById(idProjet)
                    .orElseThrow(() -> new RuntimeException("Projet non trouvé"));
            Demande demande = new Demande();
            demande.setStatut(demandeDTO.getStatut());
            demande.setDescription(demandeDTO.getDescription());
            demande.setChoixRole(demandeDTO.getChoixRole());
            demande.setContributeur(c);
            demande.setProjet(p);
         demandeRepository.save(demande);
        return demande;
    }

    @Override
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    public DemandeRepository getDemandeRepository() {
        return demandeRepository;
    }

    public ContributeurRepository getContributeurRepository() {
        return contributeurRepository;
    }

    @Override
    public Demande getById(Long id) {
        return demandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Demande non trouvée"));
    }

    @Override
    public void deleteById(Long id) {
        demandeRepository.deleteById(id);
    }
}
