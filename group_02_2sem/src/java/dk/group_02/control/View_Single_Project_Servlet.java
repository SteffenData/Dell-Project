/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.control;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pagh
 */
@WebServlet(name = "View_Single_Project_Servlet", urlPatterns =
{
    "/View_Single_Project_Servlet"
})
public class View_Single_Project_Servlet extends ManagerServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        String startDate = request.getParameter("choice");
        String projectName = request.getParameter("choice1");
        double cost = Double.parseDouble(request.getParameter("choice2"));
        String status = request.getParameter("choice3");
        String description = request.getParameter("choice4");
        String goal = request.getParameter("choice5");
        String partnerName = request.getParameter("choice6");

        HttpSession s = request.getSession();
        request.setAttribute("startDate", startDate);
        request.setAttribute("projectName", projectName);
        request.setAttribute("cost", cost);
        request.setAttribute("status", status);
        request.setAttribute("description", description);
        request.setAttribute("goal", goal);
        request.setAttribute("partnerName", partnerName);

        s.setAttribute("startDate", startDate);
        s.setAttribute("projectName", projectName);
        s.setAttribute("cost", cost);

        Partner partner = (Partner) request.getSession().getAttribute("partner");

        if (partner != null)
        {
//            try {
//                request.setAttribute("projects", getController().getPartnerProjects(partner));
//            } catch (SQLException ex) {
//                Logger.getLogger(View_Projects_Servlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
            RequestDispatcher rd = request.getRequestDispatcher("viewOneProjectPartner.jsp");
            rd.forward(request, response);

        } else
        {
//            try {
//                request.setAttribute("projects", getController().getDellProjects());
//            } catch (SQLException ex) {
//                Logger.getLogger(View_Projects_Servlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
            RequestDispatcher rd = request.getRequestDispatcher("viewOneProjectDell.jsp");
            rd.forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            throws ServletException, IOException
    {
        processRequest(request, response);
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
