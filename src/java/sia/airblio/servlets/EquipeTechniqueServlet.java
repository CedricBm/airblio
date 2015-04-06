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
import sia.airblio.beans.EquipeTechnique;
import sia.airblio.beans.HibernateUtil;
import sia.airblio.beans.Technicien;
import sia.airblio.forms.EquipeTechniqueForm;

/**
 *
 * @author Superced
 */
@WebServlet(urlPatterns = {"/member/equipeTechnique"})
public class EquipeTechniqueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/equipeTechniqueForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EquipeTechniqueForm form = new EquipeTechniqueForm();

        EquipeTechnique equipe = form.getEquipeTechnique(request);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(equipe);
        session.getTransaction().commit();
        Set<Technicien> techniciens = equipe.getTechniciens();
        session.beginTransaction();
        for (Technicien tech : techniciens) {
            tech.setEquipeTechnique(equipe);
            session.update(tech);
        }
        session.getTransaction().commit();
        session.close();

        this.getServletContext().getRequestDispatcher("/WEB-INF/equipeTechniqueForm.jsp").forward(request, response);
    }
}
