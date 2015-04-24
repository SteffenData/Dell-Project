/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.TestSprintOne;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.control.Controller;
import dk.group_02.control.Manager;
import dk.group_02.data.DataManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author steffen
 */
public class TestOfLogin 
{
    
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
    
    
    //bestået (så fremt databasen ikke er hest
   @Test
   public void testPartnerByUsernameTrue(){
    
       try {
           String testId = manager.getPartnerID("elgiganten", "Denmark");
           assertTrue("2".equals(testId));
          
       }
       catch (SQLException ex) {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   @Test
   public void testPartnerByUsernameFalse(){
    
       try {
          String testId = manager.getPartnerID("elgiganten", "Denmark");
           assertFalse("3".equals(testId));
       }
       catch (SQLException ex) {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
      @Test
      
   public void testgetPartnerIdTrue(){
    
       try {
           
           
          Partner testPartner = manager.getPartnerByUserName("bubber");
           assertTrue(partner.getPartnerName().equals(testPartner.getPartnerName()));
           assertTrue(partner.getCountry().equals(testPartner.getCountry()));
       }
       catch (SQLException ex) {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   @Test
   public void testgetPartnerIdFalse(){
    
       try {
          Partner testPartner = manager.getPartnerByUserName("kasper");
           assertFalse(partner.getPartnerName().equals(testPartner.getPartnerName()));
           assertFalse(partner.getCountry().equals(testPartner.getCountry()));
       }
       catch (SQLException ex) {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
   
    @Test
    public void testAfLogInTrue()
    {  
        
        try {
            manager.SaveLogin("testUsername", "testPassword", 1);
            assertTrue(manager.getLogin("testUsername", "testPassword"));
        } catch (SQLException ex) {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //bestået
    @Test
    public void testAfLogInFalse()
    {  
        
        try {
            manager.SaveLogin("simba", "jurgen", 1);
            assertFalse(manager.getLogin("bimba", "burgen"));
        } catch (SQLException ex) {
            Logger.getLogger(TestOfLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

