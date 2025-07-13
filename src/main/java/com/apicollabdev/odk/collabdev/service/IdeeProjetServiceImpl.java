package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.entity.Domaine;
import com.apicollabdev.odk.collabdev.entity.IdeeProjet;
import com.apicollabdev.odk.collabdev.repository.ContributeurRepository;
import com.apicollabdev.odk.collabdev.repository.DomaineRepository;
import com.apicollabdev.odk.collabdev.repository.IdeeProjetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class IdeeProjetServiceImpl implements IdeeProjetService {
    @Autowired
    private  IdeeProjetRepository ideeProjetRepository;
   @Autowired
    private ContributeurRepository contributeurRepository;

   @Autowired
   private DomaineRepository domaineRepository;

    @Autowired
    public IdeeProjetServiceImpl(IdeeProjetRepository ideeProjetRepository) {
        this.ideeProjetRepository = ideeProjetRepository;
    }



    @Override
    public IdeeProjet createIdeeProjet(IdeeProjet ideeProjet, long idContributeur, long idDomaine ) {

        Contributeur c = contributeurRepository.findById(idContributeur)
                .orElseThrow(() -> new RuntimeException("Ce contributeur n'existe pas"));
       Domaine d = domaineRepository.findById(idDomaine)
                .orElseThrow(() -> new RuntimeException("Cette domaine n'existe pas"));

        ideeProjet.setDomaine(ideeProjet.getDomaine());
        ideeProjet.setContributeur(c);
        ideeProjet.setDescription(ideeProjet.getDescription());
        ideeProjet.setDateCreation(ideeProjet.getDateCreation());
        ideeProjet.setDomaine(ideeProjet.getDomaine());
        ideeProjet.setNiveau(ideeProjet.getNiveau());
        ideeProjet.setTitre(ideeProjet.getTitre());
        ideeProjet.setStatut(ideeProjet.getStatut());
        return ideeProjetRepository.save(ideeProjet);
    }

    @Override
    public List<IdeeProjet> getAllIdeeProjet() {
        return ideeProjetRepository.findAll();
    }

    @Override

    public IdeeProjet getById(Long id) {
        return ideeProjetRepository.findById((id))
                .orElseThrow(() -> new RuntimeException("IdeeProjet non trouvé avec l'id : " + id));

    }

    @Override
    public IdeeProjet updateIdeeProjet(Long id, IdeeProjet updatedIdeeProjet) {
        IdeeProjet existingIdeeProjet = ideeProjetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IdeeProjet non trouvée avec l'id : " + id));

        // Mise à jour des champs (ajuste les champs selon ton entité)
        existingIdeeProjet.setTitre(updatedIdeeProjet.getTitre());
        existingIdeeProjet.setDescription(updatedIdeeProjet.getDescription());
        existingIdeeProjet.setDomaine(updatedIdeeProjet.getDomaine());
        existingIdeeProjet.setNiveau(updatedIdeeProjet.getNiveau());
        existingIdeeProjet.setDateCreation(updatedIdeeProjet.getDateCreation());

        return ideeProjetRepository.save(existingIdeeProjet);
    }

    @Override
    public void deleteById(Long id) {
        if (!ideeProjetRepository.existsById(id)) {

            throw new RuntimeException("Le IdeeProjet avec l'id " + id + " n'existe pas.");
        }
        ideeProjetRepository.deleteById(id);
    }
}
