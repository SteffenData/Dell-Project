/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.data;

import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
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

/**
 *
 * @author steffen
 */
public class DataManager {

     public static ArrayList<Project> getDellProjects(Partner partner) throws ClassNotFoundException, SQLException{
    ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        ArrayList<Project> dellProjects = null;

        try {
            //=== Load the JDBC-driver
            Class.forName(DataOracleAccessor.DRIVER);

            //=== Connect to the database
            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            String partnerID = DataManager.getPartnerID(partner.getPartnerName(), partner.getCountry());
            //==== Instantiate a statement object 

            //=== Build an SQL-query-statement
            String query = "SELECT * FROM projects order by Startdate";

            statement = connection.prepareStatement(query);
            //=== Execute the query and receive the result
            statement.setString(1, partnerID);
            rs = statement.executeQuery();
            while (rs.next()) {

                dellProjects.add(new Project(rs.getString("startDate"), rs.getString("projectName"),
                        rs.getDouble("cost"), rs.getString("status"), rs.getString("description"), rs.getString("goal")));
            }
        } //=== If database driver is unavailable or query fails
        //=== Always close the statement and connection
        finally {
            statement.close();
            connection.close();

        }
        return dellProjects;

    }
    public static ArrayList<Project> getPartnerProjects(Partner partner) throws ClassNotFoundException, SQLException{
    ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        ArrayList<Project> partnerProjects = null;

        try {
            //=== Load the JDBC-driver
            Class.forName(DataOracleAccessor.DRIVER);

            //=== Connect to the database
            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            String partnerID = DataManager.getPartnerID(partner.getPartnerName(), partner.getCountry());
            //==== Instantiate a statement object 

            //=== Build an SQL-query-statement
            String query = "SELECT * FROM projects where partnerId = ? order by Startdate";

            statement = connection.prepareStatement(query);
            //=== Execute the query and receive the result
            statement.setString(1, partnerID);
            rs = statement.executeQuery();
            while (rs.next()) {

                partnerProjects.add(new Project(rs.getString("startDate"), rs.getString("projectName"),
                        rs.getDouble("cost"), rs.getString("status"), rs.getString("description"), rs.getString("goal")));
            }
        } //=== If database driver is unavailable or query fails
        //=== Always close the statement and connection
        finally {
            statement.close();
            connection.close();

        }
        return partnerProjects;

    }
    public static Project getProject(Project project, Partner partner) throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        Project finalProject = null;

