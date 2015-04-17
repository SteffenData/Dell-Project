/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.control;

import dk.group_02.Entity.Partner;
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
 * @author steffen
 */
@WebServlet(name = "Index_Servlet", urlPatterns = {"/Index_Servlet"})
public class Index_Servlet extends ManagerServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Partner partner = null;

        try {
            if (getDataValidator().getLogin(username, password)) {
//              System.out.println("11111" + getDataValidator());
                partner = getDataValidator().getPartner(username);
                System.out.println("$$$$$$$$$  hej ----------$$$$$$$$$$" + partner);
               
                HttpSession s = request.getSession();
                s.setMaxInactiveInterval(60 * 60);

                if (partner != null) {
                    s.setAttribute("partner", partner);
                    RequestDispatcher rd = request.getRequestDispatcher("partnerHome.jsp");
                    rd.forward(request, response);

                } else {
                    s.setAttribute("partner", partner);
                    RequestDispatcher rd = request.getRequestDispatcher("dellHome.jsp");
                    rd.forward(request, response);
                }

            } else {
                request.setAttribute("message", "Incorrect username or password.");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("message", "Incorrect username or password.");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
