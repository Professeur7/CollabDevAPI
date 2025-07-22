package com.apicollabdev.odk.collabdev.repository;


import com.apicollabdev.odk.collabdev.entity.Projet;
import com.apicollabdev.odk.collabdev.enums.StatutProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Integer> {
    Optional<Projet> findById(int idProjet);

    List<Projet> findByStatut(StatutProjet statut);
}

