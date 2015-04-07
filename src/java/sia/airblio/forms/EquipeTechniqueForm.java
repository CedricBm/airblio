/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.forms;

import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import sia.airblio.beans.EquipeTechnique;
import sia.airblio.beans.HibernateUtil;
import sia.airblio.beans.Technicien;

/**
 *
 * @author Superced
 */
public class EquipeTechniqueForm {

    public EquipeTechnique getEquipeTechnique(HttpServletRequest request) {
        EquipeTechnique equipe = new EquipeTechnique();
        equipe.setNom(getValeurChamp(request, "nom"));
        equipe.setLatitude(Double.parseDouble(getValeurChamp(request, "latitude")));
        equipe.setLongitude(Double.parseDouble(getValeurChamp(request, "longitude")));
        equipe.setEnTransit(false);
        Set<Technicien> techniciens = new HashSet<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        techniciens.add((Technicien) session.get(Technicien.class, Integer.parseInt(getValeurChamp(request, "technicien1"))));
        techniciens.add((Technicien) session.get(Technicien.class, Integer.parseInt(getValeurChamp(request, "technicien2"))));
        techniciens.add((Technicien) session.get(Technicien.class, Integer.parseInt(getValeurChamp(request, "technicien3"))));
        techniciens.add((Technicien) session.get(Technicien.class, Integer.parseInt(getValeurChamp(request, "technicien4"))));
        techniciens.add((Technicien) session.get(Technicien.class, Integer.parseInt(getValeurChamp(request, "technicien5"))));
        techniciens.add((Technicien) session.get(Technicien.class, Integer.parseInt(getValeurChamp(request, "technicien6"))));
        techniciens.add((Technicien) session.get(Technicien.class, Integer.parseInt(getValeurChamp(request, "technicien7"))));
        techniciens.add((Technicien) session.get(Technicien.class, Integer.parseInt(getValeurChamp(request, "technicien8"))));
        equipe.setTechniciens(techniciens);
        session.close();

        return equipe;
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