package com.apicollabdev.odk.collabdev.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Recevoir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recevoir")
    private int idRecevoir;

    private LocalDateTime dateRecevoir;

    private boolean lu;

    @ManyToOne
    @JoinColumn(name = "id_notification", nullable = false)
    private Notification notification;

    @ManyToOne
    @JoinColumn(name = "id_contributeur", nullable = false)
    private Contributeur contributeur;

    public void setContributeur(Contributeur gestionnaireContributeur) {
    }
}
