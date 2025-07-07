package com.apicollabdev.odk.collabdev.entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("GESTIONNAIRE")
public class Gestionnaire extends Contributeur{

    private boolean validerContribution;
    private boolean validerCommentaire;
    private boolean validerDemande;

    @OneToMany(mappedBy = "gestionnaire", cascade = CascadeType.ALL)
    private List<Projet> projets;


}

