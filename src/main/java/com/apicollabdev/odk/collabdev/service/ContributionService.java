package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Contribution;

import java.util.List;

public interface ContributionService {
    Contribution createContribution(Contribution contribution);
    List<Contribution> getAllContributions();
    Contribution getById(Long id);
    void deleteById(Long id);
}
