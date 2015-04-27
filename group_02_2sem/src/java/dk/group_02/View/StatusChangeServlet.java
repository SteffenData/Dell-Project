/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.View;

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
@WebServlet(name = "StatusChangeServlet", urlPatterns
        = {
            "/StatusChangeServlet"
        })
public class StatusChangeServlet extends ManagerServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

  response.setContentType("text/html;charset=UTF-8");
        String statusValue = request.getParameter("statusBox");
       
        // int statusValue = Integer.parseInt(request.getAttribute("statusBox"));

        

        if (statusValue.equalsIgnoreCase("0")) {
           
            int projectId = Integer.parseInt(request.getParameter("projectId"));
          
            try {
                Project project = getController().getProject(projectId);
                String hej = request.getParameter("statusDescription");

                project.setRetard(request.getParameter("statusDescription"));
                System.out.println("hej" + hej);
                System.out.println(project.getRetard());
                getController().rejectProject(project);
                request.setAttribute("projects", getController().getDellProjects());
            } catch (SQLException e) {
            }
            RequestDispatcher rd = request.getRequestDispatcher("viewProjectDell.jsp");
            rd.forward(request, response);
        }

        if (statusValue.equalsIgnoreCase("1")) {
            int projectId = Integer.parseInt(request.getParameter("projectId"));
         
            try {
                Project project = getController().getProject(projectId);
                project.setRetard(request.getParameter("statusDescription"));
                getController().approveProject(project);
                request.setAttribute("projects", getController().getDellProjects());
            } catch (SQLException e) {
            }
            RequestDispatcher rd = request.getRequestDispatcher("viewProjectDell.jsp");
            rd.forward(request, response);
        }  
        } catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("<h2>"+ e + "</h2> <hr/> <pre>" );
            e.printStackTrace(out);
            out.println("</pre>");
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
