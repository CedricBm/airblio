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
import javax.servlet.http.HttpSession;
import sia.airblio.beans.Utilisateur;
import sia.airblio.forms.AuthentificationForm;

/**
 *
 * @author CedricBm
 */
@WebServlet("/accueil")
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
        HttpSession session = request.getSession();
        
        Utilisateur user = form.authentificate(request);
        session.setAttribute("user", user);
        if (user == null) {
            request.setAttribute("erreur", "La connection a échoué!");
            this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
        } else {
            response.sendRedirect("/airblio/member/mappemonde");
        }
    }
}
