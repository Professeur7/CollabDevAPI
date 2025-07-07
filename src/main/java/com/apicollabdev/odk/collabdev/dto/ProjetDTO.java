package com.apicollabdev.odk.collabdev.dto;

import lombok.Data;

@Data
public class ProjetDTO {
    private String titre;
    private String description;
    private String statut;
    private String cahierDeCharge;
    private Long domaineId;
    private Long gestionnaireId;
    private Long ideeProjetId;
}

