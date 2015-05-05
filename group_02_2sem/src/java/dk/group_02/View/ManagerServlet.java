/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 * Dette er en abstract klasse som ALLE vores servlets arver fra (i stedet for at arve fra HttpServlet som de plejer, det klarer denne klasse i stedet). Denne løsning er lavet for at undgå for meget boilerplate code
 */
package dk.group_02.View;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import dk.group_02.control.Controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public abstract class ManagerServlet extends HttpServlet {
    private Controller ctrl;

    /**
     *
     * @return
     */
//    @Override
//    public void init() throws ServletException {
//        super.init(); 
//
//        ServletContext application = getServletContext();
//        ctrl = (Controller) application.getAttribute("Controller");
//        if (ctrl == null) {
//             Start ny session
//            ctrl = new Controller();
//            application.setAttribute("Controller", ctrl);
//            
//        }
//    }
    
    protected Controller getController(HttpServletRequest request) {
          
        
        HttpSession session = request.getSession(true);
        ctrl = (Controller) session.getAttribute("Session");
        
        if(ctrl == null){
        ctrl = new Controller();
        session.setAttribute("Session", ctrl);
        }
        
        return ctrl;
    }
    
  

}
