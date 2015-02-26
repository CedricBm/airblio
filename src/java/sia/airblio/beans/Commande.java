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

/**
 *
 * @author CedricBm
 */
@Entity
public class Commande {
    @Id
    @GeneratedValue
    private int id;
    private String lieu;
    @Column(name = "denomination_site")
    private String denominationSite;
    private int profondeur;
    @Column(name = "conditions_particulieres")
    private String conditionsParticulieres;
    private String statut;
    private double latitude;
    private double longitude;
    
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
     * @return the lieu
     */
    public String getLieu() {
        return lieu;
    }

    /**
     * @param lieu the lieu to set
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * @return the denominationSite
     */
    public String getDenominationSite() {
        return denominationSite;
    }

    /**
     * @param denominationSite the denominationSite to set
     */
    public void setDenominationSite(String denominationSite) {
        this.denominationSite = denominationSite;
    }

    /**
     * @return the profondeur
     */
    public int getProfondeur() {
        return profondeur;
    }

    /**
     * @param profondeur the profondeur to set
     */
    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    /**
     * @return the conditionsParticulieres
     */
    public String getConditionsParticulieres() {
        return conditionsParticulieres;
    }

    /**
     * @param conditionsParticulieres the conditionsParticulieres to set
     */
    public void setConditionsParticulieres(String conditionsParticulieres) {
        this.conditionsParticulieres = conditionsParticulieres;
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
