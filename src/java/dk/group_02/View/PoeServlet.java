package dk.group_02.View;

import dk.group_02.Entity.Poe;
import dk.group_02.utility.DatabaseException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pagh
 */
@WebServlet(name = "PoeServlet", urlPatterns
        = {
            "/PoeServlet"
        })
public class PoeServlet extends ManagerServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int projectId = Integer.parseInt(request.getParameter("projectId"));
            Poe poe = getController().getPOE(projectId);
// broweseren kommer med en gem fil som dialog ved contenttype application/octet-stream
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", poe.getFilename()));
            
            OutputStream out = response.getOutputStream();
            // Copy the contents of the file to the output stream
             
            out.write(poe.getBuffer());
            out.close();
        } catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("<h2>" + e + "</h2> <hr/> <pre>");
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
