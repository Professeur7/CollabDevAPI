package com.apicollabdev.odk.collabdev.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commentaire {

    @Id
    private String idCommentaire;

    private String auteur;

    private String contenu;

    private boolean supprime;
    private boolean modifie;

    @ManyToOne
    @JoinColumn(name = "idContributeur", nullable = true)
    private Contributeur contributeur;

    @ManyToOne
    @JoinColumn(name = "id_projet", nullable = true)
    private Projet projet;
}

