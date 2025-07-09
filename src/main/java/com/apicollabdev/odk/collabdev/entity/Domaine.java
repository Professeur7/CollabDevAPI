package com.apicollabdev.odk.collabdev.entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Domaine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domaine")
    private Long idDomaine;

    private String titre;
    private String description;

    @OneToMany(mappedBy = "domaine")
    private List<IdeeProjet> ideeProjets;

    @ManyToOne
    @JoinColumn(name = "id_administrateur", nullable = true)
    private Administrateur administrateur;

}
