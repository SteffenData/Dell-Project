package dk.group_02.TestSprintOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.xml.internal.ws.util.StringUtils;
import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.data.DataManager;
import dk.group_02.control.Controller;
import dk.group_02.control.Manager;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author steffen
 */
public class TestofCreateProject {
    
    Partner partner;
    Project project;
    Manager manager;
    Controller ctrl;

    
    @Before
    public void setUp() {
        
        partner = new Partner("elgiganten", "Denmark");
        project = new Project(0,"1992-10-10", "TestProject", 1.0, "testing", "test", "test", partner);
        manager = new DataManager();
        ctrl = new Controller();
        
        
    }
    
    @Test
    public void testOfValidateProjectInfo() {
        
        String mikkel = new String(new char[251]).replace('\0', 'm');
        
        assertTrue(ctrl.validateProjectInfo("allGood", 1.0, "status", "des", "goal"));
        
        assertFalse(ctrl.validateProjectInfo("thisNameIsMoreThanThirtyCharacters", 1.0, "status", "des", "goal"));
        assertFalse(ctrl.validateProjectInfo("Name", 90000000.0, "status", "des", "goal"));
        assertFalse(ctrl.validateProjectInfo("Name", 1.0, "thisNameIsMoreThanThirtyCharacters", "des", "goal"));
        
        assertFalse(ctrl.validateProjectInfo("allGood", 1.0, "status", mikkel, "goal"));
        assertFalse(ctrl.validateProjectInfo("allGood", 1.0, "status", "des", mikkel));
    }
    
    @Test
    public void testOpretTrue() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException {
        
        manager.SaveProject(project);
        int testId = manager.getProjectId(project);
        assertTrue(project.getProjectName().equals(manager.getProject(testId).getProjectName()));
        assertTrue(project.getGoal().equals(manager.getProject(testId).getGoal()));
        assertTrue(project.getDescription().equals(manager.getProject(testId).getDescription()));
        assertTrue(project.getProjectName().equals(manager.getProject(testId).getProjectName()));
        assertTrue(project.getStartDate().equals(manager.getProject(testId).getStartDate()));
        assertTrue(project.getStatus().equals(manager.getProject(testId).getStatus()));
        
        
    }

   
    @Test
    public void testOpretMedFileTrue() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("task liste.jpg");
        
        project.setUpload(file);
        manager.SaveProject(project);
        
//        assertTrue(project.getUpload().equals(DataManager.getUpload(project, partner)));
        
    }
    
    @Test
    public void testOpretFalse() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException {
        assertFalse(ctrl.saveProject(null, "huli", 1.0, "gold", "silver",partner , "mikkel"));
        assertFalse(ctrl.saveProject("1992-10-10", null, 1.0, "gold", "silver",partner , "mikkel"));
        assertFalse(ctrl.saveProject("1992-10-10", "huli", 1.0, null, "silver",partner , "mikkel"));
        assertFalse(ctrl.saveProject("1992-10-10", "huli", 1.0, "gold", null,partner , "mikkel"));
        assertFalse(ctrl.saveProject("1992-10-10", "huli", 1.0, "gold", "silver",partner , null));
        assertFalse(ctrl.saveProject("1992-10-10", "huli", 1.0, "gold", "silver",null , "Mikkel"));
        assertFalse(ctrl.saveProject("1992-10-10", "huli", null, "gold", "silver",partner , "Mikkel"));
         
    }
    
    
}
