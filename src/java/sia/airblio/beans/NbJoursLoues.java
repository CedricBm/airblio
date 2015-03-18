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
@Table(name = "nb_jours_loues")
public class NbJoursLoues implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nb_jours")
    private int nbJours;
    @Column(name = "prix_par_jours")
    private double prixParJours;
    @Column(name = "materiel_fixed")
    private String materielFixed;
    // Domains = [prevues, reels]
    private String statut;

    @ManyToOne
    @JoinColumn(name = "materiel_id")
    private Materiel materiel;

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
     * @return the nbJours
     */
    public int getNbJours() {
        return nbJours;
    }

    /**
     * @param nbJours the nbJours to set
     */
    public void setNbJours(int nbJours) {
        this.nbJours = nbJours;
    }

    /**
     * @return the prixParJours
     */
    public double getPrixParJours() {
        return prixParJours;
    }

    /**
     * @param prixParJours the prixParJours to set
     */
    public void setPrixParJours(double prixParJours) {
        this.prixParJours = prixParJours;
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
     * @return the materielFixed
     */
    public String getMaterielFixed() {
        return materielFixed;
    }

    /**
     * @param materielFixed the materielFixed to set
     */
    public void setMaterielFixed(String materielFixed) {
        this.materielFixed = materielFixed;
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
     * @return the materiel
     */
    public Materiel getMateriel() {
        return materiel;
    }

    /**
     * @param materiel the materiel to set
     */
    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
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
