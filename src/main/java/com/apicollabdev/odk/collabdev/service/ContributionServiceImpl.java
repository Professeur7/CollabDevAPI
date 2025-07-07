package com.apicollabdev.odk.collabdev.service;


import com.apicollabdev.odk.collabdev.entity.Contribution;
import com.apicollabdev.odk.collabdev.repository.ContributionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContributionServiceImpl implements ContributionService {
    private ContributionRepository contributionRepository;

    @Override
    public Contribution createContribution(Contribution contribution) {
        return contributionRepository.save(contribution);
    }

    @Override
    public List<Contribution> getAllContributions() {
        return contributionRepository.findAll();
    }

    @Override
    public Contribution getById(Long id) {
        return contributionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contribution non trouvée"));
    }

    @Override
    public void deleteById(Long id) {
        contributionRepository.deleteById(id);
    }
}
