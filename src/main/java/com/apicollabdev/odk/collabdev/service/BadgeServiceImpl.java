package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Badge;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.repository.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BadgeServiceImpl implements BadgeService {

    private final BadgeRepository badgeRepository;
    private final AdministrateurRepository administrateurRepository;


    @Override
    public Badge createBadge(Badge badge, long idAdmin) {
        Administrateur a = administrateurRepository.findById(idAdmin)
                        .orElseThrow(() -> new RuntimeException("Cet admin n'existe pas"));
        badge.setNom(badge.getNom());
        badge.setDescription(badge.getDescription());
        badge.setAdministrateur(a);
        badge.setNombre(badge.getNombre());
        badge.setImage(badge.getImage());
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
}
