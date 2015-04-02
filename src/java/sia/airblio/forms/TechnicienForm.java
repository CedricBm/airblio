/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.forms;

import javax.servlet.http.HttpServletRequest;
import sia.airblio.beans.Technicien;

/**
 *
 * @author Superced
 */
public class TechnicienForm {

    public Technicien getTechnicien(HttpServletRequest request) {
        Technicien technicien = new Technicien();
        technicien.setNom(getValeurChamp(request, "nom"));
        technicien.setTelephone(getValeurChamp(request, "telephone"));
        technicien.setAdresse(getValeurChamp(request, "adresse"));
        technicien.setEmail(getValeurChamp(request, "email"));
        technicien.setPrenom(getValeurChamp(request, "prenom"));
        technicien.setPrixParHeure(Double.parseDouble(getValeurChamp(request, "prix_par_heure")));
        technicien.setPoste(getValeurChamp(request, "poste"));

        return technicien;
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
