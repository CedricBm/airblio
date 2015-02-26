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
@Table(name = "mission_intervention")
public class MissionIntervention {
    @Id
    @GeneratedValue
    private int id;
    private String procedure;
    @Column(name = "condition_particuliere")
    private String conditionParticuliere;
    @Column(name = "id_fiche_facturation")
    private int idFicheFacturation;
    
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
     * @return the procedure
     */
    public String getProcedure() {
        return procedure;
    }

    /**
     * @param procedure the procedure to set
     */
    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    /**
     * @return the conditionParticuliere
     */
    public String getConditionParticuliere() {
        return conditionParticuliere;
    }

    /**
     * @param conditionParticuliere the conditionParticuliere to set
     */
    public void setConditionParticuliere(String conditionParticuliere) {
        this.conditionParticuliere = conditionParticuliere;
    }

    /**
     * @return the idFicheFacturation
     */
    public int getIdFicheFacturation() {
        return idFicheFacturation;
    }

    /**
     * @param idFicheFacturation the idFicheFacturation to set
     */
    public void setIdFicheFacturation(int idFicheFacturation) {
        this.idFicheFacturation = idFicheFacturation;
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
