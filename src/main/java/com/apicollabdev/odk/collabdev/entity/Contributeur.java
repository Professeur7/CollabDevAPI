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
@Table(name = "contributeurs")  // Spécification explicite du nom de table
@PrimaryKeyJoinColumn(name = "id_contributeur")
public class Contributeur extends Utilisateur {

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Profil profil;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @Column(nullable = false)
    @Builder.Default
    private boolean active = true; // Par défaut actif

    // Relations
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