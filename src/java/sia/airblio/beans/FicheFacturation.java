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
@Table(name = "fiche_facturation")
public class FicheFacturation {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "lieu_intervention")
    private String lieuIntervention;
    private double latitude;
    private double longitude;
    @Column(name = "intitule_intervention")
    private String intituleIntervention;
    @Column(name = "date_debut")
    private Date dateDebut;
    @Column(name = "date_fin")
    private Date dateFin;
    @Column(name = "volume_horaire_total")
    private double volumeHoraireTotal;
    @Column(name = "prix_total_ttc")
    private double prixTotalTTC;
    private double tva;
    private String detail;
    @Column(name = "lieu_depart_equipe")
    private String lieuDepartEquipe;

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
     * @return the lieuIntervention
     */
    public String getLieuIntervention() {
        return lieuIntervention;
    }

    /**
     * @param lieuIntervention the lieuIntervention to set
     */
    public void setLieuIntervention(String lieuIntervention) {
        this.lieuIntervention = lieuIntervention;
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
     * @return the intituleIntervention
     */
    public String getIntituleIntervention() {
        return intituleIntervention;
    }

    /**
     * @param intituleIntervention the intituleIntervention to set
     */
    public void setIntituleIntervention(String intituleIntervention) {
        this.intituleIntervention = intituleIntervention;
    }

    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return the volumeHoraireTotal
     */
    public double getVolumeHoraireTotal() {
        return volumeHoraireTotal;
    }

    /**
     * @param volumeHoraireTotal the volumeHoraireTotal to set
     */
    public void setVolumeHoraireTotal(double volumeHoraireTotal) {
        this.volumeHoraireTotal = volumeHoraireTotal;
    }

    /**
     * @return the prixTotalTTC
     */
    public double getPrixTotalTTC() {
        return prixTotalTTC;
    }

    /**
     * @param prixTotalTTC the prixTotalTTC to set
     */
    public void setPrixTotalTTC(double prixTotalTTC) {
        this.prixTotalTTC = prixTotalTTC;
    }

    /**
     * @return the tva
     */
    public double getTva() {
        return tva;
    }

    /**
     * @param tva the tva to set
     */
    public void setTva(double tva) {
        this.tva = tva;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return the lieuDepartEquipe
     */
    public String getLieuDepartEquipe() {
        return lieuDepartEquipe;
    }

    /**
     * @param lieuDepartEquipe the lieuDepartEquipe to set
     */
    public void setLieuDepartEquipe(String lieuDepartEquipe) {
        this.lieuDepartEquipe = lieuDepartEquipe;
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
