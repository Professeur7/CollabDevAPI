package com.apicollabdev.odk.collabdev.entity;

import jakarta.persistence.*;

@Entity
public class Fonctionnalite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFonctionnalite;

    private int pointFonctionnalite;

}
