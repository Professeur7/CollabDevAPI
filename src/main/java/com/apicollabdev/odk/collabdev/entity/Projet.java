package com.apicollabdev.odk.collabdev.entity;


import com.apicollabdev.odk.collabdev.enums.StatutIdee;
import com.apicollabdev.odk.collabdev.enums.StatutProjet;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projet")
    private Long idProjet;

    private String titre;
    private String description;

    private LocalDate date;

    private boolean cahierDeCharge;

    @Enumerated(EnumType.STRING)
    private StatutProjet statut;

    public Projet(){
    }

    public Projet(List<Contribution> contributions) {
        this.contributions = contributions;
    }


    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<Contribution> contributions;

    @ManyToOne
    @JoinColumn(name = "id_idee_projet")
    private IdeeProjet ideeProjet;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DemandeParticipation> demandeParticipation;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Demande> demandes;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DebloqueProjet> debloqueProjets;

    @ManyToOne
    @JoinColumn(name = "id_domaine", nullable = true)
    private Domaine domaine;

    @ManyToOne
    @JoinColumn(name = "id_gestionnaire", nullable = true)
    private Gestionnaire gestionnaire;
}

