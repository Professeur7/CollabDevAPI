package com.apicollabdev.odk.collabdev.entity;

import jakarta.persistence.*;

@Entity
public class DebloqueProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_debloqueProjet;

    private boolean visibilite;

    private int nombreCoins;

    @ManyToOne
    @JoinColumn(name = "idProjet", nullable = false)
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "idContributeur", nullable = false)
    private Contributeur contributeur;


}
