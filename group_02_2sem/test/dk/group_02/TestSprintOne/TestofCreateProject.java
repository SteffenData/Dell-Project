package dk.group_02.TestSprintOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.data.DataManager;
import dk.group_02.Utility.DataValidator;
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
    DataValidator validator;
    
    @Before
    public void setUp() {
        
        partner = new Partner("Dell", "Denmark");
        project = new Project("1992-10-10", "huli", 1.0, "gold", "silver", "mikkel", partner);
        manager = new DataManager();
        validator = new DataValidator();
        
    }
    
    @Test
    public void testOpretTrue() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException {
        
        manager.SaveProject(project);
        assertTrue(project.getProjectName().equals(manager.getProject(project).getProjectName()));
        assertTrue(project.getGoal().equals(manager.getProject(project).getGoal()));
        assertTrue(project.getDescription().equals(manager.getProject(project).getDescription()));
        assertTrue(project.getProjectName().equals(manager.getProject(project).getProjectName()));
        assertTrue(project.getStartDate().equals(manager.getProject(project).getStartDate()));
        assertTrue(project.getStatus().equals(manager.getProject(project).getStatus()));
        
        
    }

   
    @Test
    public void testOpretMedFileTrue() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("C:\\Users\\steffen\\Documents\\NetBeansProjects\\eksamensProjectDell\\group_02_2sem\\task liste.jpg");
        project.setUpload(file);
        manager.SaveProject(project);
        
//        assertTrue(project.getUpload().equals(DataManager.getUpload(project, partner)));
        
    }
    
    @Test
    public void testOpretFalse() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException {
        assertFalse(validator.saveProject(null, "huli", 1.0, "gold", "silver",partner , "mikkel"));
        assertFalse(validator.saveProject("1992-10-10", null, 1.0, "gold", "silver",partner , "mikkel"));
        assertFalse(validator.saveProject("1992-10-10", "huli", 1.0, null, "silver",partner , "mikkel"));
        assertFalse(validator.saveProject("1992-10-10", "huli", 1.0, "gold", null,partner , "mikkel"));
        assertFalse(validator.saveProject("1992-10-10", "huli", 1.0, "gold", "silver",partner , null));
        assertFalse(validator.saveProject("1992-10-10", "huli", 1.0, "gold", "silver",null , "Mikkel"));
        assertFalse(validator.saveProject("1992-10-10", "huli", null, "gold", "silver",partner , "Mikkel"));
        
        
        
    }
    
}
