package com.apicollabdev.odk.collabdev.controller;

import com.apicollabdev.odk.collabdev.dto.ContributionDTO;
import com.apicollabdev.odk.collabdev.entity.Contribution;
import com.apicollabdev.odk.collabdev.mapper.ContributionMapper;
import com.apicollabdev.odk.collabdev.service.Interfaces.ContributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contributions")
@RequiredArgsConstructor

public class ContributionController {

    private final ContributionService contributionService;

    private final ContributionMapper contributionMapper;



    @PostMapping("/projet/{idprojet}/contributeur/{idcontributeur}")
    public ResponseEntity<Contribution> create(@RequestBody ContributionDTO contributionDTO, @PathVariable("idprojet") long idProjet, @PathVariable("idcontributeur") long idContributeur) {
        return ResponseEntity.ok(contributionService.createContribution(contributionDTO, idProjet, idContributeur));
    }

    @GetMapping
    public List<Contribution> getAll() {
        return contributionService.getAllContributions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contribution> getById(@PathVariable Long id) {
        return ResponseEntity.ok(contributionService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contributionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{id}/valider")
    public ResponseEntity<ContributionDTO> validerContribution(
            @PathVariable Long idContribution,
            @RequestParam(name = "idContributeur") Long idContributeur,
            @RequestParam(name = "coins", defaultValue = "0") int coinsGagner
    ) {
        Contribution contribution = contributionService.validerContribution(idContribution, idContributeur, coinsGagner);
        return ResponseEntity.ok(contributionMapper.toDto(contribution));

        //return ResponseEntity.ok(ContributionMapper.toDto(contribution));
    }

    @PostMapping("/{id}/rejeter")
    public ResponseEntity<ContributionDTO> rejeterContribution(@PathVariable Long idContribution, @RequestParam Long idContributeur) {
        Contribution contribution = contributionService.rejeterContribution(idContribution, idContributeur);
      //  return ResponseEntity.ok(ContributionMapper.toDto(contribution));
        return ResponseEntity.ok(contributionMapper.toDto(contribution));

    }



}
