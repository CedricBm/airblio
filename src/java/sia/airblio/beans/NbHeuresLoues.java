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
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author CedricBm
 */
@Entity
@Table(name = "nb_heures_loues")
public class NbHeuresLoues implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nb_heures")
    private int nbHeures;
    @Column(name = "prix_par_heures")
    private double prixParHeures;
    // Domains = [prevues, reels, supplementaires]
    private String statut;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private Technicien technicien;

    @ManyToOne
    @JoinColumn(name = "pv_reception_id")
    private PVReception pvReception;

    @ManyToOne
    @JoinColumn(name = "mission_intervention_id")
    private MissionIntervention missionIntervention;

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
    public double getPrixParHeures() {
        return prixParHeures;
    }

    /**
     * @param prixParHeures the prixParHeures to set
     */
    public void setPrixParHeures(double prixParHeures) {
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

    /**
     * @return the statut
     */
    public String getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }

    /**
     * @return the technicien
     */
    public Technicien getTechnicien() {
        return technicien;
    }

    /**
     * @param technicien the technicien to set
     */
    public void setTechnicien(Technicien technicien) {
        this.technicien = technicien;
    }

    /**
     * @return the pvReception
     */
    public PVReception getPvReception() {
        return pvReception;
    }

    /**
     * @param pvReception the pvReception to set
     */
    public void setPvReception(PVReception pvReception) {
        this.pvReception = pvReception;
    }

    /**
     * @return the missionIntervention
     */
    public MissionIntervention getMissionIntervention() {
        return missionIntervention;
    }

    /**
     * @param missionIntervention the missionIntervention to set
     */
    public void setMissionIntervention(MissionIntervention missionIntervention) {
        this.missionIntervention = missionIntervention;
    }
}
