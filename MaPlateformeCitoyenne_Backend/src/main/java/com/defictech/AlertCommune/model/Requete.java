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
@Table(name = "requete")
@NamedQueries({
    @NamedQuery(name = "Requete.findAll", query = "SELECT r FROM Requete r"),
    @NamedQuery(name = "Requete.findByIdRequete", query = "SELECT r FROM Requete r WHERE r.idRequete = :idRequete"),
    @NamedQuery(name = "Requete.findByTitre", query = "SELECT r FROM Requete r WHERE r.titre = :titre"),
    @NamedQuery(name = "Requete.findByStatut", query = "SELECT r FROM Requete r WHERE r.statut = :statut"),
    // Ajoutez d'autres NamedQuery selon vos besoins
})
@Data
@DynamicInsert
@DynamicUpdate
public class Requete implements Serializable {

     private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_requete")
    private int idRequete;
    
    @Column(name = "titre")
    private String titre;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @Column(name = "statut")
    private String statut;
    
    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    public Requete(int idRequete, String titre, String description, Date dateCreation, String statut, Utilisateur utilisateur) {
        this.idRequete = idRequete;
        this.titre = titre;
        this.description = description;
        this.dateCreation = dateCreation;
        this.statut = statut;
        this.utilisateur = utilisateur;
    }

    public int getIdRequete() {
        return idRequete;
    }

    public void setIdRequete(int idRequete) {
        this.idRequete = idRequete;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

}

