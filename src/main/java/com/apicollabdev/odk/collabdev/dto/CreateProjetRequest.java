package com.apicollabdev.odk.collabdev.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Data
@Getter
@Setter
public class CreateProjetRequest {

    private Long idIdee;                  // L’idée source du projet
    private Long idContributeur;          // Celui qui initie la transformation
    private Long idGestionnaire;          // Celui qui va suivre le projet
    private Long idDomaine;               // Domaine d'expertise
    private String titre;                 // Facultatif : override le titre de l’idée
    private String description;           // Facultatif : override la description
    private boolean cahierDeCharge;
    private LocalDate dateCreation;       // facultatif, sinon Date.now()
    // Ajouter si besoin : budget, objectifs, impact, localisation, etc.
}
