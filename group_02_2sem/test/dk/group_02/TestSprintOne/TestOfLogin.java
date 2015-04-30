/**
 *
 * @author steffen/Kasper
 */
package dk.group_02.TestSprintOne;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.control.Controller;
import dk.group_02.control.Manager;
import dk.group_02.data.DataManager;
import dk.group_02.utility.DatabaseException;
import java.sql.SQLException;
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

        partner = new Partner("elgiganten", "Denmark");
        manager = new DataManager();
        ctrl = new Controller();
    }

    @Test
    public void testgetPartnerIdTrue() {

        String testId;
        try
        {
            testId = manager.getPartnerID("elgiganten", "Denmark");
            assertTrue("2".equals(testId));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testgetPartnerIdFalse() {

        String testId;
        try
        {
            testId = manager.getPartnerID("elgiganten", "Denmark");
            assertFalse("3".equals(testId));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test

    public void testgetPartnerByIdTrue() {

        Partner testPartner;
        try
        {
            testPartner = manager.getPartnerById("2");
            assertTrue(partner.getPartnerName().equals(testPartner.getPartnerName()));
            assertTrue(partner.getCountry().equals(testPartner.getCountry()));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testgetPartnerByIdFalse() {

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
    public void testPartnerByUsernameTrue() {

        try
        {
            Partner testPartner = manager.getPartnerByUserName("bubber");
            assertTrue(partner.getPartnerName().equals(testPartner.getPartnerName()));
            assertTrue(partner.getCountry().equals(testPartner.getCountry()));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testPartnerByUsernameFalse() {

        try
        {
            Partner testPartner = manager.getPartnerByUserName("kasper");
            assertFalse(partner.getPartnerName().equals(testPartner.getPartnerName()));
            assertFalse(partner.getCountry().equals(testPartner.getCountry()));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testAfLogInTrue() {

        try
        {
            manager.SaveLogin("testUsername", "testPassword", 1);
            assertTrue(manager.getLogin("testUsername", "testPassword"));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testAfLogInFalse() {

        try
        {
            manager.SaveLogin("simba", "jurgen", 1);
            assertFalse(manager.getLogin("bimba", "burgen"));
        } catch (DatabaseException ex)
        {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
