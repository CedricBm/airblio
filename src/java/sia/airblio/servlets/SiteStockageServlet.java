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
import sia.airblio.beans.SiteStockage;
import sia.airblio.forms.SiteStockageForm;

/**
 *
 * @author Superced
 */
@WebServlet(urlPatterns = {"/member/siteStockage"})
public class SiteStockageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/siteStockageForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SiteStockageForm form = new SiteStockageForm();
        SiteStockage site = form.getSiteStockage(request);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(site);
        session.getTransaction().commit();
        session.close();
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/siteStockageForm.jsp").forward(request, response);
    }

}
