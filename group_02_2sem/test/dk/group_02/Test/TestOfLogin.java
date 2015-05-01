/**
 *
 * @author steffen/Kasper
 */
package dk.group_02.Test;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.control.Controller;
import dk.group_02.control.Manager;
import dk.group_02.data.DataManager;
import dk.group_02.utility.DatabaseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TestOfLogin {

    Partner partner;
    Project project;
    Manager manager;
    Controller ctrl;

    @Before
    public void setUp() {

        partner = new Partner("Elgiganten", "Denmark");
        manager = new DataManager();
        ctrl = new Controller();
    }

    @Test
    public void testgetPartnerId() {

        String testId;
        try
        {
            testId = manager.getPartnerID("Elgiganten", "Denmark");
            assertTrue("4".equals(testId));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testgetPartnerIdWrongId() {

        String testId;
        try
        {
            testId = manager.getPartnerID("Elgiganten", "Denmark");
            assertFalse("2".equals(testId));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test

    public void testgetPartnerById() {

        Partner testPartner;
        try
        {
            testPartner = manager.getPartnerById("4");
            assertTrue(partner.getPartnerName().equals(testPartner.getPartnerName()));
            assertTrue(partner.getCountry().equals(testPartner.getCountry()));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testgetPartnerByIdWrongId() {

        try
        {
            Partner testPartner = manager.getPartnerById("3");
            assertFalse(partner.getPartnerName().equals(testPartner.getPartnerName()));
            assertFalse(partner.getCountry().equals(testPartner.getCountry()));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetPartnerByUsername() {

        try
        {
            Partner testPartner = manager.getPartnerByUsername("bubber");
            assertTrue(partner.getPartnerName().equals(testPartner.getPartnerName()));
            assertTrue(partner.getCountry().equals(testPartner.getCountry()));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetPartnerByUsernameWrongUsername() {

        try
        {
            Partner testPartner = manager.getPartnerByUsername("kasper");
            assertFalse(partner.getPartnerName().equals(testPartner.getPartnerName()));
            assertFalse(partner.getCountry().equals(testPartner.getCountry()));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetLogin() {

        try
        {
//            manager.SaveLogin("testUsername", "testPassword", 1);
            assertTrue(manager.getLogin("testUsername", "testPassword"));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetLoginNotInDatabase() {

        try
        {
//            manager.SaveLogin("simba", "jurgen", 1);
            assertFalse(manager.getLogin("notInDatabase", "notInDatabase"));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
