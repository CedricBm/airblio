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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author CedricBm
 */
@Entity
public class Commande implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String lieu;
    @Column(name = "denomination_site")
    private String denominationSite;
    private int profondeur;
    @Column(name = "conditions_particulieres")
    private String conditionsParticulieres;
    private double latitude;
    private double longitude;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date debut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin;
    @Column(name = "materiaux_fixed")
    private String materiauxFixed;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "statut_id")
    private CommandeStatut statut;

    @OneToMany(mappedBy = "commande")
    private Set<Materiel> materiaux;

    @ManyToOne
    @JoinColumn(name = "equipe_technique_id")
    private EquipeTechnique equipeTechnique;

    @OneToOne(optional = false)
    @JoinColumn(name = "mission_intervention_id", unique = true, nullable = false, updatable = false)
    private MissionIntervention missionIntervention;

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

    /**
     * @return the debut
     */
    public Date getDebut() {
        return debut;
    }

    /**
     * @param debut the debut to set
     */
    public void setDebut(Date debut) {
        this.debut = debut;
    }

    /**
     * @return the fin
     */
    public Date getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(Date fin) {
        this.fin = fin;
    }

    /**
     * @return the materiauxFixed
     */
    public String getMateriauxFixed() {
        return materiauxFixed;
    }

    /**
     * @param materiauxFixed the materiauxFixed to set
     */
    public void setMateriauxFixed(String materiauxFixed) {
        this.materiauxFixed = materiauxFixed;
    }

    /**
     * @return the statut
     */
    public CommandeStatut getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(CommandeStatut statut) {
        this.statut = statut;
    }

    /**
     * @return the materiaux
     */
    public Set<Materiel> getMateriaux() {
        return materiaux;
    }

    /**
     * @param materiaux the materiaux to set
     */
    public void setMateriaux(Set<Materiel> materiaux) {
        this.materiaux = materiaux;
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
     * @return the missionIntervention
     */
    public MissionIntervention getMissionIntervention() {
        return missionIntervention;
    }

    /**
     * @param missionIntervention the missionIntervention to set
     */
    public void setMissionIntervention(MissionIntervention missionIntervention) {
        this.missionIntervention = missionIntervention;
    }
}
