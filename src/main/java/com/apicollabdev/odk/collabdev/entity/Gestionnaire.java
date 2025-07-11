package com.apicollabdev.odk.collabdev.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("GESTIONNAIRE")
//@PrimaryKeyJoinColumn(name = "id")
public class Gestionnaire extends Contributeur {

    private boolean validerContribution;
    private boolean validerDemande;

    @OneToMany(mappedBy = "gestionnaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Projet> projets;

    // Méthodes pour vérifier les permissions
    public boolean peutValiderContribution() {
        return this.validerContribution;
    }



    public boolean peutValiderDemande() {
        return this.validerDemande;
    }

    public boolean isValiderContribution() {
        return validerContribution;
    }

    public void setValiderContribution(boolean validerContribution) {
        this.validerContribution = validerContribution;
    }


    public boolean isValiderDemande() {
        return validerDemande;
    }

    public void setValiderDemande(boolean validerDemande) {
        this.validerDemande = validerDemande;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
}