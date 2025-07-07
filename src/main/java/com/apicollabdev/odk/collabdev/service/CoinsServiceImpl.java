package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Coins;
import com.apicollabdev.odk.collabdev.repository.CoinsRepository;

import java.util.List;

public class CoinsServiceImpl implements CoinsService {
    private CoinsRepository coinsRepository;

    @Override
    public Coins createCoins(Coins coins) {
        return coinsRepository.save(coins);
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

}
