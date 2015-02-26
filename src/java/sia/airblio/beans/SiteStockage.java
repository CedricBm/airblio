/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 *
 * @author CedricBm
 */
@Entity
@Table(name = "site_stockage")
public class SiteStockage {
    @Id
    @GeneratedValue
    private int id;
    private int nom;
    private int adresse;
    
    private Date created = new Date();
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
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public int getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(int nom) {
        this.nom = nom;
    }

    /**
     * @return the adresse
     */
    public int getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(int adresse) {
        this.adresse = adresse;
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
}
