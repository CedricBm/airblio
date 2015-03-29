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
 * @author Superced
 */
@WebServlet("/login")
public class Authentification extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        this.getServletContext().getRequestDispatcher("/WEB-INF/authentification.jsp").forward(request, response);
    }

//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        /* Préparation de l'objet formulaire */
//        AuthentificationForm form = new AuthentificationForm();
//
//        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
//        Utilisateur utilisateur = form.authentificate(request);
//
//        /* Stockage du formulaire et du bean dans l'objet request */
//        request.setAttribute(ATT_FORM, form);
//        request.setAttribute(ATT_USER, utilisateur);
//
//        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
//    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
