/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.TestSprintOne;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.control.Controller;
import dk.group_02.control.Manager;
import dk.group_02.data.DataManager;
import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pagh
 */
public class TestOfStatusChange
{

    Partner partner;
    Project project;
    Manager manager;
    Controller ctrl;
    
    @Before
    public void setUp() {
        
        partner = new Partner("elgiganten", "Denmark");
        project = new Project(0,"1992-10-10", "TestProject", 1.0, "testingigenigenigen", "test", "test", partner);
        manager = new DataManager();
        ctrl = new Controller();
        
    }

    @Test
    public void testStatusChangeApproved()
    {
        

        try
        {
            ctrl.approveStatus(project); // her ændrer vi status til awaiting POE
            System.out.println(project.getStatus());
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
            ctrl.rejectStatus(project); // her ændrer vi status til project rejected
            System.out.println(project.getStatus());
            int testId = manager.getProjectId(project);
            
            assertTrue("Project rejected".equals(manager.getProject(testId).getStatus())); // her ser vi om projektet har ændret status i databasen
            
        } 
        catch (SQLException e)
        {

        }
    }

}
