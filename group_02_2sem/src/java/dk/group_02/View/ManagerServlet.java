/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author steffen
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
