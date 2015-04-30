/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */
package dk.group_02.View;

import dk.group_02.control.Controller;
import dk.group_02.data.DataManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Dette er en abstract klasse som ALLE vores servlets arver fra (i stedet for at arve fra HttpServlet som de plejer, det klarer denne klasse i stedet). Denne løsning er lavet for at undgå for meget boilerplate code
 */
public abstract class ManagerServlet extends HttpServlet {
    private Controller ctrl;
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        ServletContext application = getServletContext();
        ctrl = (Controller) application.getAttribute("validator");
        if (ctrl == null) {
            // Start new session
            ctrl = new Controller();
            application.setAttribute("validator", ctrl);
        }
    }
    
    protected Controller getController() {
        return ctrl;
    }

}
