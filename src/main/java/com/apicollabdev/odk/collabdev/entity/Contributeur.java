package com.apicollabdev.odk.collabdev.entity;

import com.apicollabdev.odk.collabdev.enums.Niveau;
import com.apicollabdev.odk.collabdev.enums.Profil;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
// Spécification explicite du nom de tabl
@DiscriminatorValue("CONTRIBUTEUR")// e
public class Contributeur extends Utilisateur {


    private String nom;
    private String prenom;
    private int coins = 0;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Profil profil;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    // Par défaut actif

    // Relations
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
}
/*



*/