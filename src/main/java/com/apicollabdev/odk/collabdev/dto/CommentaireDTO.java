package com.apicollabdev.odk.collabdev.dto;

import lombok.Data;

@Data
public class CommentaireDTO {

    private String auteur;

    private String contenu;

    private boolean supprime;
    private boolean modifie;


}
