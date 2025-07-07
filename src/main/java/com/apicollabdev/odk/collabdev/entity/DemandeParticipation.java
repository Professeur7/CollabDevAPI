package com.apicollabdev.odk.collabdev.entity;

import com.apicollabdev.odk.collabdev.enums.StatutDemandeParticipation;
import com.apicollabdev.odk.collabdev.enums.TypeDemandeParticipation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDemandeParticipation;


    @Enumerated(EnumType.STRING)
    private StatutDemandeParticipation statutDemandeParticipation;

    private String description;

    @Enumerated(EnumType.STRING)
    private TypeDemandeParticipation typeDemandeParticipationemande;

    private LocalDateTime datedemande;

    @ManyToOne
    @JoinColumn(name = "idProjet", nullable = true)
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "idContributeur", nullable = true)
    private Contributeur contributeur;


}

