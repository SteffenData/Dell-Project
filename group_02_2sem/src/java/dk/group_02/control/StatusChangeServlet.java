/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.control;

import dk.group_02.Entity.Project;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pagh
 */
@WebServlet(name = "StatusChangeServlet", urlPatterns =
{
    "/StatusChangeServlet"
})
public class StatusChangeServlet extends ManagerServlet
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
        String statusValue = request.getParameter("statusBox");
        // int statusValue = Integer.parseInt(request.getAttribute("statusBox"));

        HttpSession s = request.getSession();

        if (statusValue.equalsIgnoreCase("0"))
        {
            Double cost = (Double) s.getAttribute("cost");
            String projectName = (String) s.getAttribute("projectName");
            String startDate = (String) s.getAttribute("startDate");
            try
            {
                Project project = getController().getProject(startDate, projectName, cost.doubleValue());
                getController().rejectProject(project);
            } catch (SQLException e)
            {
            }
            RequestDispatcher rd = request.getRequestDispatcher("viewProjectDell.jsp");
            rd.forward(request, response);
        }

        if (statusValue.equalsIgnoreCase("1"))
        {
            Double cost = (Double) s.getAttribute("cost");
            String projectName = (String) s.getAttribute("projectName");
            String startDate = (String) s.getAttribute("startDate");
            try
            {
                Project project = getController().getProject(startDate, projectName, cost.doubleValue());
                getController().approveProject(project);
            } catch (SQLException e)
            {
            }
            RequestDispatcher rd = request.getRequestDispatcher("viewProjectDell.jsp");
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
