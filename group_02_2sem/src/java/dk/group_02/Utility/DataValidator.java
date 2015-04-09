/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Utility;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.data.DataManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 *
 * @author steffen
 */
public class DataValidator
{

    //The cost is not controlled as any negative value means that Dell is being paid money (which is nice). --- cost may have to be limited relative to the budget of Dell ----

    public static boolean makeProject(String startDate, String projectName, double cost, String status, String description, Partner partner, String goal) throws ClassNotFoundException, SQLException, NullPointerException, FileNotFoundException
    {
        if (startDate == null || projectName == null || description == null || goal == null || partner == null || status ==null )
        {
            return false;
        }else{
        Project project = new Project(startDate, projectName, cost, status, description, goal);
        DataManager.SaveProject(project, partner);
        return true;
        }
    }

    public Project viewProject(String id)
    {
        return null;
    }

    // vi overloader make project med et ekstra parameter(file)

    public static boolean makeProject(String startDate, String projectName, double cost, String status, String description, Partner partner, File upload, String goal)
    {
        if (startDate == null || projectName == null || description == null || goal == null || partner == null)
        {
            return false;
        } else
        {
            return true;
        }
    }
     // Her tjecker vi for om projektet er rigtigt oprettet.

   
}
