/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.defictech.AlertCommune.service;

import com.defictech.AlertCommune.dao.UtilisateurRepository;
import com.defictech.AlertCommune.model.Utilisateur;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Serge
 */
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur save(Utilisateur incident) {
        return utilisateurRepository.save(incident);
    }

    public Optional<Utilisateur> findById(Integer id) {
        return utilisateurRepository.findById(id);
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public void deleteById(Integer id) {
        utilisateurRepository.deleteById(id);
    }
}
