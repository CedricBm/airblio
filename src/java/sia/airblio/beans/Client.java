/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author CedricBm
 */
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String nom;
    private String telephone;
    private String adresse;
    private String email;
    private String reference;
    private String iban;
    private String bic;

    @OneToMany(mappedBy = "client")
    private Set<Commande> commandes;

    @OneToMany(mappedBy = "client")
    private Set<PVReception> pvsReception;

    @OneToMany(mappedBy = "client")
    private Set<Facture> factures;

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
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * @param iban the iban to set
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * @return the bic
     */
    public String getBic() {
        return bic;
    }

    /**
     * @param bic the bic to set
     */
    public void setBic(String bic) {
        this.bic = bic;
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
     * @return the factures
     */
    public Set<Facture> getFactures() {
        return factures;
    }

    /**
     * @param factures the factures to set
     */
    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }

}
