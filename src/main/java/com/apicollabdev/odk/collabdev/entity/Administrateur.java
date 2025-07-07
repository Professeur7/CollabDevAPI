package com.apicollabdev.odk.collabdev.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    private String email;
    private String password;

    @OneToMany(mappedBy = "administrateur")
    private List<Coins> coins;

    @OneToMany(mappedBy = "administrateur")
    private List<Badge> badge;
}

