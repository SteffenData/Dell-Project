/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package dk.group_02.data;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;

import dk.group_02.control.Manager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author steffen
 */
public class DataManager implements Manager
{

    public Collection<Project> getDellProjects() throws SQLException
    {

        Collection<Project> dellProjects = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;

        try
        {
            //=== Load the JDBC-driver
            Class.forName(DataOracleAccessor.DRIVER);

            //=== Connect to the database
            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            String query = "SELECT * FROM projects order by projectName";

            statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next())
            {
                String subStartDate = rs.getString("startDate").substring(0, 10);
                dellProjects.add(new Project(
                        subStartDate, rs.getString("projectName"),
                        rs.getDouble("cost"), rs.getString("status"), rs.getString("description"), rs.getString("goal"), getPartner(rs.getString("partnerId"))));
            }
        } catch (ClassNotFoundException ex)
        {
        } finally
        {
            statement.close();
            connection.close();

        }
        return dellProjects;

    }

    public Collection<Project> getPartnerProjects(Partner partner) throws SQLException
    {

        Collection<Project> partnerProjects = new ArrayList<>();

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;

        try
        {

            Class.forName(DataOracleAccessor.DRIVER);

            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            String partnerID = getPartnerID(partner.getPartnerName(), partner.getCountry());

            String query = "SELECT * FROM projects where partnerId = ? order by projectName";

            statement = connection.prepareStatement(query);
            statement.setString(1, partnerID);
            rs = statement.executeQuery();
            while (rs.next())
            {
                String subStartDate = rs.getString("startDate").substring(0, 10);
                partnerProjects.add(new Project(subStartDate, rs.getString("projectName"),
                        rs.getDouble("cost"), rs.getString("status"), rs.getString("description"), rs.getString("goal"), getPartner(rs.getString("partnerId"))));
            }
        } catch (ClassNotFoundException | SQLException ex)
        {

        } finally
        {
            statement.close();
            connection.close();

        }
        return partnerProjects;

    }

    public Project getProject(Project project) throws SQLException
    {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        Project finalProject = null;

        try
        {

            Class.forName(DataOracleAccessor.DRIVER);

            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            String partnerID = getPartnerID(project.getPartner().getPartnerName(), project.getPartner().getCountry());

            String query = "SELECT * FROM projects where projectname = ? and partnerId = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, project.getProjectName());
            statement.setString(2, partnerID);
            rs = statement.executeQuery();
            if (rs.next())
            {
                String startDate = rs.getString("startDate");
                finalProject = new Project(startDate.substring(0, 10), rs.getString("projectName"),
                        rs.getDouble("cost"), rs.getString("status"), rs.getString("description"), rs.getString("goal"), getPartner(rs.getString("partnerId")));
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
        } finally
        {
            statement.close();
            connection.close();

        }
        return finalProject;

    }

    public InputStream getUpload(Project project) throws SQLException
    {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        InputStream upload = null;

        try
        {

            Class.forName(DataOracleAccessor.DRIVER);

            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);
            int projectId = getProjectId(project);

            String query = "SELECT upload FROM files where projectid = ?";

            statement = connection.prepareStatement(query);
            statement.setInt(1, projectId);
            rs = statement.executeQuery();
            if (rs.next())
            {
                Blob blob = rs.getBlob("upload");
                InputStream input = blob.getBinaryStream();

//                upload = new FileInputStream(rs.getBinaryStream("upload").toString());
            }
        } catch (ClassNotFoundException ex)
        {
        } finally
        {
            statement.close();
            connection.close();

        }

        return upload;

    }

    public int getProjectId(Project project) throws SQLException
    {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        int projectId = 0;

        try
        {

            Class.forName(DataOracleAccessor.DRIVER);

            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            String partnerID = getPartnerID(project.getPartner().getPartnerName(), project.getPartner().getCountry());

            String query = "SELECT projectid FROM projects where projectname = ? and partnerId = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, project.getProjectName());
            statement.setString(2, partnerID);
            rs = statement.executeQuery();
            if (rs.next())
            {

                projectId = rs.getInt("projectId");
            }
        } catch (ClassNotFoundException ex)
        {
        } finally
        {
            statement.close();
            connection.close();

        }

        return projectId;
    }

    public String getPartnerID(String partnerName, String country) throws SQLException
    {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        String partnerId = null;
        try
        {

            Class.forName(DataOracleAccessor.DRIVER);

            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            String query = "SELECT * FROM partners where partnerName = ? and country = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, partnerName);
            statement.setString(2, country);
            rs = statement.executeQuery();

            if (rs.next())
            {

                partnerId = rs.getString("PARTNERID");
            }
        } catch (ClassNotFoundException ex)
        {
        } finally
        {
            statement.close();
            connection.close();

        }
        return partnerId;

    }

    public Partner getPartner(String userName) throws SQLException
    {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        Partner partner = null;
        try
        {

            Class.forName(DataOracleAccessor.DRIVER);

            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            Class.forName(DataOracleAccessor.DRIVER);

            String query = "SELECT partnername,country FROM partners where username =?";

            statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            rs = statement.executeQuery();

            if (rs.next())
            {
                partner = new Partner(rs.getString("partnerName"),rs.getString("country"));
            }
        } catch (ClassNotFoundException ex)
        {
        } finally
        {
            statement.close();
            connection.close();

        }
        return partner;

    }

    public void SaveProject(Project project) throws SQLException
    {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;

        try
        {

            Class.forName(DataOracleAccessor.DRIVER);

            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            //Til senere brug, når vi kommer over skal bruge den i en muligvis servlet med bruger input.
//            String query1 = "select * from partners";
//            statement = connection.prepareStatement(query1);
//            rs = statement.executeQuery(query1);
//            int partnerId = 0;
//            while (rs.next()) {
//                if (rs.getString("partnerName").equals(project.getPartner().getPartnerName()) && rs.getString("country").equals(project.getPartner().getCountry())) {
//                    partnerId = Integer.parseInt(rs.getString("partnerId"));
//                }
//            }
            String query = "insert into projects "
                    //                    + "(PROJECTID,STARTDATE,PROJECTNAME,COST,STATUS,DESCRIPTION,GOAL,PARTNERID)"

                    + " values (seq_id_project.nextval,to_date(?,'YYYY-MM-DD'),?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);

//          statement.setString(1, project.getPROJECT_ID());
            statement.setString(1, project.getStartDate());
            statement.setString(2, project.getProjectName());
            statement.setDouble(3, project.getCost());
            statement.setString(4, project.getStatus());
            statement.setString(5, project.getDescription());
            statement.setString(6, project.getGoal());
            statement.setString(7, getPartnerID(project.getPartner().getPartnerName(), project.getPartner().getCountry()));

            statement.executeUpdate();

            if (project.getUpload() != null)
            {
                FileInputStream file = new FileInputStream(project.getUpload());
                String query2 = "insert into files values (seq_id_files.nextval,?,?)";
                statement = connection.prepareStatement(query2);
                statement.setBinaryStream(1, file, (int) project.getUpload().length());
                statement.setInt(2, getProjectId(project));
//                statement.setBinaryStream(2, project.getUpload());
                statement.executeUpdate();
            }
//                   -----til senere brug (mis)------
//            FileInputStream in;
//            try {
//                in = new FileInputStream(project.getUpload());
//
//                String query2 = "insert into files (projectid,upload) values (?,?)";
//
//                statement = connection.prepareStatement(query);
//                statement.setString(1, project.getPROJECT_ID());
//                statement.setBinaryStream(2, in);
//
//                //=== Execute the query and receive the result
//                statement.executeUpdate();
//            } catch (FileNotFoundException e) {
//
//            }
        } catch (ClassNotFoundException | NullPointerException | FileNotFoundException ex)
        {
        } finally
        {
            statement.close();
            connection.close();

        }

    }

    public boolean getLogin(String usrName, String password) throws SQLException
    {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        boolean returnVariable  = false;

        try
        {

            Class.forName(DataOracleAccessor.DRIVER);

            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            Class.forName(DataOracleAccessor.DRIVER);


            String query = "SELECT * FROM USERS where username =? and password =?";
            

            statement = connection.prepareStatement(query);
            statement.setString(1, usrName);
            statement.setString(2, password);
            rs = statement.executeQuery();

            if (rs.next())
            {
                returnVariable = true;
            }
           
        } catch (ClassNotFoundException ex)
        {
        } finally
        {
            statement.close();
            connection.close();

        }
        return returnVariable;

    }

    public void SaveLogin(String username, String password, int partnerOrDel) throws SQLException
    {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;

        try
        {

            Class.forName(DataOracleAccessor.DRIVER);

            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            String query = "insert into users values (?,?,?)";

            statement = connection.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setDouble(3, partnerOrDel);

            statement.executeUpdate();

        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            statement.close();
            connection.close();
        }

    }
}
