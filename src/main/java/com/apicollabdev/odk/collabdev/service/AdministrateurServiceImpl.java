package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Badge;
import com.apicollabdev.odk.collabdev.entity.Coins;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;

public class AdministrateurServiceImpl implements AdministrateurService {


    AdministrateurRepository administrateurRepository;

    //creation de coin
    public Administrateur creerCoin(Coins coin){

        Administrateur administrateur = new Administrateur();

        administrateur.setCoins(coin.getAdministrateur().getCoins());

        return administrateurRepository.save(administrateur);

    }




    //creation de badge
    public Administrateur creerBadge(Badge badge){

        Administrateur administrateur = new Administrateur();

        administrateur.setBadge(badge.getAdministrateur().getBadge());

        return administrateurRepository.save(administrateur);
    }
}
