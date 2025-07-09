package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.IdeeProjet;
import com.apicollabdev.odk.collabdev.repository.IdeeProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeeProjetServiceImpl implements IdeeProjetService {

    private final IdeeProjetRepository ideeProjetRepository;

    @Autowired
    public IdeeProjetServiceImpl(IdeeProjetRepository ideeProjetRepository) {
        this.ideeProjetRepository = ideeProjetRepository;
    }

    @Override
    public IdeeProjet createIdeeProjet(IdeeProjet ideeProjet) {
        return ideeProjetRepository.save(ideeProjet);
    }

    @Override
    public List<IdeeProjet> getAllIdeeProjet() {
        return ideeProjetRepository.findAll();
    }

    @Override
    public IdeeProjet getById(Long id) {
        return ideeProjetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Idée projet non trouvée avec l'id : " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!ideeProjetRepository.existsById(id)) {
            throw new RuntimeException("L'idée projet avec l'id " + id + " n'existe pas.");
        }
        ideeProjetRepository.deleteById(id);
    }

    // 🔄 Méthode update (optionnelle)
    @Override
    public IdeeProjet updateIdeeProjet(Long id, IdeeProjet updatedIdee) {
        IdeeProjet existing = ideeProjetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Impossible de modifier, idée projet introuvable avec l'id : " + id));

        existing.setTitre(updatedIdee.getTitre());
        existing.setDescription(updatedIdee.getDescription());
        existing.setDate(updatedIdee.getDate());
        existing.setStatut(updatedIdee.getStatut());
        existing.setContributeur(updatedIdee.getContributeur());

        return ideeProjetRepository.save(existing);
    }
}
