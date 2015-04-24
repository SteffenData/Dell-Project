/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.control;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author steffen
 */
public interface Manager
{

    public Collection<Project> getDellProjects();
    
//    public Project getSameProject(Project project);

    public Collection<Project> getPartnerProjects(Partner partner);

    public Project getProject(int projectId);

    public InputStream getUpload(Project project);

    public int getProjectId(Project project);

    public String getPartnerID(String partnerName, String country);

    public void SaveProject(Project project);

    public boolean getLogin(String usrName, String password);

    public void SaveLogin(String username, String password, int partnerOrDel);
    
    public Partner getPartnerByUserName(String userName);
    
    public void approveProject(Project project);
    
    public void rejectProject(Project project);
    
    public Partner getPartnerById(String partnerId);
     
            
}
