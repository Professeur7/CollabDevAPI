package com.apicollabdev.odk.collabdev.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Recevoir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecevoir;

    private LocalDateTime dateRecevoir;


    @ManyToOne
    @JoinColumn(name = "idNotification", nullable = true, referencedColumnName = "idNotification")
    private Notification notification;

    @ManyToOne
    @JoinColumn(name = "idContributeur", nullable = true)
    private Contributeur contributeur;
}
