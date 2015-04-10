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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    @Before
    public void setUp() {
        
        partner = new Partner("Dell", "Denmark");
        project = new Project("1992-10-10", "huli", 1.0, "gold", "silver", "mikkel");
        
    }
    
    @Test
    public void testOpretTrue() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException {
        
        DataManager.SaveProject(project, partner);
        assertTrue(project.getProjectName().equals(DataManager.getProject(project, partner).getProjectName()));
        assertTrue(project.getGoal().equals(DataManager.getProject(project, partner).getGoal()));
        assertTrue(project.getDescription().equals(DataManager.getProject(project, partner).getDescription()));
        assertTrue(project.getProjectName().equals(DataManager.getProject(project, partner).getProjectName()));
        assertTrue(project.getStartDate().equals(DataManager.getProject(project, partner).getStartDate()));
        assertTrue(project.getStatus().equals(DataManager.getProject(project, partner).getStatus()));
        
        
    }

   
    @Test
    public void testOpretMedFileTrue() throws ClassNotFoundException, SQLException, FileNotFoundException {
        File file = new File("C:\\Users\\steffen\\Documents\\NetBeansProjects\\eksamensProjectDell\\group_02_2sem\\task liste.jpg");
        project.setUpload(file);
        DataManager.SaveProject(project, partner);
        
//        assertTrue(project.getUpload().equals(DataManager.getUpload(project, partner)));
        
    }
    
    @Test
    public void testOpretFalse() throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException {
        assertFalse(DataValidator.makeProject(null, "huli", 1.0, "gold", "silver",partner , "mikkel"));
        assertFalse(DataValidator.makeProject("1992-10-10", null, 1.0, "gold", "silver",partner , "mikkel"));
        assertFalse(DataValidator.makeProject("1992-10-10", "huli", 1.0, null, "silver",partner , "mikkel"));
        assertFalse(DataValidator.makeProject("1992-10-10", "huli", 1.0, "gold", null,partner , "mikkel"));
        assertFalse(DataValidator.makeProject("1992-10-10", "huli", 1.0, "gold", "silver",partner , null));
        assertFalse(DataValidator.makeProject("1992-10-10", "huli", 1.0, "gold", "silver",null , "Mikkel"));
        assertFalse(DataValidator.makeProject("1992-10-10", "huli", null, "gold", "silver",partner , "Mikkel"));
        
        
        
    }
    
}
