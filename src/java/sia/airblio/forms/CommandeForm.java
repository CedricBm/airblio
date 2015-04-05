/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import sia.airblio.beans.Client;
import sia.airblio.beans.Commande;
import sia.airblio.beans.CommandeStatut;
import sia.airblio.beans.EquipeTechnique;
import sia.airblio.beans.HibernateUtil;
import sia.airblio.beans.Materiel;
import sia.airblio.beans.MissionIntervention;

/**
 *
 * @author Superced
 */
public class CommandeForm {

    public Commande getCommande(HttpServletRequest request) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Commande commande = new Commande();
        commande.setLieu(getValeurChamp(request, "lieu"));
        commande.setDenominationSite(getValeurChamp(request, "denomination"));
        commande.setProfondeur(Integer.parseInt(getValeurChamp(request, "profondeur")));
        commande.setConditionsParticulieres(getValeurChamp(request, "conditions_particulieres"));
        commande.setLatitude(Double.parseDouble(getValeurChamp(request, "latitude")));
        commande.setLongitude(Double.parseDouble(getValeurChamp(request, "longitude")));
        try {
            commande.setDebut(df.parse(getValeurChamp(request, "debut")));
            commande.setFin(df.parse(getValeurChamp(request, "fin")));
        } catch (ParseException ex) {
            Logger.getLogger(CommandeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        commande.setClient((Client) session.get(Client.class, Integer.parseInt(getValeurChamp(request, "client"))));
        commande.setStatut((CommandeStatut) session.get(CommandeStatut.class, Integer.parseInt(getValeurChamp(request, "statut"))));
        commande.setEquipeTechnique((EquipeTechnique) session.get(EquipeTechnique.class, Integer.parseInt(getValeurChamp(request, "equipe"))));
        Set<Materiel> materiaux = new HashSet<>();
        materiaux.add((Materiel) session.get(Materiel.class, Integer.parseInt(getValeurChamp(request, "materiel1"))));
        materiaux.add((Materiel) session.get(Materiel.class, Integer.parseInt(getValeurChamp(request, "materiel2"))));
        materiaux.add((Materiel) session.get(Materiel.class, Integer.parseInt(getValeurChamp(request, "materiel3"))));
        materiaux.add((Materiel) session.get(Materiel.class, Integer.parseInt(getValeurChamp(request, "materiel4"))));
        materiaux.add((Materiel) session.get(Materiel.class, Integer.parseInt(getValeurChamp(request, "materiel5"))));
        materiaux.add((Materiel) session.get(Materiel.class, Integer.parseInt(getValeurChamp(request, "materiel6"))));
        materiaux.add((Materiel) session.get(Materiel.class, Integer.parseInt(getValeurChamp(request, "materiel7"))));
        materiaux.add((Materiel) session.get(Materiel.class, Integer.parseInt(getValeurChamp(request, "materiel8"))));
        commande.setMateriaux(materiaux);
        commande.setMateriauxFixed(materiaux.toString());
        session.close();
        
        MissionIntervention mission = new MissionIntervention();
        mission.setCommande(commande);

        return commande;
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
