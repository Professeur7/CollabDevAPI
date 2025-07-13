package com.apicollabdev.odk.collabdev.dto;

import com.apicollabdev.odk.collabdev.enums.ChoixRole;

import com.apicollabdev.odk.collabdev.enums.StatutDemande;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeDTO {
    private String description;

    @Enumerated(EnumType.STRING)
    private StatutDemande statutDemande;

    @Enumerated(EnumType.STRING)
    private ChoixRole choixRole;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatutDemande getStatutDemande() {
        return statutDemande;
    }

    public void setStatutDemande(StatutDemande statutDemande) {
        this.statutDemande = statutDemande;
    }

    public ChoixRole getChoixRole() {
        return choixRole;
    }

    public void setChoixRole(ChoixRole choixRole) {
        this.choixRole = choixRole;
    }
}
