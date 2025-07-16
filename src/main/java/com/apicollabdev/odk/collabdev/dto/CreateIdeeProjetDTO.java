package com.apicollabdev.odk.collabdev.dto;

import com.apicollabdev.odk.collabdev.enums.Niveau;
import lombok.Data;

@Data
public class CreateIdeeProjetDTO {
    private String titre;
    private String description;
    private Niveau niveau;
    private boolean leguer;
}
