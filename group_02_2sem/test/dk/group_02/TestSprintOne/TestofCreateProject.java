package dk.group_02.TestSprintOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dk.group_02.Entity.Partner;
import dk.group_02.data.DataHandler;
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
        partner = new Partner("ElGigantos", "Danmark", "10");
    }

    @Test
    public void testOpretTrue() throws ClassNotFoundException, SQLException {

        assertTrue(DataHandler.makeProject("1", "LlamaCreame", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, "Jeg vil gerne være første kvinde på mars"));
    }
    @Test
    public void testOpretMedFileTrue(){
     File file = new File("C:\\Users\\steffen\\Documents\\NetBeansProjects\\eksamensProjectDell\\group_02_2sem\\task liste.jpg");
     assertTrue(DataHandler.makeProject("1","LlamaCreame", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, file , "Jeg vil gerne være første kvinde på mars"));
     
    }

    @Test
    public void testOpretFalse() throws ClassNotFoundException, SQLException {
        assertFalse(DataHandler.makeProject(null,"LlamaCreame", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, "Jeg vil gerne være første kvinde på mars"));
        assertFalse(DataHandler.makeProject("1", null, "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, "Jeg vil gerne være første kvinde på mars"));
        assertFalse(DataHandler.makeProject("1", "LlamaCreame", null, 1.0, "AOK STATUS", "Jeg er ironman",partner, "Jeg vil gerne være første kvinde på mars"));
        assertFalse(DataHandler.makeProject("1", "LlamaCreame", "Bente LLama", 1.0, null, "Jeg er ironman",partner, "Jeg vil gerne være første kvinde på mars"));
        assertFalse(DataHandler.makeProject("1", "LlamaCreame", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",partner, null));
        assertFalse(DataHandler.makeProject("1", "LlamaCreame", "Bente LLama", 1.0, "AOK STATUS", null,partner, "Jeg vil gerne være første kvinde på mars"));
        assertFalse(DataHandler.makeProject("1", "LlamaCreame", "Bente LLama", 1.0, "AOK STATUS", "Jeg er ironman",null, "Jeg vil gerne være første kvinde på mars"));
        

    }
    

}
