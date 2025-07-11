package com.apicollabdev.odk.collabdev.entity;


import com.apicollabdev.odk.collabdev.enums.Profil;
import com.apicollabdev.odk.collabdev.enums.ProfilAdmin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id_administrateur")
public class Administrateur extends Utilisateur{

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private ProfilAdmin profilAdmin; // DEVELOPPER, DESIGNER, etc

    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Coins> coins;

    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Badge> badge;


    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Notification> notification;
  
    @OneToMany(mappedBy = "domaine")
    private List<Domaine> domaine;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ProfilAdmin getProfilAdmin() {
        return profilAdmin;
    }

    public void setProfilAdmin(ProfilAdmin profilAdmin) {
        this.profilAdmin = profilAdmin;
    }

    public List<Coins> getCoins() {
        return coins;
    }

    public void setCoins(List<Coins> coins) {
        this.coins = coins;
    }

    public List<Badge> getBadge() {
        return badge;
    }

    public void setBadge(List<Badge> badge) {
        this.badge = badge;
    }

}

