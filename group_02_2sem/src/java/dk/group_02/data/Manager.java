/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */
package dk.group_02.data;
import dk.group_02.Entity.Poe;
import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import java.io.InputStream;
import java.util.Collection;
import dk.group_02.utility.DatabaseException;

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

//    public void SaveLogin(String username, String password, int partnerOrDel)throws DatabaseException;
    
    public Partner getPartnerByUsername(String userName)throws DatabaseException;
    
    public void approveStatus(Project project)throws DatabaseException;
    
    public void rejectStatus(Project project)throws DatabaseException;
    
    public Partner getPartnerById(String partnerId)throws DatabaseException;
     
    public Poe getPOE(int projectId) throws DatabaseException;
    
    public void POEStatusChange (int projectId) throws DatabaseException;
    
    public void savePOE(InputStream iStream, int projectId, String fileName) throws DatabaseException;
}