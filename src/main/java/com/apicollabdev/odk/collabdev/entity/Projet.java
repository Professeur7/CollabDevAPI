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
    @JoinColumn(name = "id_ideeProjet")
    private IdeeProjet ideeProjet;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<DemandeParticipation> demandeParticipation;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<Demande> demandes;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<DebloqueProjet> debloqueProjets;

    @ManyToOne
    @JoinColumn(name = "idDomaine", nullable = true)
    private Domaine domaine;

    @ManyToOne
    @JoinColumn(name = "idGestionnaire", nullable = true)
    private Gestionnaire gestionnaire;
}

