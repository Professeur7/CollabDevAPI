package com.apicollabdev.odk.collabdev.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContribution;

    private String titre;

    private String contenu;

    private String type; // Exemple : "code", "design", "idée", etc.

    private LocalDateTime dateSoumission;

    @ManyToOne
    @JoinColumn(name = "idProjet", nullable = true)
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "idContributeur", nullable = true)
    private Contributeur contributeur;
}

