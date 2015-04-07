/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.forms;

import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import sia.airblio.beans.Commande;
import sia.airblio.beans.HibernateUtil;
import sia.airblio.beans.MissionIntervention;

/**
 *
 * @author Superced
 */
public class MissionInterventionForm {
    
    public MissionIntervention getMissionIntervention(HttpServletRequest request) {
        MissionIntervention mission = new MissionIntervention();
        Commande commande;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        commande = (Commande) session.get(Commande.class, Integer.parseInt(getValeurChamp(request, "commande")));
        mission.setLieuIntervention(commande.getLieu());
        mission.setLatitude(commande.getLatitude());
        mission.setLongitude(commande.getLongitude());
        mission.setIntituleIntervention(getValeurChamp(request, "intitule"));
        mission.setDateDebut(commande.getDebut());
        mission.setDateFin(commande.getFin());
        mission.setVolumeHoraireTotal(Double.parseDouble(getValeurChamp(request, "volume")));
        mission.setPrixTotalTTC(Double.parseDouble(getValeurChamp(request, "prix")));
        mission.setTva(Double.parseDouble(getValeurChamp(request, "tva")));
        mission.setDetail(getValeurChamp(request, "detail"));
        mission.setLieuDepartEquipe(getValeurChamp(request, "lieu_depart"));
        mission.setProcedureMission(getValeurChamp(request, "procedure"));
        mission.setConditionParticuliere(commande.getConditionsParticulieres());
        mission.setCommande(commande);
        mission.setNbHeure(Integer.parseInt(getValeurChamp(request, "nb_heure")));
        mission.setNbJour(Integer.parseInt(getValeurChamp(request, "nb_jour")));
        
        return mission;
    }
    
    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
