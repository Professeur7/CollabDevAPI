package com.apicollabdev.odk.collabdev.entity;

import com.apicollabdev.odk.collabdev.enums.Niveau;
import com.apicollabdev.odk.collabdev.enums.StatutIdee;
import com.apicollabdev.odk.collabdev.enums.StatutProjet;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    private LocalDate dateCreation;

    private boolean transformeEnProjet = false;

    @Enumerated(EnumType.STRING)
    private StatutIdee statut;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "id_gestionnaire", nullable = true)
    private Gestionnaire gestionnaire;

    @ManyToOne
    @JoinColumn(name = "id_contributeur", nullable = true, referencedColumnName = "id")
    @JsonBackReference(value = "contributeur-idee_projet")
    private Contributeur contributeur;



    @OneToOne(mappedBy = "ideeProjet")
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "domaine_id", nullable = true)
    private Domaine domaine;

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

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public StatutIdee getStatut() {
        return statut;
    }

    public void setStatut(StatutIdee statut) {
        this.statut = statut;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Contributeur getContributeur() {
        return contributeur;
    }

    public void setContributeur(Contributeur contributeur) {
        this.contributeur = contributeur;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
}
