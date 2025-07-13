package com.apicollabdev.odk.collabdev.entity;

import com.apicollabdev.odk.collabdev.enums.Niveau;
import com.apicollabdev.odk.collabdev.enums.Profil;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id_contributeur")
public class Contributeur extends Utilisateur{


    private String nom;
    private String prenom;
    private boolean Active;

    @Enumerated(EnumType.STRING)
    private Profil profil; // DEVELOPPER, DESIGNER, etc

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    //@Column(nullable = false)
    //private int coin = 0;


//Relation

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Notification> notification;


    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdeeProjet> ideeProjets;


    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coins> coins;

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

}

