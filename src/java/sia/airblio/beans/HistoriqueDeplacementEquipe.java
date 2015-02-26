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
@Table(name = "historique_deplacement_equipe")
public class HistoriqueDeplacementEquipe {
    @Id
    @GeneratedValue
    private int id;
    private String from;
    private String to;
    @Column(name = "date_deplacement")
    private Date dateDeplacement;
    @Column(name = "duree_en_jour")
    private int dureeEnJour;
    
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
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return the dateDeplacement
     */
    public Date getDateDeplacement() {
        return dateDeplacement;
    }

    /**
     * @param dateDeplacement the dateDeplacement to set
     */
    public void setDateDeplacement(Date dateDeplacement) {
        this.dateDeplacement = dateDeplacement;
    }

    /**
     * @return the dureeEnJour
     */
    public int getDureeEnJour() {
        return dureeEnJour;
    }

    /**
     * @param dureeEnJour the dureeEnJour to set
     */
    public void setDureeEnJour(int dureeEnJour) {
        this.dureeEnJour = dureeEnJour;
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
