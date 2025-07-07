package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Coins;
import com.apicollabdev.odk.collabdev.entity.DebloqueProjet;

import java.util.List;

public interface DebloqueProjetService {
    DebloqueProjet createDebloqueProjet(DebloqueProjet debloqueProjet);
    List<DebloqueProjet> getAllDebloqueProjet();
    DebloqueProjet getById(Long id);
    void deleteById(Long id);
}
