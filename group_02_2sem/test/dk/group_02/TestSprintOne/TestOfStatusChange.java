/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.TestSprintOne;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.Utility.Controller;
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

    Controller ctrl = new Controller();

    @Test
    public void testStatusChangeTrue()
    {
        String abekat = LocalDate.now().toString();
        Partner part = null;
        Project p = new Project(abekat, "TestProject", 22.0, "Awaiting approval", "busters verden", "gooooooaaaal", part);

        try
        {
            ctrl.approveProject(p);
            Project pro = ctrl.getProject(abekat, "TestProject", 22);
            
            assertTrue(pro.getStatus() == "Awaiting POE");
            
        } 
        catch (SQLException e)
        {

        }
    }

}
