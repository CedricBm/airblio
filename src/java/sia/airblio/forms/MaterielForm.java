/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.forms;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import sia.airblio.beans.HibernateUtil;
import sia.airblio.beans.Materiel;
import sia.airblio.beans.SiteStockage;
import sia.airblio.beans.Technicien;

/**
 *
 * @author Superced
 */
public class MaterielForm {

    public Materiel getMateriel(HttpServletRequest request) {
        Calendar cal = Calendar.getInstance();
        Materiel materiel = new Materiel();
        materiel.setNom(getValeurChamp(request, "nom"));
        materiel.setDescription(getValeurChamp(request, "description"));
        materiel.setCoutLocation(Integer.parseInt(getValeurChamp(request, "cout_location")));
        materiel.setCoutExpedition(Integer.parseInt(getValeurChamp(request, "cout_expedition")));
        materiel.setDateDerniereInspection(cal.getTime());
        cal.add(Calendar.YEAR, 7);
        materiel.setDateFinValidite(cal.getTime());
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        materiel.setSiteStockage((SiteStockage) session.get(SiteStockage.class, Integer.parseInt(getValeurChamp(request, "site_stockage"))));
        materiel.setEnTransit(false);
        session.close();

        return materiel;
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
