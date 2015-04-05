/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author CedricBm
 */
@Entity
public class Materiel implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nom;
    @Column(name = "en_transit")
    private boolean enTransit;
    private String description;
    @Column(name = "cout_location")
    private int coutLocation;
    @Column(name = "cout_expedition")
    private int coutExpedition;
    @Column(name = "date_fin_validite")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinValidite;
    @Column(name = "date_derniere_inspection")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDerniereInspection;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "site_stockage_id")
    private SiteStockage siteStockage;

    @OneToMany(mappedBy = "materiel")
    private Set<HistoriqueDeplacementMateriel> historique;

    @ManyToMany(mappedBy = "materiaux")
    private Set<PVReception> pvsReception = new HashSet<>();

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created = new Date();
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updated = new Date();

    @PreUpdate
    public void setLastUpdate() {
        this.updated = new Date();
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the coutLocation
     */
    public int getCoutLocation() {
        return coutLocation;
    }

    /**
     * @param coutLocation the coutLocation to set
     */
    public void setCoutLocation(int coutLocation) {
        this.coutLocation = coutLocation;
    }

    /**
     * @return the coutExpedition
     */
    public int getCoutExpedition() {
        return coutExpedition;
    }

    /**
     * @param coutExpedition the coutExpedition to set
     */
    public void setCoutExpedition(int coutExpedition) {
        this.coutExpedition = coutExpedition;
    }

    /**
     * @return the dateFinValidite
     */
    public Date getDateFinValidite() {
        return dateFinValidite;
    }

    /**
     * @param dateFinValidite the dateFinValidite to set
     */
    public void setDateFinValidite(Date dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    /**
     * @return the dateDerniereInspection
     */
    public Date getDateDerniereInspection() {
        return dateDerniereInspection;
    }

    /**
     * @param dateDerniereInspection the dateDerniereInspection to set
     */
    public void setDateDerniereInspection(Date dateDerniereInspection) {
        this.dateDerniereInspection = dateDerniereInspection;
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
     * @return the commande
     */
    public Commande getCommande() {
        return commande;
    }

    /**
     * @param commande the commande to set
     */
    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    /**
     * @return the siteStockage
     */
    public SiteStockage getSiteStockage() {
        return siteStockage;
    }

    /**
     * @param siteStockage the siteStockage to set
     */
    public void setSiteStockage(SiteStockage siteStockage) {
        this.siteStockage = siteStockage;
    }

    /**
     * @return the historique
     */
    public Set<HistoriqueDeplacementMateriel> getHistorique() {
        return historique;
    }

    /**
     * @param historique the historique to set
     */
    public void setHistorique(Set<HistoriqueDeplacementMateriel> historique) {
        this.historique = historique;
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

}
