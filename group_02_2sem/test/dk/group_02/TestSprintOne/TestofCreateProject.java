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

    @Before
    public void setUp() {
      
        partner = new Partner ("Dell","Denmark");
        
    }

    @Test
    public void testOpretTrue() throws ClassNotFoundException, SQLException {

       
        
    }
    @Test
    public void testOpretMedFileTrue(){
   
     
    }

    @Test
    public void testOpretFalse() throws ClassNotFoundException, SQLException {
       
    }
    
    

}
