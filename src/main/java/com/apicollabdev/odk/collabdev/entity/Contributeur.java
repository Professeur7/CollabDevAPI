package com.apicollabdev.odk.collabdev.entity;

import com.apicollabdev.odk.collabdev.enums.Niveau;
import com.apicollabdev.odk.collabdev.enums.Profil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@PrimaryKeyJoinColumn(name = "id_contributeur")
public class Contributeur extends Utilisateur{


    private String nom;
    private String prenom;
    private int coins = 0;
    @Enumerated(EnumType.STRING)
    private Profil profil; // DEVELOPPER, DESIGNER, etc

    @Enumerated(EnumType.STRING)
    private Niveau niveau;


//Relation


    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdeeProjet> ideeProjets;


    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coins> coinsH;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Badge> badges;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DemandeParticipation> demandeParticipations;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Demande> demandes;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DebloqueProjet> debloqueProjets;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recevoir> recevoirs;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public List<DemandeParticipation> getDemandeParticipations() {
        return demandeParticipations;
    }

    public void setDemandeParticipations(List<DemandeParticipation> demandeParticipations) {
        this.demandeParticipations = demandeParticipations;
    }

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }

    public List<DebloqueProjet> getDebloqueProjets() {
        return debloqueProjets;
    }

    public void setDebloqueProjets(List<DebloqueProjet> debloqueProjets) {
        this.debloqueProjets = debloqueProjets;
    }

    public List<Recevoir> getRecevoirs() {
        return recevoirs;
    }

    public void setRecevoirs(List<Recevoir> recevoirs) {
        this.recevoirs = recevoirs;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public List<IdeeProjet> getIdeeProjets() {
        return ideeProjets;
    }

    public void setIdeeProjets(List<IdeeProjet> ideeProjets) {
        this.ideeProjets = ideeProjets;
    }

    public int getCoins() {
        return coins;
    }

    public List<Coins> getCoinsH() {
        return coinsH;
    }

    public void setCoinsH(List<Coins> coinsH) {
        this.coinsH = coinsH;
    }
}

