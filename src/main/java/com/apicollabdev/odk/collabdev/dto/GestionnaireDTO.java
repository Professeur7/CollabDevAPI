package com.apicollabdev.odk.collabdev.dto;

import lombok.Data;

@Data
public class GestionnaireDTO {
    private Long id;
    private boolean validerContribution;
    private boolean validerDemande;
    private int coinsAAttribuer; // Pour l'attribution de coins
    private Long contributionId; // Pour la validation de contribution
    private Long demandeId; // Pour la validation de demande
}