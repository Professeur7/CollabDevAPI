package com.apicollabdev.odk.collabdev.repository;


import com.apicollabdev.odk.collabdev.entity.Projet;
import com.apicollabdev.odk.collabdev.enums.StatutProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
    List<Projet> findByStatut(StatutProjet statut);
}

