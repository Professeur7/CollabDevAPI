package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Coins;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.repository.CoinsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Data
@Service
public class CoinsServiceImpl implements CoinsService {
    private final CoinsRepository coinsRepository;
    private final AdministrateurRepository administrateurRepository;


    @Override
    public Coins createCoins(Coins coins, long idAdmin) {
        Administrateur a = administrateurRepository.findById(idAdmin).orElseThrow(()-> new RuntimeException("Administrateur non trouvé"));
        coins.setNombreCoins(coins.getNombreCoins() + 1);
        coins.setAdministrateur(a);
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
