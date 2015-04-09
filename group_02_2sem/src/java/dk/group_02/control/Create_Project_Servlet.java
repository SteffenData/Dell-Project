/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.control;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.data.DataManager;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            
        }
        
        response.setContentType("text/html;charset=UTF-8");
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, NullPointerException, SQLException {
       
        //-- Establish or reestablish application context
            Controller con = setApplicationContext(request, response);
        
        // Dette er en dummi partner, idet vi på dette tidspunkt ikke har noget login og man dermed kun kan være en partner.    
        String partnerName = "Dell"; 
        String contry = "Denmark";
        Partner partner = new Partner(partnerName, contry);
        
        LocalDate today = LocalDate.now();
        String startDate = today.toString();
        String projectName = request.getParameter("projetName");
        Double cost = Double.parseDouble(request.getParameter("cost"));
        String status = "awaiting approval";
        String description = request.getParameter("description");
        File upload = null;
        String goal = request.getParameter("goal");
        Project p = new Project(startDate,projectName,cost,status,description,upload,goal);
        
        if (con.projectValidation(p)== true)
        {
        con.SaveProject(p, partner);
        
        
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
      
        }
    }
    private Controller setApplicationContext(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession sessionObj = request.getSession();
        Controller con = (Controller) sessionObj.getAttribute("Controller");
        if (con == null)
        {
            // Start new session
            con = new Controller();
            sessionObj.setAttribute("Controller", con);
        } 
        return con;
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
