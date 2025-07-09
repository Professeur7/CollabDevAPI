package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.dto.FonctionnaliteDTO;
import com.apicollabdev.odk.collabdev.entity.Fonctionnalite;

import java.util.List;

public interface FonctionnaliteService {
    public FonctionnaliteDTO creerFonctionnalite(FonctionnaliteDTO dto);
    public List<FonctionnaliteDTO> ListerFonctionnalite();
    public FonctionnaliteDTO ListeFonctionnaliteParId(int id);
    }
