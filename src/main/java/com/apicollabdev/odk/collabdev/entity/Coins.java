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
    @Column(name = "id_coins")
    private Long idCoin;

    private int nombreCoins;

    @ManyToOne
    @JoinColumn(name = "id_contributeur", nullable = true)
    private Contributeur contributeur;

    @ManyToOne
    @JoinColumn(name = "id_administrateur", nullable = true)
    private Administrateur administrateur;
}
