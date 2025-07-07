package com.apicollabdev.odk.collabdev.dto;

import com.apicollabdev.odk.collabdev.enums.Niveau;
import com.apicollabdev.odk.collabdev.enums.Profil;
import lombok.Data;

@Data
public class ContributeurDTO {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Profil profil;
    private Niveau niveau;
}
