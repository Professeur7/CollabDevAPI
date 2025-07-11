package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.dto.DebloqueProjetDTO;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.entity.DebloqueProjet;
import com.apicollabdev.odk.collabdev.repository.ContributeurRepository;
import com.apicollabdev.odk.collabdev.repository.DebloqueProjetRepository;
import java.util.List;

public class DebloqueProjetServiceImpl implements DebloqueProjetService {

    private DebloqueProjetRepository debloqueProjetRepository;
    private ContributeurRepository contributeurRepository ;


    @Override
    public DebloqueProjet createDebloqueProjet(DebloqueProjetDTO debloqueProjet, Long idContributeur) {

        Contributeur contributeur = contributeurRepository.findById(idContributeur)
        .orElseThrow(()-> new RuntimeException("l'objet est introuvable"));

        DebloqueProjet debloqueProjet1 = new DebloqueProjet();

        debloqueProjet1.setVisibilite(debloqueProjet.isVisibilite());
        debloqueProjet1.setNombreCoins(debloqueProjet.getNombreCoins());

        debloqueProjet1.setContributeur(contributeur);

        return debloqueProjetRepository.save(debloqueProjet1);
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

    @Override
    public DebloqueProjet updateDebloqueProjet(int id, DebloqueProjetDTO debloqueProjetDTO) {
       //on recupere l'objet debloqueProjet dans la base a partir de son donnée
        DebloqueProjet debloqueProjet = debloqueProjetRepository.findById(id).
                orElseThrow(()-> new RuntimeException("l'objet est introvable"));
        debloqueProjet.setVisibilite(debloqueProjet.isVisibilite());
        debloqueProjet.setNombreCoins(debloqueProjet.getNombreCoins());

        return debloqueProjetRepository.save(debloqueProjet);
    }
}
