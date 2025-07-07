package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Commentaire;
import com.apicollabdev.odk.collabdev.repository.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentaireServiceImpl implements CommentaireService {

    private CommentaireRepository commentaireRepository;

    @Override
    public Commentaire createCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    @Override
    public Commentaire getById(Long id) {
        return commentaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commentaire non trouvé"));
    }

    @Override
    public void deleteById(Long id) {
        commentaireRepository.deleteById(id);
    }
}
