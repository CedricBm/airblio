/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author CedricBm
 */
@Entity
public class Facture implements Serializable {

    @Id
    @GeneratedValue
    private int id;

//    @OneToOne(optional = false)
//    @JoinColumn(name = "mission_intervention_id", unique = true, nullable = false, updatable = false)
//    private MissionIntervention missionIntervention;
//
//    @OneToOne(optional = false)
//    @JoinColumn(name = "pv_reception_id", unique = true, nullable = false, updatable = false)
//    private PVReception pvReception;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

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

//    /**
//     * @return the missionIntervention
//     */
//    public MissionIntervention getMissionIntervention() {
//        return missionIntervention;
//    }
//
//    /**
//     * @param missionIntervention the missionIntervention to set
//     */
//    public void setMissionIntervention(MissionIntervention missionIntervention) {
//        this.missionIntervention = missionIntervention;
//    }
//
//    /**
//     * @return the pvReception
//     */
//    public PVReception getPvReception() {
//        return pvReception;
//    }
//
//    /**
//     * @param pvReception the pvReception to set
//     */
//    public void setPvReception(PVReception pvReception) {
//        this.pvReception = pvReception;
//    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
