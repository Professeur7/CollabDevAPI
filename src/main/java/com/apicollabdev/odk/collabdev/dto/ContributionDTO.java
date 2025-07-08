package com.apicollabdev.odk.collabdev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContributionDTO {
    private String titre;
    private String   contenu;
    private String  type;
}
