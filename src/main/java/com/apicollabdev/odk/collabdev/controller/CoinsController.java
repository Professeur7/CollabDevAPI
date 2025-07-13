package com.apicollabdev.odk.collabdev.controller;
import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Coins;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.service.Interfaces.CoinsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/coins")
@RequiredArgsConstructor
public class CoinsController {

    private final CoinsService coinsService;
    private final AdministrateurRepository administrateurRepository;

    @PostMapping("/administrateur/{idadmin}")
    public ResponseEntity<Coins> create(@RequestBody Coins coins, @PathVariable("idadmin") long idAmin ) {
        Administrateur a = administrateurRepository.findById(idAmin)
                .orElseThrow( ()-> new RuntimeException("Administrateur non trouvé"));
        return ResponseEntity.ok(coinsService.createCoins(coins, idAmin));
    }

    @GetMapping
    public List<Coins> getAll() {
        return coinsService.getAllCoins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coins> getById(@PathVariable Long id) {
        return ResponseEntity.ok(coinsService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        coinsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
