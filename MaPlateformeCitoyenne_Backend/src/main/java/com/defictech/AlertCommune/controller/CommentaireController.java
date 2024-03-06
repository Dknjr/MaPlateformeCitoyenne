/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.defictech.AlertCommune.controller;

import com.defictech.AlertCommune.model.Commentaire;
import com.defictech.AlertCommune.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Serge
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/commentaire")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @PostMapping
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        return ResponseEntity.ok(commentaireService.save(commentaire));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Integer id) {
        return commentaireService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Commentaire> getAllCommentaires() {
        return commentaireService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Integer id, @RequestBody Commentaire commentaire) {
        commentaire.setIdCommentaire(id);
        return ResponseEntity.ok(commentaireService.save(commentaire));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaire(@PathVariable Integer id) {
        commentaireService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

