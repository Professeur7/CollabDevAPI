package com.apicollabdev.odk.collabdev.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("GESTIONNAIRE")
@EqualsAndHashCode(callSuper = true)
//@PrimaryKeyJoinColumn(name = "child_id")
@PrimaryKeyJoinColumn(name = "idGestionnaire")
public class Gestionnaire extends Contributeur {


    @OneToMany(mappedBy = "gestionnaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Projet> projets;

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    
}