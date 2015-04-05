/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import sia.airblio.beans.CommandeStatut;
import sia.airblio.beans.HibernateUtil;
import sia.airblio.forms.CommandeStatutForm;

/**
 *
 * @author Superced
 */
@WebServlet(urlPatterns = {"/commandeStatut"})
public class CommandeStatutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/commandeStatutForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CommandeStatutForm form = new CommandeStatutForm();
        CommandeStatut statut = form.getCommandeStatut(request);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(statut);
        session.getTransaction().commit();
        session.close();
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/commandeStatutForm.jsp").forward(request, response);
    }

}
