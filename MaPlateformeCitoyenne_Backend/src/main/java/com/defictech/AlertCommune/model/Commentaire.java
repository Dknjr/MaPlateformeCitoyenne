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
@Table(name = "commentaire")
@NamedQueries({
    @NamedQuery(name = "Commentaire.findAll", query = "SELECT c FROM Commentaire c"),
    @NamedQuery(name = "Commentaire.findByIdCommentaire", query = "SELECT c FROM Commentaire c WHERE c.idCommentaire = :idCommentaire"),
    // Ajoutez d'autres NamedQuery selon vos besoins
})
@Data
@DynamicInsert
@DynamicUpdate
public class Commentaire implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commentaire")
    private Integer idCommentaire;

    @Column(name = "contenu")
    private String contenu;

    @Column(name = "date_commentaire")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommentaire;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_requete")
    private Requete requete;

    public Commentaire(int idCommentaire, String contenu, Date dateCommentaire, Utilisateur utilisateur, Requete requete) {
        this.idCommentaire = idCommentaire;
        this.contenu = contenu;
        this.dateCommentaire = dateCommentaire;
        this.utilisateur = utilisateur;
        this.requete = requete;
    }

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Requete getRequete() {
        return requete;
    }

    public void setRequete(Requete requete) {
        this.requete = requete;
    }
    

}
