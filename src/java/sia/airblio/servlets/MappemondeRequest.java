/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.json.simple.JSONObject;
import sia.airblio.beans.EquipeTechnique;
import sia.airblio.beans.HibernateUtil;
/**
 *
 * @author Skulldy
 */
@WebServlet(urlPatterns = {"/member/mappemondeRequest"})
public class MappemondeRequest extends HttpServlet {
    JSONObject json = new JSONObject();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.sendRedirect("/airblio/accueil");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String markerID = request.getParameter("markerID");
        
        PrintWriter out = response.getWriter();
        getInfo(markerID);
        out.println(json);
        out.close();
    }

    private void getInfo(String markerID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        EquipeTechnique equipe = (EquipeTechnique) session.get(EquipeTechnique.class, 5);
        session.close();
        json.put(equipe.getId(), equipe.getNom());
        json.put("success", true);
    }

}
