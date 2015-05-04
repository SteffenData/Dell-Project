/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 * Dette er en abstract klasse som ALLE vores servlets arver fra (i stedet for at arve fra HttpServlet som de plejer, det klarer denne klasse i stedet). Denne løsning er lavet for at undgå for meget boilerplate code
 */
package dk.group_02.View;
import dk.group_02.control.Controller;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class ManagerServlet extends HttpServlet {
    private Controller ctrl;
    @Override
    public void init() throws ServletException {
        super.init(); 

        ServletContext application = getServletContext();
        ctrl = (Controller) application.getAttribute("validator");
        if (ctrl == null) {
            // Start ny session
            ctrl = new Controller();
            application.setAttribute("validator", ctrl);
        }
    }
    
    protected Controller getController() {
        return ctrl;
    }

}
