package com.apicollabdev.odk.collabdev.dto;

import com.apicollabdev.odk.collabdev.enums.StatutContribution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


public class ContributionDTO {
    private String titre;
    private String   contenu;
    private String  type;

    private Long contributeurId;
    private StatutContribution statut; // VALIDE ou REJETE

    public ContributionDTO() {
    }

    public ContributionDTO(String titre,
                           String contenu,
                           String type,
                           Long contributeurId,
                           StatutContribution statut) {
        this.titre = titre;
        this.contenu = contenu;
        this.type = type;
        this.contributeurId = contributeurId;
        this.statut = statut;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getContributeurId() {
        return contributeurId;
    }

    public void setContributeurId(Long contributeurId) {
        this.contributeurId = contributeurId;
    }

    public StatutContribution getStatut() {
        return statut;
    }

    public void setStatut(StatutContribution statut) {
        this.statut = statut;
    }
}
