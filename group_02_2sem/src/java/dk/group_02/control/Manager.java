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

    public Collection<Project> getDellProjects() throws SQLException;

    public Collection<Project> getPartnerProjects(Partner partner) throws SQLException;

    public Project getProject(Project project) throws SQLException;

    public InputStream getUpload(Project project) throws SQLException;

    public int getProjectId(Project project) throws SQLException;

    public String getPartnerID(String partnerName, String country) throws SQLException;

    public void SaveProject(Project project) throws SQLException;

    public Partner getLogin(String usrName, String password) throws SQLException;

    public void SaveLogin(String username, String password, int partnerOrDel) throws SQLException;
    
    
     
            
}
