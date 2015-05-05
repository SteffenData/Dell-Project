/**
 *
 * @author steffen/Kasper/Pelle/Mikkel/Bente
 */
package dk.group_02.View;

import dk.group_02.Entity.Poe;
import dk.group_02.Entity.Project;
import dk.group_02.utility.DatabaseException;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet(name = "PoeServlet", urlPatterns
        =
        {
            "/PoeServlet"
        })

@MultipartConfig
public class PoeServlet extends ManagerServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            HttpSession s = request.getSession();
            
            if (s.getAttribute("partner") == null)
            {
                int projectId = Integer.parseInt(request.getParameter("projectId"));
                Poe poe = getController(request).getPOE(projectId);
                // broweseren kommer med en gem fil som dialog ved contenttype application/octet-stream
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", poe.getFilename()));

                OutputStream out = response.getOutputStream();
                //Skriver indeholdet af array'en til streamen  
                out.write(poe.getBuffer());
                out.close();
                RequestDispatcher rd = request.getRequestDispatcher("viewProjectDell.jsp");
                rd.forward(request, response);
            }
            if (s.getAttribute("partner") != null)
            {
                try {
                    
                
                int projectId = Integer.parseInt(request.getParameter("projectId"));
                Project p = getController(request).getProject(projectId);
                Part part = request.getPart("poe");
                getController(request).approveStatus(p);
                getController(request).savePOE(part.getInputStream(), projectId, part.getSubmittedFileName());
                } 
                
                catch (DatabaseException e) 
                {
                request.setAttribute("MSG_NO", "Your file has not been saved");    
                RequestDispatcher rd = request.getRequestDispatcher("viewOneProjectPartner.jsp");
                rd.forward(request, response); 
                }
               request.setAttribute("MSG_YES", "Your file has been saved!");
                RequestDispatcher rd = request.getRequestDispatcher("viewOneProjectPartner.jsp");
                rd.forward(request, response);
                
            }
        } catch (NumberFormatException | IOException | DatabaseException e)
        {  }
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}