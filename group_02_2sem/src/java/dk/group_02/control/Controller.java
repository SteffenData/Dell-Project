/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */
package dk.group_02.control;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Poe;
import dk.group_02.Entity.Project;
import dk.group_02.data.DataManager;
import dk.group_02.utility.DatabaseException;
import dk.group_02.utility.Validator;
import java.io.InputStream;
import java.util.Collection;

public class Controller
{

    Manager manager;
    Validator validator;

    public Controller()
    {
        this.manager = new DataManager();
        this.validator = new Validator();
    }

    public boolean saveProject(String startDate, String projectName, Double cost, String status, String description, Partner partner, String goal) throws DatabaseException
    {
        if (startDate == null || projectName == null || cost == null || description == null || goal == null || partner == null || status == null)
        {
            return false;
        }
        if (validator.validateProjectInfo(projectName, cost, status, description, goal))
        {
            Project project = new Project(0, startDate, projectName, cost, status, description, goal, partner);
            manager.SaveProject(project);
            return true;
        }
        return false;
    }

    public Collection<Project> getDellProjects() throws DatabaseException
    {

        Collection<Project> outDell = manager.getDellProjects();

        return outDell;
    }

    public Collection<Project> getPartnerProjects(Partner partner) throws DatabaseException
    {

        Collection<Project> outPartner = manager.getPartnerProjects(partner);

        return outPartner;
    }

    public Project getProject(int projectId) throws DatabaseException
    {
        Project outproject = manager.getProject(projectId);
        return outproject;

    }

    public boolean getLogin(String usrName, String password) throws DatabaseException
    {
        if (usrName.isEmpty() || password.isEmpty())
        {
            return false;
        }
        if (usrName == null || password == null)
        {
            return false;
        }
        return manager.getLogin(usrName, password);
    }

    public Partner getPartnerByUsername(String userName) throws DatabaseException
    {
        Partner partner = manager.getPartnerByUsername(userName);
        return partner;
    }

    public void approveStatus(Project project) throws DatabaseException
    {

        manager.approveStatus(project);
    }

    public void rejectStatus(Project project) throws DatabaseException
    {

        manager.rejectStatus(project);
    }

    public Poe getPOE(int projectId) throws DatabaseException
    {
        return manager.getPOE(projectId);
    }


    public void savePOE(InputStream iStream, int projectId, String fileName) throws DatabaseException
    {
        manager.savePOE(iStream, projectId, fileName);
    }
}