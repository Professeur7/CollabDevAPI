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
    @Column(name = "id_idee_projet")
    private Long idIdeeProjet;

    private String description;

    private String titre;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private StatutIdee statut;

    @ManyToOne
    @JoinColumn(name = "id_contributeur", nullable = true)
    private Contributeur contributeur;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_projet")
    private Projet projet;
}
