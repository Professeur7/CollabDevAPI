package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.dto.DebloqueProjetDTO;
import com.apicollabdev.odk.collabdev.entity.Coins;
import com.apicollabdev.odk.collabdev.entity.DebloqueProjet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DebloqueProjetService {
    DebloqueProjet createDebloqueProjet(DebloqueProjetDTO debloqueProjet, Long idContributeur);
    List<DebloqueProjet> getAllDebloqueProjet();
    DebloqueProjet getById(Long id);
    void deleteById(Long id);
    DebloqueProjet updateDebloqueProjet(
            int id,
            DebloqueProjetDTO debloqueProjetDTO
    );
}
