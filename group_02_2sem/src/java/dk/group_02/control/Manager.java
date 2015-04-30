/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.control;
import dk.group_02.Entity.Poe;
import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import dk.group_02.utility.DatabaseException;
/**
 *
 * @author steffen
 */
public interface Manager
{
    public Collection<Project> getDellProjects() throws DatabaseException;

    public Collection<Project> getPartnerProjects(Partner partner) throws DatabaseException;

    public Project getProject(int projectId)throws DatabaseException;

    public InputStream getUpload(Project project)throws DatabaseException;

    public int getProjectId(Project project)throws DatabaseException;

    public String getPartnerID(String partnerName, String country)throws DatabaseException;

    public void SaveProject(Project project)throws DatabaseException;

    public boolean getLogin(String usrName, String password)throws DatabaseException;

    public void SaveLogin(String username, String password, int partnerOrDel)throws DatabaseException;
    
    public Partner getPartnerByUserName(String userName)throws DatabaseException;
    
    public void approveStatus(Project project)throws DatabaseException;
    
    public void rejectStatus(Project project)throws DatabaseException;
    
    public Partner getPartnerById(String partnerId)throws DatabaseException;
     
    public Poe getPOE(int projectId) throws DatabaseException;
    
    public void savePOE(InputStream iStream, int projectId, String fileName) throws DatabaseException;
}