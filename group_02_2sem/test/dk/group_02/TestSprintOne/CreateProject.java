package dk.group_02.TestSprintOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dk.group_02.Entity.Partner;
import java.awt.Image;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author steffen
 */
public class CreateProject {

    Partner partner;

    @Before
    public void setUp() {
        partner = new Partner("ElGigantos", "Danmark");
    }

    @Test
    public void testOpretTrue() {
//     Date startDate, String id, String projectName, double cost, String Status, String description, Image files, String goal
        Date date;
        Object image;
        assertTrue(partner.makeProjet(date = new Date(), "LlamaCreame", "Bente LLama", 1.0, "AOK MFUcKER", "Jeg er ironman", "Jeg vil gerne være første kvinde på mars"));
//        assertTrue(partner.makeProjet(date = new Date(), "LlamaCreame", "Bente LLama", 1.0, "AOK MFUcKER", "Jeg er ironman", image = new Image(), "Jeg vil gerne være første kvinde på mars"));

    }

    @Test
    public void testOpretFalse() {

        assertFalse(partner.makeProjet(null, null, null, 1.0, null, null, null));
        

    }
//
//    @Test
//    public void parameterTest() {
//       
//        asssertTrue(partner.makeProject());
//    }
}
