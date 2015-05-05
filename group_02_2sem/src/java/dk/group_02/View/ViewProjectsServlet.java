/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */
package dk.group_02.View;

import dk.group_02.Entity.Partner;
import dk.group_02.utility.DatabaseException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "View_Project_Servlet", urlPatterns
        = {
            "/View_Project_Servlet"
        })
public class ViewProjectsServlet extends ManagerServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Partner partner = (Partner) request.getSession().getAttribute("partner");

        if (partner != null) {
            try {
                request.setAttribute("projects", getController(request).getPartnerProjects(partner));
            } catch (DatabaseException ex) {
                 request.setAttribute("MSG", ex.getMessage());
                 RequestDispatcher rd = request.getRequestDispatcher("viewProjectPartner.jsp");
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("viewProjectPartner.jsp");
            rd.forward(request, response);

        } else {
            try {
                request.setAttribute("projects", getController(request).getDellProjects());
            } catch (DatabaseException ex) {
                 request.setAttribute("MSG", ex.getMessage());
                 RequestDispatcher rd = request.getRequestDispatcher("viewProjectDell.jsp");
            }
            RequestDispatcher rd = request.getRequestDispatcher("viewProjectDell.jsp");
            rd.forward(request, response);
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
