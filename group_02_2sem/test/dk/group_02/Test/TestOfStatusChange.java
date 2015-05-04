/**
 *
 * @author Bente/Mikkel
 */
package dk.group_02.Test;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.control.Controller;
import dk.group_02.data.Manager;
import dk.group_02.data.DataManager;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestOfStatusChange
{
    Partner partner;
    Project project;
    Manager manager;
    Controller ctrl;
    
    @Before
    public void setUp() {
        
        partner = new Partner("elgiganten", "Denmark");
        project = new Project(0,"1992-10-10", "TestProject", 1.0, "Awaiting approval", "test", "test", partner);
        manager = new DataManager();
        ctrl = new Controller();
    }

    @Test
    public void testStatusChangeApproved()
    {
        try
        {
            manager.SaveProject(project);
            ctrl.approveStatus(project); // her ændrer vi status til awaiting POE
            int testId = manager.getProjectId(project);
            
            assertTrue("Awaiting POE".equals(manager.getProject(testId).getStatus())); // her ser vi om projektet har ændret status i databasen
        } 
        catch (SQLException e)
        {
        }
    }
    
    @Test
    public void testStatusChangeRejected()
    {
        try
        {
            manager.SaveProject(project);
            ctrl.rejectStatus(project); // her ændrer vi status til project rejected
            int testId = manager.getProjectId(project);
            
            assertTrue("Project rejected".equals(project.getStatus())); // her ser vi om projektet har ændret status i databasen
        } 
        catch (SQLException e)
        {
        }
    }

}
