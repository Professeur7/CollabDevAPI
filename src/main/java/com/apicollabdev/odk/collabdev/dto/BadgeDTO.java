package com.apicollabdev.odk.collabdev.dto;


import com.apicollabdev.odk.collabdev.entity.Administrateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadgeDTO {
    private String nom;
    private String description;
    private String image; // image en URL ou nom de fichier
    private int nombre;


}
