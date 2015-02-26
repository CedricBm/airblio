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
@Table(name = "pv_reception")
public class PVReception {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "signature_responsable_equipe")
    private boolean signatureResponsableEquipe;
    @Column(name = "signature_client")
    private boolean signatureClient;
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
     * @return the signatureResponsableEquipe
     */
    public boolean isSignatureResponsableEquipe() {
        return signatureResponsableEquipe;
    }

    /**
     * @param signatureResponsableEquipe the signatureResponsableEquipe to set
     */
    public void setSignatureResponsableEquipe(boolean signatureResponsableEquipe) {
        this.signatureResponsableEquipe = signatureResponsableEquipe;
    }

    /**
     * @return the signatureClient
     */
    public boolean isSignatureClient() {
        return signatureClient;
    }

    /**
     * @param signatureClient the signatureClient to set
     */
    public void setSignatureClient(boolean signatureClient) {
        this.signatureClient = signatureClient;
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
