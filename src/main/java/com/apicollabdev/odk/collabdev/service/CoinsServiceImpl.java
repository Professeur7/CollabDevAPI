package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Badge;
import com.apicollabdev.odk.collabdev.entity.Coins;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.repository.BadgeRepository;
import com.apicollabdev.odk.collabdev.repository.CoinsRepository;
import com.apicollabdev.odk.collabdev.repository.ContributeurRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Data
@Service
public class CoinsServiceImpl implements CoinsService {
    private final CoinsRepository coinsRepository;
    private final AdministrateurRepository administrateurRepository;
    @Autowired
    private BadgeRepository badgeRepository;
    @Autowired
    private ContributeurRepository contributeurRepository;
    @Autowired
    private BadgeServiceImpl badgeServiceImpl;


    @Override
    public Coins createCoins(Coins coins, long idAdmin) {
        Administrateur a = administrateurRepository.findById(idAdmin)
                .orElseThrow(() -> new RuntimeException("Administrateur non trouvé"));

        // Ajout automatique de 1 coin supplémentaire
        coins.setNombreCoins(coins.getNombreCoins() + 1);
        coins.setAdministrateur(a);

        // Sauvegarde des coins
        Coins saved = coinsRepository.save(coins);

        // Attribution automatique de badge
        Contributeur contributeur = saved.getContributeur();
        badgeServiceImpl.checkAndAssignBadgeIfEligible(contributeur);

        return saved;
    }

    @Override
    public List<Coins> getAllCoins() {
        return coinsRepository.findAll();
    }

    @Override
    public Coins getById(Long id) {
        return coinsRepository.findById((id))
                .orElseThrow(() -> new RuntimeException("Coins non trouvé avec l'id : " + id));
    }

    @Override
    public void deleteById(Long id) {
        if (!coinsRepository.existsById((id))) {
            throw new RuntimeException("Le debloqueProjet avec l'id " + id + " n'existe pas.");
        }
        coinsRepository.deleteById((id));
    }


    @Autowired
    private BadgeService badgeService;

    public Coins createCoinsForContributeur(Coins coins, long idAdmin, long idContrib) {
        Administrateur admin = administrateurRepository.findById(idAdmin)
                .orElseThrow(() -> new RuntimeException("Administrateur non trouvé"));
        Contributeur contrib = contributeurRepository.findById(idContrib)
                .orElseThrow(() -> new RuntimeException("Contributeur non trouvé"));

        // On cherche les coins déjà existants pour ce contributeur
        List<Coins> existingCoins = coinsRepository.findByContributeur(contrib);

        Coins coin;
        if (existingCoins.isEmpty()) {
            // Aucun coins existant : on crée un nouveau
            coin = new Coins();
            coin.setNombreCoins(coins.getNombreCoins()); // initialisé avec la valeur reçue
            coin.setAdministrateur(admin);
            coin.setContributeur(contrib);
        } else {
            // Coins déjà existants → on met à jour le premier
            coin = existingCoins.get(0);
            coin.setNombreCoins(coin.getNombreCoins() + coins.getNombreCoins());
        }

        Coins savedCoin = coinsRepository.save(coin);

        // mise à jour dans l'objet Contributeur aussi (si nécessaire)
        if (!contrib.getCoins().contains(savedCoin)) {
            contrib.getCoins().add(savedCoin);
        }

        // Vérification et attribution de badge si besoin
        badgeServiceImpl.checkAndAssignBadgeIfEligible(contrib);

        return savedCoin;
    }





}
