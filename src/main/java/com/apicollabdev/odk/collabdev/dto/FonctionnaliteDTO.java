package com.apicollabdev.odk.collabdev.dto;

public class FonctionnaliteDTO {
    private int id;
    private String pointFonctionnalite;
    private String statut;
    private int gestionnaireId;
    private int projetId;

    public FonctionnaliteDTO() {
    }

    public FonctionnaliteDTO(int id, String pointFonctionnalite, String statut) {
        this.id = id;
        this.pointFonctionnalite = pointFonctionnalite;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPointFonctionnalite() {
        return pointFonctionnalite;
    }

    public void setPointFonctionnalite(String pointFonctionnalite) {
        this.pointFonctionnalite = pointFonctionnalite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getGestionnaireId() {
        return gestionnaireId;
    }

    public void setGestionnaireId(int gestionnaireId) {
        this.gestionnaireId = gestionnaireId;
    }

    public int getProjetId() {
        return projetId;
    }

    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }
}
