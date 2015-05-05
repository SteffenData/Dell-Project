/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */
package dk.group_02.View;

import dk.group_02.Entity.Partner;
import dk.group_02.utility.DatabaseException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Create_Project_Servlet", urlPatterns
        = {
            "/Create_Project_Servlet"
        })
public class CreateProjectServlet extends ManagerServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Partner partner = (Partner) request.getSession().getAttribute("partner");

        String startDate = LocalDate.now().toString();
        String projectName = request.getParameter("projectName");
        Double cost = Double.parseDouble(request.getParameter("cost"));

        String status = "Awaiting approval";
        String description = request.getParameter("description");
        File upload = null;
        String goal = request.getParameter("goal");
      
        try {
            if (getController(request).saveProject(startDate, projectName,
                    cost, status, description, partner,
                    goal)) {
                request.setAttribute("MSG_YES", "Your project has been saved!");
            } else {
                request.setAttribute("MSG_NO", "Please type in the required fields");
            }
            RequestDispatcher rd = request.getRequestDispatcher("createProject.jsp");
            rd.forward(request, response);
        } catch (DatabaseException ex) {
            Logger.getLogger(CreateProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Autogenereret netbeans kode herunder!
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
