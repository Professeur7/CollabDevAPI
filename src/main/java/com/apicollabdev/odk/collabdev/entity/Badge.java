package com.apicollabdev.odk.collabdev.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBadge;

    private String nom;
    private String description;
    private String image; // image en URL ou nom de fichier
    private int nombre;


    @ManyToOne
    @JoinColumn(name = "idContributeur", nullable = true)
    private Contributeur contributeur;

    @ManyToOne
    @JoinColumn(name = "idAdministrateur", nullable = true)
    private Administrateur administrateur;
}

