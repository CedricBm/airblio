/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.forms;

import javax.servlet.http.HttpServletRequest;
import sia.airblio.beans.Utilisateur;

/**
 *
 * @author Superced
 */
public class InscriptionForm {

    public Utilisateur getUtilisateur(HttpServletRequest request) {
        Utilisateur user = new Utilisateur();

        user.setEmail(getValeurChamp(request, "email"));
        user.setNom(getValeurChamp(request, "nom"));
        user.setPrenom(getValeurChamp(request, "prenom"));
        user.setMotDePasse(new String(encrypt(getValeurChamp(request, "password"))));

        return user;
    }

    public static byte[] encrypt(String x) {
        try {
            java.security.MessageDigest d = null;
            d = java.security.MessageDigest.getInstance("SHA-1");
            d.reset();
            d.update(x.getBytes());
            return d.digest();
        } catch (Throwable ex) {
            System.err.println("Encryption failed. " + ex);
        }
        return null;
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
