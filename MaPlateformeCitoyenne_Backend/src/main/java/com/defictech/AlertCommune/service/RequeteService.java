/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.defictech.AlertCommune.service;
import com.defictech.AlertCommune.dao.RequeteRepository;
import com.defictech.AlertCommune.model.Requete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Serge
 */


@Service
public class RequeteService {

    @Autowired
    private RequeteRepository requeteRepository;

    public Requete save(Requete requete) {
        return requeteRepository.save(requete);
    }

    public Optional<Requete> findById(Integer id) {
        return requeteRepository.findById(id);
    }

    public List<Requete> findAll() {
        return requeteRepository.findAll();
    }

    public void deleteById(Integer id) {
        requeteRepository.deleteById(id);
    }

    // Additional business logic and methods can be added here
}

