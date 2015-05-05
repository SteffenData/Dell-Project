/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */
package dk.group_02.data;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Poe;
import dk.group_02.Entity.Project;
import dk.group_02.utility.DatabaseException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

public class DataManager implements Manager {

    public DataManager() {
        try {
            Class.forName(DataOracleAccessor.DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection<Project> getDellProjects() throws DatabaseException {

        Collection<Project> dellProjects = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement statement = null;

        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {

            String query = "SELECT * FROM projects order by 'Awaiting approval','Awaiting POE','Project rejected' , startDate";

            statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                String subStartDate = rs.getString("startDate").substring(0, 10);
                Project p = new Project(rs.getInt("projectId"),
                        subStartDate, rs.getString("projectName"),
                        rs.getDouble("cost"), rs.getString("status"),
                        rs.getString("description"), rs.getString("goal"),
                        getPartnerById(rs.getString("partnerId")));
                p.setStatusDescription(rs.getString("statusdescription"));
                dellProjects.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
        return dellProjects;
    }

    public Collection<Project> getPartnerProjects(Partner partner) throws DatabaseException {

        Collection<Project> partnerProjects = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement statement = null;

        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {

            String partnerID = getPartnerID(partner.getPartnerName(), partner.getCountry());

            String query = "SELECT * FROM projects where partnerId = ? order by projectName";

            statement = connection.prepareStatement(query);
            statement.setString(1, partnerID);
            rs = statement.executeQuery();
            while (rs.next()) {
                String subStartDate = rs.getString("startDate").substring(0, 10);
                Project p = new Project(rs.getInt("projectId"), subStartDate, rs.getString("projectName"),
                        rs.getDouble("cost"), rs.getString("status"), rs.getString("description"), rs.getString("goal"), getPartnerById((rs.getString("partnerID"))));
                p.setStatusDescription(rs.getString("statusdescription"));
                partnerProjects.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
        return partnerProjects;
    }

    public Project getProject(int projectId) throws DatabaseException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Project finalProject = null;
        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {

            String query = "SELECT * FROM PROJECTS WHERE projectId = ?";

            statement = connection.prepareStatement(query);
            statement.setInt(1, projectId);
            rs = statement.executeQuery();
            if (rs.next()) {
                finalProject = new Project(rs.getInt("projectId"), rs.getString("startdate").substring(0, 10), rs.getString("projectName"),
                        rs.getDouble("cost"), rs.getString("status"), rs.getString("description"), rs.getString("goal"), getPartnerById(rs.getString("partnerId")));
                finalProject.setStatusDescription(rs.getString("statusdescription"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
        return finalProject;
    }

    public void approveStatus(Project project) throws DatabaseException {
        PreparedStatement statement = null;

        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {
            String newStatus = "";
            int projectId = getProjectId(project);
            switch (project.getStatus()) {
                case "Awaiting approval":
                    newStatus = "Awaiting POE";
                    break;
                case "Awaiting POE":
                    newStatus = "Awaiting POE";
                    break;
                case "Awaiting approval on POE":
                    newStatus = "Awaiting inVoice";
                    break;
                case "Project rejected":
                    newStatus = "Awaiting POE";
                    break;
                case "Awaiting inVoice":
                    newStatus = "Awaiting inVoice";
                    break;
            }
            String query = "UPDATE projects SET status=?, statusDescription=? WHERE projectId = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, newStatus);
            statement.setString(2, project.getStatusDescription());
            statement.setInt(3, projectId);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
    }

    public void rejectStatus(Project project) throws DatabaseException {
        PreparedStatement statement = null;

        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {
            int projectId = getProjectId(project);
            String newStatus = "";
            switch (project.getStatus()) {
                case "Awaiting approval":
                    newStatus = "Project rejected";
                    break;
                case "Awaiting approval on POE":
                    newStatus = "Awaiting POE";
                    break;
                case "Project rejected":
                    newStatus = "Project rejected";
                    break;
                case "Awaiting inVoice":
                    newStatus = "Awaiting POE";
                    break;
                case "Awaiting POE":
                    newStatus = "Project rejected";
                    break;

            }
            String query = "UPDATE Projects set status = ? , statusDescription=? where projectID = ?";
//            String query = "UPDATE Projects set status='Project rejected', statusDescription=? where projectID = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, newStatus);
            statement.setString(2, project.getStatusDescription());
            statement.setInt(3, projectId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
    }

    public InputStream getUpload(Project project) throws DatabaseException {

        ResultSet rs = null;
        PreparedStatement statement = null;
        InputStream upload = null;

        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {

            int projectId = getProjectId(project);

            String query = "SELECT upload FROM files where projectid = ?";

            statement = connection.prepareStatement(query);
            statement.setInt(1, projectId);
            rs = statement.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob("upload");
                InputStream input = blob.getBinaryStream();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
        return upload;
    }

    public int getProjectId(Project project) throws DatabaseException {

        ResultSet rs = null;
        PreparedStatement statement = null;

        int projectId = 0;

        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {

            String partnerID = getPartnerID(project.getPartner().getPartnerName(), project.getPartner().getCountry());

            String query = "SELECT projectid FROM projects where projectname = ? and partnerId = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, project.getProjectName());
            statement.setString(2, partnerID);
            rs = statement.executeQuery();
            if (rs.next()) {

                projectId = rs.getInt("projectId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
        return projectId;
    }

    public String getPartnerID(String partnerName, String country) throws DatabaseException {

        ResultSet rs = null;
        PreparedStatement statement = null;
        String partnerId = null;
        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {
            String query = "SELECT * FROM partners where partnerName = ? and country = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, partnerName);
            statement.setString(2, country);
            rs = statement.executeQuery();

            if (rs.next()) {

                partnerId = rs.getString("PARTNERID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
        return partnerId;
    }

    public Partner getPartnerByUsername(String username) throws DatabaseException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Partner partner = null;
        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {
            String query = "SELECT partnername,country FROM partners where username =?";

            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            rs = statement.executeQuery();

            if (rs.next()) {
                partner = new Partner(rs.getString("partnerName"), rs.getString("country"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
        return partner;
    }

    public Partner getPartnerById(String partnerId) throws DatabaseException {
        ResultSet rs = null;
        PreparedStatement statement = null;

        Partner partner = null;
        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {

            String query = "SELECT partnername,country FROM partners where partnerid =?";

            statement = connection.prepareStatement(query);
            statement.setString(1, partnerId);
            rs = statement.executeQuery();

            if (rs.next()) {
                partner = new Partner(rs.getString("partnername"), rs.getString("country"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
        return partner;
    }

    public void SaveProject(Project project) throws DatabaseException {
        PreparedStatement statement = null;

        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {

            String query = "insert into projects "
                    + "(PROJECTID,STARTDATE,PROJECTNAME,COST,STATUS,DESCRIPTION,GOAL,statusdescription,PARTNERID)"
                    + " values (seq_id_project.nextval,to_date(?,'YYYY-MM-DD'),?,?,?,?,?,'',?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, project.getStartDate());
            statement.setString(2, project.getProjectName());
            statement.setDouble(3, project.getCost());
            statement.setString(4, project.getStatus());
            statement.setString(5, project.getDescription());
            statement.setString(6, project.getGoal());
            statement.setString(7, getPartnerID(project.getPartner().getPartnerName(), project.getPartner().getCountry()));

            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
    }

    public boolean getLogin(String username, String password) throws DatabaseException {
        ResultSet rs = null;
        PreparedStatement statement = null;

        boolean returnVariable = false;

        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {

            String query = "SELECT * FROM USERS where username =? and password =?";

            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            rs = statement.executeQuery();

            if (rs.next()) {
                returnVariable = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
        return returnVariable;
    }

    public Poe getPOE(int projectId) throws DatabaseException {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Poe poe = new Poe();
        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {
            String query = "SELECT filename,upload FROM files where projectid = ?";

            statement = connection.prepareStatement(query);
            statement.setInt(1, projectId);
            rs = statement.executeQuery();
            if (rs.next()) {
                poe.setBuffer(IOUtils.toByteArray(rs.getBinaryStream("upload")));
                poe.setFilename(rs.getString("filename"));
            }
        } catch (SQLException | IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
        return poe;
    }

    public void POEStatusChange (int projectId) throws DatabaseException
    {
         PreparedStatement statement = null;

        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {
            String query = "UPDATE projects SET status=?, statusDescription=? WHERE projectId = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, "Awaiting approval on POE");
            statement.setString(2, "");
            statement.setInt(3, projectId);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
    }
    public void savePOE(InputStream iStream, int projectId, String fileName) throws DatabaseException {
        PreparedStatement statement = null;

        try (Connection connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD)) {

            String query = "insert into files (projectid,upload,filename) values (?,?,?)";

            statement = connection.prepareStatement(query);
            statement.setInt(1, projectId);
            statement.setBinaryStream(2, iStream);
            statement.setString(3, fileName);

            statement.executeUpdate();
            POEStatusChange(projectId);
        } catch (SQLException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseException("Sorry, the Database is out of service");
        }
    }
}
