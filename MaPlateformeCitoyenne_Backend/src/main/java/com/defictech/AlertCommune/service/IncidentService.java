/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.defictech.AlertCommune.service;

import com.defictech.AlertCommune.dao.IncidentRepository;
import com.defictech.AlertCommune.model.Incident;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Serge
 */
@Service
public class IncidentService {
     @Autowired
    private IncidentRepository incidentRepository;

    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }

    public Optional<Incident> findById(Integer id) {
        return incidentRepository.findById(id);
    }

    public List<Incident> findAll() {
        return incidentRepository.findAll();
    }

    public void deleteById(Integer id) {
        incidentRepository.deleteById(id);
    }
}
