package dk.group_02.TestSprintOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.data.DataManager;
import dk.group_02.data.DataValidator;
import java.io.File;
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

    @Before
    public void setUp() {
        partner = new Partner("Delli", "Denmark", "1");
    }

    @Test
    public void testOpretTrue() throws ClassNotFoundException, SQLException {

        assertTrue(DataValidator.makeProject("1992-12-01", "12", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, "Jeg vil gerne være første kvi"));
        Project project = new Project ("1992-12-01", "12", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, "Jeg vil gerne være første kvi");
        assertTrue(project.getPROJECT_ID().equals(DataManager.getProject(project).getPROJECT_ID()));
        
    }
    @Test
    public void testOpretMedFileTrue(){
     File file = new File("C:\\Users\\steffen\\Documents\\NetBeansProjects\\eksamensProjectDell\\group_02_2sem\\task liste.jpg");
     assertTrue(DataValidator.makeProject("1992-12-01","12", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, file , "Jeg vil gerne være første kvinde på mars"));
     
    }

    @Test
    public void testOpretFalse() throws ClassNotFoundException, SQLException {
        assertFalse(DataValidator.makeProject("1992-12-01", "12", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, null));
        assertFalse(DataValidator.makeProject("1992-12-01", null, "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, "Jeg vil gerne være første kvinde på mars"));
        assertFalse(DataValidator.makeProject("1992-12-01", "12", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",null, "Jeg vil gerne være første kvinde på mars"));
        assertFalse(DataValidator.makeProject(null,"12", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, "Jeg vil gerne være første kvinde på mars"));
        assertFalse(DataValidator.makeProject("1992-12-01", "12", "Bente LLama", 1.0, "AOK STATUS", null,partner, "Jeg vil gerne være første kvinde på mars"));
        assertFalse(DataValidator.makeProject("1992-12-01", "12", null, 1.0, "AOK STATUS", "Jeg er ironman",partner, "Jeg vil gerne være første kvinde på mars"));
    }
    
    

}
