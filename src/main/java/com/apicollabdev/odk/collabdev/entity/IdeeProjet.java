package com.apicollabdev.odk.collabdev.entity;

import com.apicollabdev.odk.collabdev.enums.StatutIdee;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdeeProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIdeeProjet;

    private String description;

    private String titre;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private StatutIdee statut;

    @ManyToOne
    @JoinColumn(name = "idContributeur", nullable = true)
    private Contributeur contributeur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProjet")
    private Projet projet;
}
