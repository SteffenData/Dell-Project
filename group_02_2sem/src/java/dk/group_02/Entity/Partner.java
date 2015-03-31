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
    private String country;

    public Partner(String name, String country) {
        this.name = name;
        this.country = country;
    }
    
//    public boolean makeProjet(Date startDate, String id, String projectName, double cost, String Status, String description, Image files, String goal)
//    {
//        return true;
//    }
    public boolean makeProjet(Date startDate, String id, String projectName, double cost, String Status, String description, String goal)
    {
        return true;
    }
    
    public Project viewProject(String id)
    {
        return null;
    }
    
}
