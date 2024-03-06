/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.defictech.AlertCommune.service;

import com.defictech.AlertCommune.dao.CommentaireRepository;
import com.defictech.AlertCommune.model.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Serge
 */


@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    public Commentaire save(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    public Optional<Commentaire> findById(Integer id) {
        return commentaireRepository.findById(id);
    }

    public List<Commentaire> findAll() {
        return commentaireRepository.findAll();
    }

    public void deleteById(Integer id) {
        commentaireRepository.deleteById(id);
    }

    // Additional methods can be implemented here
}

