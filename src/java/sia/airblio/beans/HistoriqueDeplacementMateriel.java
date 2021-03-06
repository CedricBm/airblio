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
@Table(name = "historique_deplacement_materiel")
public class HistoriqueDeplacementMateriel implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "from_site")
    private String fromSite;
    @Column(name = "to_site")
    private String toSite;
    @Column(name = "date_deplacement")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeplacement;
    @Column(name = "duree_en_jour")
    private int dureeEnjour;
    @Column(name = "materiel_fixed")
    private String materielFixed;

    @ManyToOne
    @JoinColumn(name = "materiel_id")
    private Materiel materiel;

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
     * @return the dureeEnjour
     */
    public int getDureeEnjour() {
        return dureeEnjour;
    }

    /**
     * @param dureeEnjour the dureeEnjour to set
     */
    public void setDureeEnjour(int dureeEnjour) {
        this.dureeEnjour = dureeEnjour;
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
     * @return the fromSite
     */
    public String getFromSite() {
        return fromSite;
    }

    /**
     * @param fromSite the fromSite to set
     */
    public void setFromSite(String fromSite) {
        this.fromSite = fromSite;
    }

    /**
     * @return the toSite
     */
    public String getToSite() {
        return toSite;
    }

    /**
     * @param toSite the toSite to set
     */
    public void setToSite(String toSite) {
        this.toSite = toSite;
    }
}
