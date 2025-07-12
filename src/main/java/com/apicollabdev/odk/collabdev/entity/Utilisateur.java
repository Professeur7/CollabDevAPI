package com.apicollabdev.odk.collabdev.entity;

import com.apicollabdev.odk.collabdev.enums.RoleUtilisateur;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role_utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Long id;
    private String email;
    private String password;

    private String nom;
    private String prenom;
}
