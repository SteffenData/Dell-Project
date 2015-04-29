    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.control;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Poe;
import dk.group_02.Entity.Project;
import dk.group_02.control.Manager;
import dk.group_02.data.DataManager;
import dk.group_02.utility.DatabaseException;
import dk.group_02.utility.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author steffen
 */
public class Controller {

    Manager manager;
    Validator validator;

    public Controller() {
        this.manager = new DataManager();
        this.validator = new Validator();
    }

    //The cost is not controlled as any negative value means that Dell is being paid money (which is nice). --- cost may have to be limited relative to the budget of Dell ----
    public boolean saveProject(String startDate, String projectName, Double cost, String status, String description, Partner partner, String goal) throws DatabaseException {
        if (startDate == null || projectName == null || cost == null || description == null || goal == null || partner == null || status == null) {
            return false;
        }
        if (validator.validateProjectInfo(projectName, cost, status, description, goal)) {
            Project project = new Project(0, startDate, projectName, cost, status, description, goal, partner);
            manager.SaveProject(project);
            return true;
        }
        return false;
    }

    public Collection<Project> getDellProjects() throws DatabaseException {

        Collection<Project> outDell = manager.getDellProjects();

        return outDell;
    }

    public Collection<Project> getPartnerProjects(Partner partner) throws DatabaseException {

        Collection<Project> outPartner = manager.getPartnerProjects(partner);

        return outPartner;
    }

    public Project getProject(int projectId) throws DatabaseException {
        Project outproject = manager.getProject(projectId);
        return outproject;

    }

//    public Project getSameProject(Project project) throws SQLException{
//       
//        Project sameProject = manager.getSameProject(project);
//        return sameProject;
//    }
    public boolean getLogin(String usrName, String password) throws DatabaseException {
        if (usrName.isEmpty() || password.isEmpty()) {
            return false;
        }
        if (usrName == null || password == null) {
            return false;
        }
        return manager.getLogin(usrName, password);
    }

    public Partner getPartnerByUserName(String userName) throws DatabaseException {
        Partner partner = manager.getPartnerByUserName(userName);
        return partner;
    }

    public void approveProject(Project project) throws DatabaseException {

        manager.approveProject(project);
    }

    public void rejectProject(Project project) throws DatabaseException {

        manager.rejectProject(project);
    }
    
    
    public Poe getPOE(int projectId) throws DatabaseException
    {
        return manager.getPOE(projectId);
    }

}
