/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.forms;

import javax.servlet.http.HttpServletRequest;
import sia.airblio.beans.SiteStockage;

/**
 *
 * @author Superced
 */
public class SiteStockageForm {

    public SiteStockage getSiteStockage(HttpServletRequest request) {
        SiteStockage site = new SiteStockage();
        site.setNom(getValeurChamp(request, "nom"));
        site.setAdresse(getValeurChamp(request, "adresse"));

        return site;
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
