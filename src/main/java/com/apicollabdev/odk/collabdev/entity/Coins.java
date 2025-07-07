package com.apicollabdev.odk.collabdev.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCoin;

    private int nombreCoins;

    @ManyToOne
    @JoinColumn(name = "idContributeur", nullable = true)
    private Contributeur contributeur;

    @ManyToOne
    @JoinColumn(name = "idAdministrateur", nullable = true)
    private Administrateur administrateur;
}
