/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */
package dk.group_02.View;

import dk.group_02.Entity.Project;
import dk.group_02.utility.DatabaseException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StatusChangeServlet", urlPatterns
        = {
            "/StatusChangeServlet"
        })
public class StatusChangeServlet extends ManagerServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        try {

            response.setContentType("text/html;charset=UTF-8");
            String statusValue = request.getParameter("statusBox");

            if (statusValue.equalsIgnoreCase("0")) {

                int projectId = Integer.parseInt(request.getParameter("projectId"));

                try {
                    Project project = getController(request).getProject(projectId);

                    project.setStatusDescription(request.getParameter("statusDescription"));
                    getController(request).rejectStatus(project);
                    request.setAttribute("projects", getController(request).getDellProjects());
                } catch (SQLException e) {
                }
                RequestDispatcher rd = request.getRequestDispatcher("viewProjectDell.jsp");
                rd.forward(request, response);
            }

            if (statusValue.equalsIgnoreCase("1")) {
                int projectId = Integer.parseInt(request.getParameter("projectId"));

                try {
                    Project project = getController(request).getProject(projectId);
                    project.setStatusDescription(request.getParameter("statusDescription"));
                    getController(request).approveStatus(project);
                    request.setAttribute("projects", getController(request).getDellProjects());
                } catch (DatabaseException ex) {
                    request.setAttribute("message", "No connection to the database, please try again later or contact admin");
                     RequestDispatcher rd = request.getRequestDispatcher("viewOneProjectDell.jsp");
                     rd.forward(request, response);
                    
                }
                RequestDispatcher rd = request.getRequestDispatcher("viewProjectDell.jsp");
                rd.forward(request, response);
            }
//        } catch (Exception e) {
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.print("<h2>" + e + "</h2> <hr/> <pre>");
//            e.printStackTrace(out);
//            out.println("</pre>");
//        }
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
