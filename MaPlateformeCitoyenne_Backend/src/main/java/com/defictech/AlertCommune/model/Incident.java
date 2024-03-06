/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.defictech.AlertCommune.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Serge
 */


@Entity
@Table(name = "incident")
@NamedQueries({
    @NamedQuery(name = "Incident.findAll", query = "SELECT i FROM Incident i"),
    @NamedQuery(name = "Incident.findByIdIncident", query = "SELECT i FROM Incident i WHERE i.idIncident = :idIncident"),
    @NamedQuery(name = "Incident.findByType", query = "SELECT i FROM Incident i WHERE i.type = :type"),
    // Ajoutez d'autres NamedQuery selon vos besoins
})
@Data
@DynamicInsert
@DynamicUpdate
public class Incident implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incident")
    private Integer idIncident;

    @Column(name = "type")
    private String type;

    @Column(name = "localisation")
    private String localisation;

    @Column(name = "date_signalement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSignalement;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_requete")
    private Requete requete;

    public Incident(int idIncident, String type, String localisation, Date dateSignalement, String description, Requete requete) {
        this.idIncident = idIncident;
        this.type = type;
        this.localisation = localisation;
        this.dateSignalement = dateSignalement;
        this.description = description;
        this.requete = requete;
    }

    public int getIdIncident() {
        return idIncident;
    }

    public void setIdIncident(int idIncident) {
        this.idIncident = idIncident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Date getDateSignalement() {
        return dateSignalement;
    }

    public void setDateSignalement(Date dateSignalement) {
        this.dateSignalement = dateSignalement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Requete getRequete() {
        return requete;
    }

    public void setRequete(Requete requete) {
        this.requete = requete;
    }

}

