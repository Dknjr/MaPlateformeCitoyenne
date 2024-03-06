/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.defictech.AlertCommune.controller;

import com.defictech.AlertCommune.model.Requete;
import com.defictech.AlertCommune.service.RequeteService;
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
@RequestMapping("/api/requete")
public class RequeteController {

    @Autowired
    private RequeteService requeteService;

    @PostMapping
    public ResponseEntity<Requete> createRequete(@RequestBody Requete requete) {
        Requete savedRequete = requeteService.save(requete);
        return ResponseEntity.ok(savedRequete);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Requete> getRequeteById(@PathVariable Integer id) {
        return requeteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Requete> getAllRequetes() {
        return requeteService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Requete> updateRequete(@PathVariable Integer id, @RequestBody Requete requete) {
        requete.setIdRequete(id);
        return ResponseEntity.ok(requeteService.save(requete));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequete(@PathVariable Integer id) {
        requeteService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

