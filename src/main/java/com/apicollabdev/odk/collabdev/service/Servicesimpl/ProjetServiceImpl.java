package com.apicollabdev.odk.collabdev.service.Servicesimpl;


import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.entity.Projet;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.repository.ContributeurRepository;
import com.apicollabdev.odk.collabdev.repository.ProjetRepository;
import com.apicollabdev.odk.collabdev.service.Interfaces.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.apicollabdev.odk.collabdev.enums.StatutProjet.EN_COURS;

@Service
public class ProjetServiceImpl implements ProjetService {

    @Autowired
    private ProjetRepository projetRepository;
    @Autowired
    private ContributeurRepository contributeurRepository;
    @Autowired
    private AdministrateurRepository administrateurRepository;

    @Override
    public Projet createProjet(Projet projet, Long id_contributeur) {
        Contributeur contributeur = contributeurRepository.findById(id_contributeur)
                .orElseThrow(() -> new RuntimeException("Cet admin n'existe pas"));
        projet.setTitre(projet.getTitre());
        projet.setDescription(projet.getDescription());
        projet.setDate(projet.getDate());
        projet.setCahierDeCharge(projet.isCahierDeCharge());
        projet.setStatut(EN_COURS);
        return projetRepository.save(projet);
    }

    @Override

    public Projet getProjetById(Long id,Long id_contributeur) {

        Contributeur contributeur = contributeurRepository.findById(id_contributeur)
                .orElseThrow(() -> new RuntimeException("Cet admin n'existe pas"));

        return projetRepository.findById(id).orElse(null);
    }

    @Override
    public List<Projet> getAllProjets(Long id_contributeur) {
        Contributeur contributeur= contributeurRepository.findById(id_contributeur).
                orElseThrow(()->new RuntimeException("Cet admin n'existe pas"));

        return projetRepository.findAll();
    }

    @Override
    public void deleteProjet(Long id, Long idAdmin) {
        Administrateur administrateur = administrateurRepository.findById(idAdmin)
                .orElseThrow(() -> new RuntimeException("Cet admin n'existe pas"));

        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé"));

        if (projet.getContributions() != null && !projet.getContributions().isEmpty()) {
            throw new RuntimeException("Impossible de supprimer : le projet a déjà des contributions.");
        }

        projetRepository.deleteById(id);
    }

    @Override
    public Projet updateProjet(Long id) {
        return null;
    }

}
