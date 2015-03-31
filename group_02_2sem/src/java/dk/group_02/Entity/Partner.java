/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Entity;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author steffen
 */
public class Partner {
    private String name;

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
    private String country;

    public Partner(String name, String country) {
        this.name = name;
        this.country = country;
    }
    
//    public boolean makeProjet(Date startDate, String id, String projectName, double cost, String Status, String description, Image files, String goal)
//    {
//        return true;
//    }
    //The cost is not controlled as any negative value means that Dell is bein paid money (which is nice). --- cost may have to be limited relative to the budget of Dell ----
    public boolean makeProject(String id, String projectName, double cost, String status, String description, String goal)
    {   
        if(id == null || projectName == null || status == null || description == null || goal == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public Project viewProject(String id)
    {
        return null;
    }
    
}
