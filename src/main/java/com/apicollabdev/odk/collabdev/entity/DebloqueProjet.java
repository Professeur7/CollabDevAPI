package com.apicollabdev.odk.collabdev.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DebloqueProjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_debloque_projet")
    private Integer id_debloqueProjet;

    private boolean visibilite;

    private int nombreCoins;

    @ManyToOne
    @JoinColumn(name = "id_projet", nullable = false)
    private Projet projet;

    @ManyToOne
    @JoinColumn(name = "id_contributeur", nullable = false, referencedColumnName = "id")
    private Contributeur contributeur;


}