        try {
            //=== Load the JDBC-driver
            Class.forName(DataOracleAccessor.DRIVER);

            //=== Connect to the database
            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            String partnerID = DataManager.getPartnerID(partner.getPartnerName(), partner.getCountry());
            //==== Instantiate a statement object 

            //=== Build an SQL-query-statement
            String query = "SELECT * FROM projects where projectname = ? and partnerId = ?";

            statement = connection.prepareStatement(query);
            //=== Execute the query and receive the result
            statement.setString(1, project.getProjectName());
            statement.setString(2, partnerID);
            rs = statement.executeQuery();
            if (rs.next()) {
                String startDate = rs.getString("startDate");
                
                finalProject = new Project(startDate.substring(0,10), rs.getString("projectName"),
                        rs.getDouble("cost"), rs.getString("status"), rs.getString("description"), rs.getString("goal"));
            }
        } //=== If database driver is unavailable or query fails
        //=== Always close the statement and connection
        finally {
            statement.close();
            connection.close();

        }
        return finalProject;

    }
    
    public static InputStream getUpload(Project project,Partner partner) throws ClassNotFoundException, SQLException, FileNotFoundException{
    
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        InputStream upload = null;

        try {
            //=== Load the JDBC-driver
            Class.forName(DataOracleAccessor.DRIVER);

            //=== Connect to the database
            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);
            int projectId = getProjectId(project, partner);
           
            //==== Instantiate a statement object 

            //=== Build an SQL-query-statement
            String query = "SELECT upload FROM files where projectid = ?";

            statement = connection.prepareStatement(query);
            //=== Execute the query and receive the result
            statement.setInt(1, projectId);
            rs = statement.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob("upload");
                InputStream input = blob.getBinaryStream();
                
                
//                upload = new FileInputStream(rs.getBinaryStream("upload").toString());
                  
            }
        } //=== If database driver is unavailable or query fails
        //=== Always close the statement and connection
        finally {
            statement.close();
            connection.close();

        }
    
    return upload;
    
    }
    
    
    
    public static int getProjectId (Project project,Partner partner) throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        int projectId = 0;

        try {
            //=== Load the JDBC-driver
            Class.forName(DataOracleAccessor.DRIVER);

            //=== Connect to the database
            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            String partnerID = DataManager.getPartnerID(partner.getPartnerName(), partner.getCountry());
            //==== Instantiate a statement object 

            //=== Build an SQL-query-statement
            String query = "SELECT projectid FROM projects where projectname = ? and partnerId = ?";

            statement = connection.prepareStatement(query);
            //=== Execute the query and receive the result
            statement.setString(1, project.getProjectName());
            statement.setString(2, partnerID);
            rs = statement.executeQuery();
            if (rs.next()) {

               projectId = rs.getInt("projectId");
            }
        } //=== If database driver is unavailable or query fails
        //=== Always close the statement and connection
        finally {
            statement.close();
            connection.close();

        }
      
        return projectId;
    }
    
    

    public static String getPartnerID(String partnerName, String country) throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        String partnerId = null;
        try {

            //=== Load the JDBC-driver
            Class.forName(DataOracleAccessor.DRIVER);

            //=== Connect to the database
            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            //=== Build an SQL-query-statement
            String query = "SELECT * FROM partners where partnerName = ? and country = ?";

            //==== Instantiate a statement object 
            statement = connection.prepareStatement(query);
            statement.setString(1, partnerName);
            statement.setString(2, country);

            //=== Execute the query and receive the result
            rs = statement.executeQuery();
            
            
            if (rs.next()) {

                partnerId = rs.getString("PARTNERID");

            }

        } //=== If database driver is unavailable or query fails
        //=== Always close the statement and connection
        finally {
            statement.close();
            connection.close();

        }
        return partnerId;

    }

    public static void SaveProject(Project project,Partner partner) throws ClassNotFoundException, NullPointerException, SQLException, FileNotFoundException {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
       

        try {
            //=== Load the JDBC-driver
            Class.forName(DataOracleAccessor.DRIVER);

            //=== Connect to the database
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
            //=== Build an SQL-query-statement
            String query = "insert into projects "
//                    + "(PROJECTID,STARTDATE,PROJECTNAME,COST,STATUS,DESCRIPTION,GOAL,PARTNERID)"
//                    + " values (seq_id_project.nextval,?,?,?,?,?,?,?)";
            
            + " values (seq_id_project.nextval,to_date(?,'YYYY-MM-DD'),?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);

//            statement.setString(1, project.getPROJECT_ID());
            statement.setString(1, project.getStartDate());
            statement.setString(2, project.getProjectName());
            statement.setDouble(3, project.getCost());
            statement.setString(4, project.getStatus());
            statement.setString(5, project.getDescription());
            statement.setString(6, project.getGoal());
            statement.setString(7, getPartnerID(partner.getPartnerName(), partner.getCountry()));
            //==== Instantiate a statement object 

            //=== Execute the query and receive the result
            statement.executeUpdate();
            
            if(project.getUpload() != null)
            {
                FileInputStream file = new FileInputStream(project.getUpload());
                String query2 = "insert into files values (seq_id_files.nextval,?,?)";
                statement = connection.prepareStatement(query2);
                statement.setBinaryStream(1,file,(int)project.getUpload().length());
                statement.setInt(2,getProjectId(project,partner));
//                statement.setBinaryStream(2, project.getUpload());
                statement.executeUpdate();
            }
                
            
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
            //=== read the result

        } finally {
            statement.close();
            connection.close();

        }

    }
}
