package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Badge;
import com.apicollabdev.odk.collabdev.entity.Coins;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.repository.BadgeRepository;
import com.apicollabdev.odk.collabdev.repository.CoinsRepository;
import com.apicollabdev.odk.collabdev.service.AdministrateurServiceImpl;
import com.apicollabdev.odk.collabdev.service.BadgeServiceImpl;
import com.apicollabdev.odk.collabdev.service.CoinsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdministrateurController {


     BadgeServiceImpl badgeServiceImpl;
     CoinsServiceImpl coinsServiceImpl;
//     BadgeRepository badgeRepository;
//     CoinsRepository coinsRepository;
//
//     AdministrateurRepository administrateurRepository;
//     AdministrateurServiceImpl administrateurServiceImpl;
//
//
//
//
//    // Creer les badges
//    @PostMapping("/creerBadges")
//    public ResponseEntity<Badge> create( @RequestBody Badge badge, @PathVariable int idAdmin ) throws AccessDeniedException {
//        Administrateur administrateur = administrateurRepository.findByIdAdmin(idAdmin)
//                .orElseThrow(()-> new RuntimeException("Erreur"));
//
//        return ResponseEntity.ok(administrateurServiceImpl.creerBadges(badge, administrateur));
//
//    }
//
//    //mMettre a jours les badges
//    @PutMapping("/{id}")
//    public ResponseEntity<Badge> update( @RequestBody Badge badge, @PathVariable int idAdmin) throws AccessDeniedException {
//        Administrateur administrateur = administrateurRepository.findByIdAdmin(idAdmin)
//                .orElseThrow(()-> new RuntimeException("Erreur"));
//
//        return ResponseEntity.ok(administrateurServiceImpl.updateBadge(idAdmin, badge, administrateur));
//
//    }
//
//
//    //Supprimer les badges
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable int idBadge, Administrateur administrateur) throws AccessDeniedException {
//        Badge badge = badgeRepository.deleteBadgeByIdBadge(idBadge).
//                orElseThrow(()-> new RuntimeException("Badge introuvable"));
//
//       administrateurServiceImpl.deleteBadge(idBadge, administrateur);
//
//       return ResponseEntity.noContent().build();
//
//    }
//
//    //voir les badges
//    @GetMapping
//    public ResponseEntity <List<Badge>> Read() {
//       List<Badge> badges = badgeServiceImpl.getAllBadges();
//       return ResponseEntity.ok(badges);
//
//    }
//
//
//    //Pour les coins
//    //Creer les coins
////    @PostMapping("/creercoins/{idAdmin}")
////    public ResponseEntity<Coins> CreerCoins(@RequestBody Coins coins, @PathVariable int idAdmin) throws AccessDeniedException {
////        Administrateur administrateur = administrateurRepository.findByIdAdmin(idAdmin).orElseThrow(()-> new RuntimeException("Erreur"));
////
////        return ResponseEntity.ok(administrateurServiceImpl.CreerCoin(coins , administrateur));
////    }
//
//    @PostMapping("/creercoins/{idAdmin}")
//    public ResponseEntity<Coins> CreerCoins(@RequestBody Coins coins, @PathVariable int idAdmin) throws AccessDeniedException {
//        Administrateur administrateur = administrateurRepository.findByIdAdmin(idAdmin)
//                .orElseThrow(() -> new RuntimeException("Erreur"));
//
//        return ResponseEntity.ok(administrateurServiceImpl.CreerCoin(coins, administrateur));
//    }
//
//
//
//    //Mettre a jours  les coins
//    @PutMapping("/Coins/{id}")
//    public ResponseEntity<Coins> MiseajourCoins(@RequestBody Coins coins, @PathVariable int idAdmin) throws AccessDeniedException {
//        Administrateur administrateur = administrateurRepository.findByIdAdmin(idAdmin).orElseThrow(()-> new RuntimeException("Erreur"));
//
//        return ResponseEntity.ok(administrateurServiceImpl.updateCoins(idAdmin, coins , administrateur));
//    }
//
//    //Supprimer  les coins
//    @DeleteMapping("/Coins/{id}")
//    public ResponseEntity<?> SupprimerCoins(@RequestBody int idCoins, Administrateur administrateur) throws AccessDeniedException {
//
//        if(administrateur == null){
//            throw new AccessDeniedException("Erreur");
//        }
//
//        Coins coins = coinsRepository.deleteCoinsByIdCoin(idCoins)
//                .orElseThrow(()-> new RuntimeException("Erreur"));
//
//       coinsRepository.delete(coins);
//
//       return ResponseEntity.noContent().build();
//    }

//    //Lister les coins
//    @GetMapping("/coins")
//    public ResponseEntity<List<Coins>> AfficherListe(){
//        List<Coins> coinsList = coinsServiceImpl.getAllCoins();
//        return ResponseEntity.ok(coinsList);
//
//    }


}
