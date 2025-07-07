package com.apicollabdev.odk.collabdev.repository;


import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Badge;
import com.apicollabdev.odk.collabdev.entity.Coins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

    Optional<Coins> findByCoins(Coins coins);
    Optional<Badge> findByBadge(Badge badge);
}

