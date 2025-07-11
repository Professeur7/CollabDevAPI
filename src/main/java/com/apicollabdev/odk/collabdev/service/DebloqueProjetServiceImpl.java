package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.DebloqueProjet;
import com.apicollabdev.odk.collabdev.repository.DebloqueProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DebloqueProjetServiceImpl implements DebloqueProjetService {
    @Autowired
    private DebloqueProjetRepository debloqueProjetRepository;

    @Override
    public DebloqueProjet createDebloqueProjet(DebloqueProjet debloqueProjet) {
        return debloqueProjetRepository.save(debloqueProjet);
    }

    @Override
    public List<DebloqueProjet> getAllDebloqueProjet() {
        return debloqueProjetRepository.findAll();
    }

    @Override
    public DebloqueProjet getById(Long id) {
        return debloqueProjetRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("DebloqueProjet non trouvé avec l'id : " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!debloqueProjetRepository.existsById(Math.toIntExact(id))) {
            throw new RuntimeException("Le debloqueProjet avec l'id " + id + " n'existe pas.");
        }
        debloqueProjetRepository.deleteById(Math.toIntExact(id));
    }

}
