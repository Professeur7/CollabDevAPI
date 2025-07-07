package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.entity.Demande;
import com.apicollabdev.odk.collabdev.repository.ContributeurRepository;
import com.apicollabdev.odk.collabdev.repository.DemandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemandeServiceImpl implements DemandeService {

    private final DemandeRepository demandeRepository;
    private final ContributeurRepository contributeurRepository;

    @Override
    public Demande createDemande(Demande demande) {
        if (demande.getContributeur()!= null && demande.getContributeur()!= null) {
            Contributeur contributeur = contributeurRepository.findById(demande.getProjet().getIdProjet())
                    .orElseThrow(() -> new RuntimeException("Contributeur non trouvé"));
            demande.setContributeur(contributeur);
        } else {
            throw new RuntimeException("ID du contributeur manquant ou invalide");
        }

        return demandeRepository.save(demande);
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
