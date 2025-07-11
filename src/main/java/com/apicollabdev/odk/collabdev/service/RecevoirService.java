package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Recevoir;

import java.util.List;

public interface RecevoirService {
    Recevoir createRecevoir(Recevoir recevoir);
    List<Recevoir> getAllRecevoir();
    Recevoir getById(Long id);
    void deleteById(Long id);
}
