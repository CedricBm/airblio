/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.servlets;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import sia.airblio.beans.Commande;
import sia.airblio.beans.EquipeTechnique;
import sia.airblio.beans.HibernateUtil;
import sia.airblio.beans.Materiel;
import sia.airblio.forms.CommandeForm;

/**
 *
 * @author Superced
 */
@WebServlet(urlPatterns = {"/commande"})
public class CommandeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/commandeForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CommandeForm form = new CommandeForm();

        Commande commande = form.getCommande(request);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(commande);
        session.getTransaction().commit();
        Set<Materiel> materiaux = commande.getMateriaux();
        session.beginTransaction();
        for (Materiel mat : materiaux) {
            mat.setCommande(commande);
            mat.setSiteStockage(null);
            session.update(mat);
        }
        EquipeTechnique equipe = commande.getEquipeTechnique();
        equipe.setLatitude(commande.getLatitude());
        equipe.setLongitude(commande.getLongitude());
        session.update(equipe);
        session.getTransaction().commit();
        session.close();
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/commandeForm.jsp").forward(request, response);
    }

}
