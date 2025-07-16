package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.dto.BadgeDTO;
import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Badge;
import com.apicollabdev.odk.collabdev.entity.Coins;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.repository.BadgeRepository;
import com.apicollabdev.odk.collabdev.repository.ContributeurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BadgeServiceImpl implements BadgeService {

    @Autowired
    private  BadgeRepository badgeRepository;
    private final AdministrateurRepository administrateurRepository;

    @Autowired
    private ContributeurRepository contributeurRepository;


    @Override
    public Badge createBadge(BadgeDTO dto, long idAdmin) {
        Administrateur a = administrateurRepository.findById(idAdmin)
                        .orElseThrow(() -> new RuntimeException("Cet admin n'existe pas"));

        Badge badge = new Badge();
        badge.setNom(dto.getNom());
        badge.setDescription(dto.getDescription());
        badge.setAdministrateur(a);
        badge.setNombre(dto.getNombre());
        badge.setImage(dto.getImage());
        return badgeRepository.save(badge);
    }

    @Override
    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    @Override
    public Badge getById(Long id) {

        return badgeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Badge non trouvé avec l'id : " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!badgeRepository.existsById(id)) {
            throw new RuntimeException("Le badge avec l'id " + id + " n'existe pas.");
        }
        badgeRepository.deleteById(id);
    }

    public void checkAndAssignBadgeIfEligible(Contributeur contributeur) {
        // Recharger depuis la base avec ses relations à jour
        Contributeur fullContrib = contributeurRepository.findById(contributeur.getId())
                .orElseThrow(() -> new RuntimeException("Contributeur non trouvé"));

        int totalCoins = fullContrib.getCoins().stream()
                .mapToInt(Coins::getNombreCoins)
                .sum();

        List<String> badgesOrdres = List.of(
                "Badge de NIVEAU DEBUTANT1",
                "Badge de NIVEAU DEBUTANT2",
                "Badge de NIVEAU DEBUTANT3",
                "Badge de NIVEAU INTERMEDIAIRE1",
                "Badge de NIVEAU INTERMEDIAIRE2",
                "Badge de NIVEAU INTERMEDIAIRE3",
                "Badge de NIVEAU AVANCE1",
                "Badge de NIVEAU AVANCE2",
                "Badge de NIVEAU AVANCE3",
                "Badge de NIVEAU EXPERT"
        );

        int badgeIndex = totalCoins / 100;

        if (badgeIndex > 0 && badgeIndex <= badgesOrdres.size()) {
            String nomBadge = badgesOrdres.get(badgeIndex - 1); // -1 car index commence à 0

            // Supprimer tous les anciens badges du contributeur
            List<Badge> anciensBadges = fullContrib.getBadges();
            anciensBadges.forEach(b -> badgeRepository.deleteById(b.getIdBadge()));
            anciensBadges.clear();

            // Ajouter le nouveau badge
            Badge nouveauBadge = badgeRepository.findByNom(nomBadge)
                    .orElseThrow(() -> new RuntimeException("Badge non trouvé : " + nomBadge));
            nouveauBadge.setContributeur(fullContrib);
            badgeRepository.save(nouveauBadge);
        }
    }

}
