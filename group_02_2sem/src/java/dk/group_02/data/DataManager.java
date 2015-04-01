/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.data;

import static com.sun.javafx.scene.CameraHelper.project;
import dk.group_02.Entity.Partner;
import dk.group_02.Entity.Project;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author steffen
 */
public class DataManager {

    public static Project getProject() throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        Statement statement = null;
        Connection connection = null;

        try {
            //=== Load the JDBC-driver
            Class.forName(DataOracleAccessor.DRIVER);

            //=== Connect to the database
            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            //==== Instantiate a statement object 
            statement = connection.createStatement();

            //=== Build an SQL-query-statement
            String query = "SELECT * FROM projects order by projectid";

            //=== Execute the query and receive the result
            rs = statement.executeQuery(query);

            //=== read the result
            while (rs.next()) {

            }
        } //=== If database driver is unavailable or query fails
        //=== Always close the statement and connection
        finally {
            statement.close();
            connection.close();

        }
        return null;

    }

    public static void SaveProject(Project project) throws ClassNotFoundException, SQLException {

        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        Partner partner = null;

        try {
            //=== Load the JDBC-driver
            Class.forName(DataOracleAccessor.DRIVER);

            //=== Connect to the database
            connection = DriverManager.getConnection(DataOracleAccessor.DB_URL, DataOracleAccessor.USERNAME, DataOracleAccessor.PASSWORD);

            //Til senere brug, når vi kommer over skal bruge den i en muligvis servlet med bruger input.
            String query1 = "select * from partners";
            statement = connection.prepareStatement(query1);
            rs = statement.executeQuery(query1);
            int partnerid = 0;
            while (rs.next()) {
                if (rs.getString("partnerName") == project.getPartner().getName() && rs.getString("country") == project.getPartner().getCountry()) {
                    partnerid = Integer.parseInt(rs.getString("partnerId"));
                }
            }

            partner = new Partner(rs.getString("partnerName"), rs.getString("country"));

            //=== Build an SQL-query-statement
            String query = "insert into projects (projectid,startdate,projectname,cost,status,description,goal,partnerid) values (?,?,?,?,?,?,?,?)";
            statement.setString(1, project.getProjectId());
            statement.setString(2, project.getStartDate());
            statement.setString(3, project.getProjectName());
            statement.setDouble(4, project.getCost());
            statement.setString(5, project.getStatus());
            statement.setString(6, project.getDescription());
            statement.setString(7, project.getGoal());
            statement.setString(8, "" + partnerid);
            //==== Instantiate a statement object 
            statement = connection.prepareStatement(query);

            //=== Execute the query and receive the result
            statement.executeUpdate();
            FileInputStream in;
            try {
                in = new FileInputStream(project.getUpload());

                String query2 = "insert into files (projectid,upload) values (?,?)";

                statement = connection.prepareStatement(query);
                statement.setString(1, project.getProjectId());
                statement.setBinaryStream(2, in);

                //=== Execute the query and receive the result
                statement.executeUpdate();
            } catch (FileNotFoundException e) {
            }
            //=== read the result

        } finally {
            statement.close();
            connection.close();

        }

    }
}
