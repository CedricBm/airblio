/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.forms;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import sia.airblio.beans.HibernateUtil;
import sia.airblio.beans.Utilisateur;

/**
 *
 * @author Superced
 */
public class AuthentificationForm {

    public Utilisateur authentificate(HttpServletRequest request) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Utilisateur user = null;

        try {
            Query query = session.createQuery("from Utilisateur u where u.email = :email");
            query.setString("email", getValeurChamp(request, "email"));
            String encryptedPassword = new String(encrypt(getValeurChamp(request, "password")));
            Iterator users = query.iterate();
            while (users.hasNext()) {
                Utilisateur userTemp = (Utilisateur) users.next();
                if (userTemp.getMotDePasse().equalsIgnoreCase(encryptedPassword)) {
                    user = userTemp;
                    break;
                }
            }
        } finally {
            session.close();
        }

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
