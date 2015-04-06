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
            Query query = session.createQuery("from utilisateur u where u.email = :email");
            query.setString("email", getValeurChamp(request, "email"));
            Iterator users = query.iterate();
            if (users.hasNext()) {
                user = (Utilisateur) users.next();
            }
        } finally {
            session.close();
        }

        return user;
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
