package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.IdeeProjet;
import com.apicollabdev.odk.collabdev.repository.IdeeProjetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeeProjetServiceImpl implements IdeeProjetService {

    private IdeeProjetRepository ideeProjetRepository;

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
        return ideeProjetRepository.findById((id))
                .orElseThrow(() -> new RuntimeException("Fonctionnalite non trouvé avec l'id : " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!ideeProjetRepository.existsById(id)) {
            throw new RuntimeException("Le Fonctionnalite avec l'id " + id + " n'existe pas.");
        }
        ideeProjetRepository.deleteById((id));
    }
}
