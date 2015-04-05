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
import sia.airblio.beans.HibernateUtil;
import sia.airblio.beans.Materiel;
import sia.airblio.beans.MissionIntervention;
import sia.airblio.beans.NbHeuresLoues;
import sia.airblio.beans.NbJoursLoues;
import sia.airblio.beans.Technicien;
import sia.airblio.forms.MissionInterventionForm;

/**
 *
 * @author Superced
 */
@WebServlet(name = "MissionInterventionServlet", urlPatterns = {"/missionIntervention"})
public class MissionInterventionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/missionInterventionForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MissionInterventionForm form = new MissionInterventionForm();

        MissionIntervention mission = form.getMissionIntervention(request);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(mission);
        session.getTransaction().commit();
        session.beginTransaction();
        for (Technicien tech : mission.getCommande().getEquipeTechnique().getTechniciens()) {
            NbHeuresLoues h = new NbHeuresLoues();
            h.setNbHeures(mission.getNbHeure());
            h.setPrixParHeures(tech.getPrixParHeure());
            h.setStatut("prevue");
            h.setTechnicien(tech);
            h.setMissionIntervention(mission);
            session.save(h);
        }

        for (Materiel mat : mission.getCommande().getMateriaux()) {
            NbJoursLoues n = new NbJoursLoues();
            n.setNbJours(mission.getNbJour());
            n.setPrixParJours(mat.getCoutLocation());
            n.setMateriel(mat);
            n.setMaterielFixed(mat.toString());
            n.setStatut("prevue");
            n.setMissionIntervention(mission);
            session.save(n);
        }
        session.getTransaction().commit();
        session.close();

        this.getServletContext().getRequestDispatcher("/WEB-INF/missionInterventionForm.jsp").forward(request, response);
    }
}
