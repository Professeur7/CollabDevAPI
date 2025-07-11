package com.apicollabdev.odk.collabdev.entity;


import com.apicollabdev.odk.collabdev.enums.TypeNotification;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotification;

    @ManyToOne
    @JoinColumn(name = "idAdministrateur",  nullable = true, referencedColumnName = "id")
    @JsonBackReference
    private Administrateur administrateur;

    private String description;

    private LocalDateTime dateNotification;

    @Enumerated(EnumType.STRING)
    private TypeNotification enumType;

    private boolean etat;

    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recevoir> recevoirs;

}

