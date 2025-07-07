package com.apicollabdev.odk.collabdev.repository;


import com.apicollabdev.odk.collabdev.entity.Coins;
import com.apicollabdev.odk.collabdev.entity.Contributeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.stereotype.Repository;
@Repository
public interface CoinsRepository extends JpaRepository<Coins, Long> {
    List<Coins> findByContributeur(Contributeur contributeur);
}


