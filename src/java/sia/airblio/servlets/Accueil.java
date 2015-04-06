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
import sia.airblio.beans.Utilisateur;
import sia.airblio.forms.AuthentificationForm;

/**
 *
 * @author CedricBm
 */
@WebServlet("/")
public class Accueil extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthentificationForm form = new AuthentificationForm();
        
        Utilisateur user = form.authentificate(request);
        
        response.sendRedirect("/mappemonde");
    }
}
