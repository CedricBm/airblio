/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia.airblio.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
/**
 *
 * @author Skulldy
 */
@WebServlet(name = "MapEquipeTechnique", urlPatterns = {"/member/MapEquipeTechnique"})
public class MapEquipeTechnique extends HttpServlet {
    String markerText;
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        String markerID = request.getParameter("markerID");
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String markerText = getInfo(markerID);
        out.println(markerText);
        out.close();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
       //Get Country Information
    private String getInfo(String markerID) {
        String markerText = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = null;

        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            conn = ((DataSource) ctx.lookup("jdbc/mysql")).getConnection();

            sql = "Select nom from equipe_technique where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, markerID.trim());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                markerText = (rs.getString("nom").trim());
            }

            rs.close();
            stmt.close();
            stmt = null;

            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println(e);
            markerText = e.toString();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlex) {
                    // ignore -- as we can't do anything about it here           
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqlex) {
                    // ignore -- as we can't do anything about it here     
                }
                conn = null;
            }
        }
        //markerText = sql;
        return markerText;
    }

}
