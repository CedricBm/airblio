/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.beans;

import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "nb_heures_loues_reels")
public class NbHeuresLouesReels {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nb_heures")
    private int nbHeures;
    @Column(name = "prix_par_heures")
    private int prixParHeures;
    
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
     * @return the nbHeures
     */
    public int getNbHeures() {
        return nbHeures;
    }

    /**
     * @param nbHeures the nbHeures to set
     */
    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    /**
     * @return the prixParHeures
     */
    public int getPrixParHeures() {
        return prixParHeures;
    }

    /**
     * @param prixParHeures the prixParHeures to set
     */
    public void setPrixParHeures(int prixParHeures) {
        this.prixParHeures = prixParHeures;
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
