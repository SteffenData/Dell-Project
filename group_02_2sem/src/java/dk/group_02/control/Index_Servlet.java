/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.control;

import dk.group_02.Entity.Partner;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author steffen
 */
@WebServlet(name = "Index_Servlet", urlPatterns = {"/Index_Servlet"})
public class Index_Servlet extends ManagerServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Partner partner = null;
            String inSwitch = request.getParameter("hej");
            switch (inSwitch) {
                case "ElgigantDk":
                    partner = new Partner("Elgiganten", "Denmark");
                    break;
                case "ElgigantNor":
                    partner = new Partner("Elgiganten", "Norway");
                    break;
                case "WuptiDk": 
                    partner = new Partner("Wupti","Denmark");
                    break;
                case "WuptiNor":
                    partner = new Partner("Wupti","Norway");
                    break;
                case "KomplettDk":
                    partner = new Partner("Komplett","Denmark");
                    break;
                case "KomplettNor":
                    partner = new Partner("Komplett","Norway");
                    break;
                case "Dell":
                    request.setAttribute("projects",getDataValidator().getDellProjects());
                    request.getRequestDispatcher("view_project.jsp").forward(request, response);
                    break;
            }
            request.setAttribute("projects",getDataValidator().getPartnerProjects(partner));
            request.getRequestDispatcher("view_project.jsp").forward(request, response);
        } catch (SQLException e) {
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
            throws ServletException, IOException {
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
            throws ServletException, IOException {
        processRequest(request, response);
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

}
