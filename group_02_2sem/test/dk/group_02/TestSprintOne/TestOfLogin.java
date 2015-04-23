/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.TestSprintOne;

import dk.group_02.control.Controller;
import dk.group_02.data.DataManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author steffen
 */
public class TestOfLogin {
    
    //bestået (så fremt databasen ikke er hest
    @Test
    public void testAfLogInTrue()
    {  
        DataManager manager = new DataManager();
        manager.SaveLogin("testUsername", "testPassword", 1);
        assertTrue(manager.getLogin("testUsername", "testPassword"));
    }
    //bestået
        @Test
    public void testAfLogInFalse()
    {  
        DataManager manager = new DataManager();
        manager.SaveLogin("simba", "jurgen", 1);
        assertFalse(manager.getLogin("bimba", "burgen"));
    }
    
}

