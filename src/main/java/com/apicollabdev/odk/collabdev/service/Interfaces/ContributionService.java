package com.apicollabdev.odk.collabdev.service.Interfaces;

import com.apicollabdev.odk.collabdev.dto.ContributionDTO;
import com.apicollabdev.odk.collabdev.entity.Contribution;

import java.util.List;

public interface ContributionService {
    Contribution createContribution(ContributionDTO contribution, Long idProjet, Long idContributeur);
    List<Contribution> getAllContributions();
    Contribution getById(Long id);
    void deleteById(Long id);
    public Contribution validerContribution(Long idContribution, Long idContributeur, int coins);
    public Contribution rejeterContribution(Long idContribution, Long idContributeur);

}
