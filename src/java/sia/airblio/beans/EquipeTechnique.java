/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author CedricBm
 */
@Entity
@Table(name = "equipe_technique")
public class EquipeTechnique implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private double latitude;
    private double longitude;
    @Column(name = "en_transit")
    private boolean enTransit;

    @OneToMany(mappedBy = "equipeTechnique")
    private Set<Commande> commandes;

    @OneToMany(mappedBy = "equipeTechnique")
    private Set<PVReception> pvsReception;

    @OneToMany(mappedBy = "equipeTechnique")
    private Set<HistoriqueDeplacementEquipe> historique;

    @OneToMany(mappedBy = "equipeTechnique")
    private Set<Technicien> techniciens;

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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the enTransit
     */
    public boolean isEnTransit() {
        return enTransit;
    }

    /**
     * @param enTransit the enTransit to set
     */
    public void setEnTransit(boolean enTransit) {
        this.enTransit = enTransit;
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
     * @return the commandes
     */
    public Set<Commande> getCommandes() {
        return commandes;
    }

    /**
     * @param commandes the commandes to set
     */
    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    /**
     * @return the pvsReception
     */
    public Set<PVReception> getPvsReception() {
        return pvsReception;
    }

    /**
     * @param pvsReception the pvsReception to set
     */
    public void setPvsReception(Set<PVReception> pvsReception) {
        this.pvsReception = pvsReception;
    }

    /**
     * @return the historique
     */
    public Set<HistoriqueDeplacementEquipe> getHistorique() {
        return historique;
    }

    /**
     * @param historique the historique to set
     */
    public void setHistorique(Set<HistoriqueDeplacementEquipe> historique) {
        this.historique = historique;
    }

    /**
     * @return the techniciens
     */
    public Set<Technicien> getTechniciens() {
        return techniciens;
    }

    /**
     * @param techniciens the techniciens to set
     */
    public void setTechniciens(Set<Technicien> techniciens) {
        this.techniciens = techniciens;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
