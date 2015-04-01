/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.view;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.data.DataManager;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author steffen
 */
@WebServlet(name = "Create_Project_Servlet", urlPatterns = {"/Create_Project_Servlet"})
public class Create_Project_Servlet extends HttpServlet {

        
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        //The cost is not controlled as any negative value means that Dell is being paid money (which is nice). --- cost may have to be limited relative to the budget of Dell ----
    public static boolean makeProject(String startDate, String id, String projectName, double cost, String status, String description, Partner partner, String goal) throws ClassNotFoundException, SQLException
    {   
        if(startDate == null || id == null || projectName == null || description == null || goal == null || partner == null)
        {
            return false;
        }
        Project project = new Project(startDate, id,projectName,cost,status,description,partner,goal);
        DataManager.SaveProject(project);
            return true;
    }
    
    public Project viewProject(String id)
    {
        return null;
    }
    // vi overloader make project med et ekstra parameter(file)
     public static boolean makeProject(String startDate, String id, String projectName, double cost, String status, String description,Partner partner, File upload, String goal)
    {   
        if(startDate == null || id == null || projectName == null || description == null || goal == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
      
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
