    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Utility;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.control.Manager;
import dk.group_02.data.DataManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author steffen
 */
public class DataValidator {

    Manager manager;

    public DataValidator() {
        this.manager = new DataManager();
    }

    //The cost is not controlled as any negative value means that Dell is being paid money (which is nice). --- cost may have to be limited relative to the budget of Dell ----
    public boolean saveProject(String startDate, String projectName, Double cost, String status, String description, Partner partner, String goal) {
        if (startDate == null || projectName == null || cost == null || description == null || goal == null || partner == null || status == null) {
            return false;
        }
         if (validateProjectInfo(projectName, cost, status, description, goal)) {
             try {
                    Project project = new Project(startDate, projectName, cost, status, description, goal, partner);
                    manager.SaveProject(project);
                    return true;
                } catch (SQLException ex) {
                }
            }
        return false;
    }

     // Her tjecker vi for om projektet er rigtigt oprettet.
    private boolean validateProjectInfo(String projectName, Double cost, String status, String description, String goal) {

        if (projectName.length() > 30 || status.length() > 30 || cost > 10000000 || description.length() > 250 || goal.length() > 250) {
            return false;
        } else {
            return true;
        }
    }

    public Collection<Project> getDellProjects() throws SQLException {

        Collection<Project> outDell = manager.getDellProjects();

        return outDell;
    }

    public Collection<Project> getPartnerProjects(Partner partner) throws SQLException {

        Collection<Project> outPartner = manager.getPartnerProjects(partner);

        return outPartner;
    }

    public Project getProject(String startDate, String projectName, Double cost) throws SQLException {

        Project outproject = manager.getProject(startDate,projectName,cost);
        return outproject;

    }
    
    public boolean getLogin(String usrName, String password) throws SQLException {
        if(usrName.isEmpty() || password.isEmpty())
            return false;
        if(usrName == null|| password == null)
            return false;
       return manager.getLogin(usrName, password);        
    }
    
    public Partner getPartner(String userName) throws SQLException{
        Partner partner = manager.getPartnerByUserName(userName);
        return partner;
    }
    
    public void approveProject(Project project) throws SQLException{
        
        manager.approveProject(project);
    }

}
