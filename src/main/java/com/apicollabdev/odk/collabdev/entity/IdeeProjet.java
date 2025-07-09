package com.apicollabdev.odk.collabdev.entity;

import com.apicollabdev.odk.collabdev.enums.StatutIdee;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
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

    public Long getIdIdeeProjet() {
        return idIdeeProjet;
    }

    public void setIdIdeeProjet(Long idIdeeProjet) {
        this.idIdeeProjet = idIdeeProjet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Contributeur getContributeur() {
        return contributeur;
    }

    public void setContributeur(Contributeur contributeur) {
        this.contributeur = contributeur;
    }

    public StatutIdee getStatut() {
        return statut;
    }

    public void setStatut(StatutIdee statut) {
        this.statut = statut;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
