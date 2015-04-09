package dk.group_02.control;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import dk.group_02.Utility.DataValidator;
import dk.group_02.data.DataManager;
import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 *
 * @author steffen
 */
public class Controller {

DataValidator dv;

public boolean projectValidation(Project p)
    {
    dv = new DataValidator();
    if (dv.projectValidation(p)== false){
        return false;
    }
    return true;
}
 public static void SaveProject(Project project,Partner partner) throws ClassNotFoundException, NullPointerException, SQLException, FileNotFoundException 
     {
      DataManager.SaveProject(project, partner);   
     }
}
 
 
 
 
 
