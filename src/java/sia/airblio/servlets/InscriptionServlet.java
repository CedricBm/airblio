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
import sia.airblio.beans.HibernateUtil;

import sia.airblio.beans.Utilisateur;
import sia.airblio.forms.InscriptionForm;

/**
 *
 * @author Superced
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/inscriptionForm.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InscriptionForm form = new InscriptionForm();

        Utilisateur utilisateur = form.getUtilisateur(request);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(utilisateur);
        session.getTransaction().commit();
        session.close();
        
        response.sendRedirect("/");
    }
}
