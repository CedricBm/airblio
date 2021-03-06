/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author CedricBm
 */
@Entity
public class Technicien implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private String email;
    @Column(name = "prix_par_heure")
    private double prixParHeure;
    private String poste;

    @ManyToOne
    @JoinColumn(name = "equipe_technique_id")
    private EquipeTechnique equipeTechnique;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created = new Date();
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updated = new Date();

    @PreUpdate
    public void setLastUpdate() {
        this.updated = new Date();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the prixParHeure
     */
    public double getPrixParHeure() {
        return prixParHeure;
    }

    /**
     * @param prixParHeure the prixParHeure to set
     */
    public void setPrixParHeure(double prixParHeure) {
        this.prixParHeure = prixParHeure;
    }

    /**
     * @return the poste
     */
    public String getPoste() {
        return poste;
    }

    /**
     * @param poste the poste to set
     */
    public void setPoste(String poste) {
        this.poste = poste;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @return the updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @return the equipeTechnique
     */
    public EquipeTechnique getEquipeTechnique() {
        return equipeTechnique;
    }

    /**
     * @param equipeTechnique the equipeTechnique to set
     */
    public void setEquipeTechnique(EquipeTechnique equipeTechnique) {
        this.equipeTechnique = equipeTechnique;
    }
}
