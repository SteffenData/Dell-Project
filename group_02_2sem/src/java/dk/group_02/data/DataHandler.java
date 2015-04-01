/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.data;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import java.io.File;
import java.sql.SQLException;

/**
 *
 * @author steffen
 */
public class DataHandler {
            //The cost is not controlled as any negative value means that Dell is being paid money (which is nice). --- cost may have to be limited relative to the budget of Dell ----
    public static boolean makeProject(String startDate, String id, String projectName, double cost, String status, String description, Partner partner, String goal) throws ClassNotFoundException, SQLException
    {   
        if(startDate == null || id == null || projectName == null || description == null || goal == null || partner == null)
        {
            return false;
        }
        Project project = new Project(startDate, id,projectName,cost,status,description,partner,goal);
        DataManager.SaveProject(project);
            return true;
    }
    
    public Project viewProject(String id)
    {
        return null;
    }
    // vi overloader make project med et ekstra parameter(file)
     public static boolean makeProject(String startDate, String id, String projectName, double cost, String status, String description,Partner partner, File upload, String goal)
    {   
        if(startDate == null || id == null || projectName == null || description == null || goal == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
