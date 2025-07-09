package com.apicollabdev.odk.collabdev.entity;


import com.apicollabdev.odk.collabdev.enums.Profil;
import com.apicollabdev.odk.collabdev.enums.ProfilAdmin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id_administrateur")
public class Administrateur extends Utilisateur{

    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private ProfilAdmin profilAdmin; // DEVELOPPER, DESIGNER, etc

    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Coins> coins;

    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Badge> badge;

    @OneToMany(mappedBy = "administrateur")
    private List<Administrateur> administrateurs;

    @OneToMany(mappedBy = "domaine")
    private List<Domaine> domaine;

}

