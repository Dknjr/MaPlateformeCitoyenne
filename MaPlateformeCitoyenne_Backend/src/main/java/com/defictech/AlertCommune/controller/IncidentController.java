/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.defictech.AlertCommune.controller;

import com.defictech.AlertCommune.model.Incident;
import com.defictech.AlertCommune.service.IncidentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Serge
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/incident")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @PostMapping
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {
        return ResponseEntity.ok(incidentService.save(incident));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Integer id) {
        return incidentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incident> updateIncident(@PathVariable Integer id, @RequestBody Incident incident) {
        incident.setIdIncident(id);
        return ResponseEntity.ok(incidentService.save(incident));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncident(@PathVariable Integer id) {
        incidentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

