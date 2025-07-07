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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_contributeur", discriminatorType = DiscriminatorType.STRING)
public class Contributeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContributeur;

    private String nom;

    private String prenom;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Profil profil; // DEVELOPPER, DESIGNER, etc


    private Niveau niveau;


//Relation

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL)
    private List<Contribution> contributions;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL)
    private List<IdeeProjet> ideeProjets;


    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL)
    private List<Coins> coins;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL)
    private List<Badge> badges;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL)
    private List<DemandeParticipation> demandeParticipations;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL)
    private List<Demande> demandes;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL)
    private List<DebloqueProjet> debloqueProjets;

    @OneToMany(mappedBy = "contributeur", cascade = CascadeType.ALL)
    private List<Recevoir> recevoirs;

}

