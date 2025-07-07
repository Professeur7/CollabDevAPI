package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Badge;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.service.AdministrateurServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministrateurController {

    AdministrateurRepository administrateurRepository;

    AdministrateurServiceImpl administrateurServiceImpl;

    @PostMapping
    public ResponseEntity<Administrateur> creerBadges(Badge badge){
       return  ResponseEntity.ok(administrateurServiceImpl.creerBadge(badge));
    }


}
