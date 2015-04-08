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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author steffen
 */
public class DataManager {

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

                finalProject = new Project(rs.getString("startDate"), rs.getString("projectName"),
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

    public static void SaveProject(Project project,Partner partner) throws ClassNotFoundException, NullPointerException, SQLException {

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
