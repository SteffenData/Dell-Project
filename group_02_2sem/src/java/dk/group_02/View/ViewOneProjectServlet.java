/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */
package dk.group_02.View;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.utility.DatabaseException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "View_Single_Project_Servlet", urlPatterns
        = {
            "/View_Single_Project_Servlet"
        })
public class ViewOneProjectServlet extends ManagerServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            Project project = getController(request).getProject(projectId);
            request.setAttribute("project", project);
        } catch (DatabaseException ex) {
            Partner partner = (Partner) request.getSession().getAttribute("partner");
            if (partner != null) {
                request.setAttribute("MSG", ex.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("viewProjectPartner.jsp");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("viewProjectDell.jsp");
                rd.forward(request, response);
            }
        }
        Partner partner = (Partner) request.getSession().getAttribute("partner");
        if (partner != null) {
            RequestDispatcher rd = request.getRequestDispatcher("viewOneProjectPartner.jsp");
            rd.forward(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("viewOneProjectDell.jsp");
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