package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.DemandeParticipation;
import com.apicollabdev.odk.collabdev.repository.DemandeParticipationRepository;

import java.util.List;

public class DemandeParticipationServiceImpl implements DemandeParticipationService {
    private DemandeParticipationRepository demandeParticipationRepository;

    @Override
    public DemandeParticipation createDemandeParticipation(DemandeParticipation demandeParticipation) {
        return demandeParticipationRepository.save(demandeParticipation);
    }

    @Override
    public List<DemandeParticipation> getAllDemandeParticipation() {
        return demandeParticipationRepository.findAll();
    }

    @Override
    public DemandeParticipation getById(Long id) {
        return demandeParticipationRepository.findById(Math.toIntExact((id)))
                .orElseThrow(() -> new RuntimeException("Coins non trouvé avec l'id : " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!demandeParticipationRepository.existsById(Math.toIntExact((id)))) {
            throw new RuntimeException("Le DemandeParticipation avec l'id " + id + " n'existe pas.");
        }
        demandeParticipationRepository.deleteById(Math.toIntExact((id)));
    }
}
