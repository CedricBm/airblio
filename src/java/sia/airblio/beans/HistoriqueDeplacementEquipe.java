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
@Table(name = "historique_deplacement_equipe")
public class HistoriqueDeplacementEquipe implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "from_site")
    private String fromSite;
    @Column(name = "de_site")
    private String toSite;
    @Column(name = "date_deplacement")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeplacement;
    @Column(name = "duree_en_jour")
    private int dureeEnJour;

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
