package com.apicollabdev.odk.collabdev.entity;

import com.apicollabdev.odk.collabdev.enums.RoleUtilisateur;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role_utilisateur", discriminatorType = DiscriminatorType.STRING)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @Column(nullable = false)
    @Builder.Default
    private boolean active = true;
   /* @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleUtilisateur role;*/



}
