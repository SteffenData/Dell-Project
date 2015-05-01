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
import javax.servlet.http.HttpSession;

@WebServlet(name = "Index_Servlet", urlPatterns = {"/Index_Servlet"})
public class IndexServlet extends ManagerServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Partner partner = null;

        try {
            if (getController().getLogin(username, password)) {
                partner = getController().getPartnerByUsername(username);

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
        } catch (DatabaseException ex) {
            request.setAttribute("message", "No connection to the database, please try again later or contact admin");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
