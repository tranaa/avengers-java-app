
package com.tranaa.aaron_vinayak_a2.model;

import com.tranaa.aaron_vinayak_a2.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * class for avenger db
 * @author Aaron Tran
 */
public class AvengerDb {
    
    /**
     * function to get array list of avengers from db
     * @return array list of avengers
     * @throws java.lang.Exception
     */
    public static ArrayList<Avenger> getAvengers() throws Exception{
        //Declare Objects here so we can close them
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        ArrayList<Avenger> avengers = new ArrayList<>();

        try {
            //localhost connection varialbes
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            String dbUrl = System.getenv("JDBC_DATABASE_URL");

            //database connection
            if (dbUrl != null && dbUrl.length() > 0) {
                conn = DBConnector.getConnection(driver, dbUrl);
            } else {
                String connUrl = "jdbc:postgresql://localhost/";
                String database = "MyDb";
                String user = "postgres";
                String pass = "admin";
                conn = DBConnector.getConnection(driver, connUrl, database, user, pass);
            }

            //sql query to select all avengers
            String sql = "SELECT * FROM avengers";
            
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            //iterate result set
            while (rs.next()) {
                Avenger avenger = new Avenger(
                        rs.getInt("id"), 
                        rs.getString("avengername"), 
                        rs.getString("description"), 
                        PowerSourceDb.getPowerSource(rs.getInt("powersource")));
                avengers.add(avenger);
            }
        } catch (ClassNotFoundException ex) {
            throw new Exception (ex.toString());
        } catch (SQLException ex) {
            throw new Exception (ex.toString());
        } catch (Exception ex) {
            throw new Exception (ex.toString());
        } finally {
            DBConnector.closeJDBCObjects(conn, ps, rs);
        }
        return avengers;
    }
    
    /**
     * function to add Avenger to db
     * @param avenger
     * @return int number of rows affected
     * @throws java.lang.Exception
     */
    public static int addAvenger(Avenger avenger) throws Exception{
        //Declare Objects here so we can close them
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            //avenger properties 
            int id = avenger.getId();
            String avengerName = avenger.getName();
            String description = avenger.getDescription();
            int powerSource = avenger.getPowerSource().getId();
            
            //database connection
            String driver = "org.postgresql.Driver";

            Class.forName(driver);
            
            String dbUrl = System.getenv("JDBC_DATABASE_URL");

            if (dbUrl != null && dbUrl.length() > 0) {
                conn = DBConnector.getConnection(driver, dbUrl);
            } else {
                String connUrl = "jdbc:postgresql://localhost/";
                String database = "MyDb";
                String user = "postgres";
                String pass = "admin";
                conn = DBConnector.getConnection(driver, connUrl, database, user, pass);
            }
            
            //sql statement
            String sql = "INSERT INTO Avengers (avengername, description, powersource) VALUES (?, ?, ?)";
            
            ps = conn.prepareStatement(sql);
            
            // set parameter values
            ps.setString(1, avengerName);
            ps.setString(2, description);
            ps.setInt(3, powerSource);
            
            int rows = ps.executeUpdate();
            
            return rows;

        } catch (ClassNotFoundException ex) {
            throw new Exception (ex.toString());
        } catch (SQLException ex) {
            throw new Exception (ex.toString());
        } catch (Exception ex) {
            throw new Exception (ex.toString());
        } finally {
            DBConnector.closeJDBCObjects(conn, ps, rs);
        }
    }

    /**
     * function to delete avenger from database
     * @param avengerId
     * @return int number of rows affect
     * @throws java.lang.Exception
     */
    public static int deleteAvenger(int avengerId) throws Exception {
        //intialize variables
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            //database connection
            String driver = "org.postgresql.Driver";

            Class.forName(driver);
            
            String dbUrl = System.getenv("JDBC_DATABASE_URL");

            if (dbUrl != null && dbUrl.length() > 0) {
                conn = DBConnector.getConnection(driver, dbUrl);
            } else {
                String connUrl = "jdbc:postgresql://localhost/";
                String database = "MyDb";
                String user = "postgres";
                String pass = "admin";
                conn = DBConnector.getConnection(driver, connUrl, database, user, pass);
            }
        
            //sql query
            String sql = "DELETE FROM avengers WHERE avengers.id = ?";
            
            ps = conn.prepareStatement(sql);
            
            // set parameter values
            ps.setInt(1, avengerId);
            
            //returns number of rows affected
            int rows = ps.executeUpdate();
            
            return rows;

        } catch (ClassNotFoundException ex) {
            throw new Exception (ex.toString());
        } catch (SQLException ex) {
            throw new Exception (ex.toString());
        } catch (Exception ex) {
            throw new Exception (ex.toString());
        } finally {
            DBConnector.closeJDBCObjects(conn, ps, rs);
        }
    }

}
