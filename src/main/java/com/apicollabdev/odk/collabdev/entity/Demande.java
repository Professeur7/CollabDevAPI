package com.apicollabdev.odk.collabdev.entity;
import com.apicollabdev.odk.collabdev.enums.ChoixRole;
import com.apicollabdev.odk.collabdev.enums.StatutDemande;
import jakarta.persistence.*;
import lombok.*;

import javax.net.ssl.SSLSession;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDemande;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatutDemande statut;


    @Enumerated(EnumType.STRING)
    private ChoixRole choixRole;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProjet", nullable = true)
    private Projet projet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idContributeur", nullable = true)
    private Contributeur contributeur;



}

