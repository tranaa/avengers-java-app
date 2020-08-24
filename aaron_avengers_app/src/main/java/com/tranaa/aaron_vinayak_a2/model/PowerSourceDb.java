
package com.tranaa.aaron_vinayak_a2.model;

import com.tranaa.aaron_vinayak_a2.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class for power source database
 * @author Aaron Tran
 */
public class PowerSourceDb {
    
        /**
        * function to get avenger power source from db
        * @param id
        * @return power source
        * @throws java.lang.Exception
        */
        public static PowerSource getPowerSource(int id) throws Exception{
        //Declare Objects here so we can close them
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        PowerSource powerSource = null;
        
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
            String sql = "SELECT * FROM powersource where id = " + id;
            
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            //get power source or return exception
            if (rs.next()) {
                powerSource = new PowerSource(rs.getInt("id"), rs.getString("description"));           
            } else {
                throw new Exception("No powers found!");
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
        return powerSource;
    }
    
    /**
    * function returns array list of power sources
    * @return power source array list
    * @throws java.lang.Exception
    */
    public static ArrayList<PowerSource> getPowerSources() throws Exception{
        //Declare Objects here so we can close them
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        ArrayList<PowerSource> powerSources = new ArrayList<>();

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
            String sql = "SELECT * FROM powersource";

            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            //iterate result statement for power sources
            while (rs.next()) {
                PowerSource powerSource = new PowerSource(
                        rs.getInt("id"), 
                        rs.getString("description"));
                powerSources.add(powerSource);
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
        return powerSources;
    }
    
    /**
    * function returns array list of unused power sources
    * @return unused power source array list
    * @throws java.lang.Exception
    */
    public static ArrayList<PowerSource> getUnusedPowerSources() throws Exception{
        //Declare Objects here so we can close them
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;

        ArrayList<PowerSource> powerSources = new ArrayList<>();

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
            String sql = "Select powersource.id, powersource.description from powersource left join avengers on powersource.id = avengers.id where avengername is null;";
            
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            
            //iterate result statement for power sources
            while (rs.next()) {
                PowerSource powerSource = new PowerSource(
                        rs.getInt("id"), 
                        rs.getString("description"));
                powerSources.add(powerSource);
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
        return powerSources;
    }

    /**
    * function to add a power source to db
    * @param powerSource
    * @return int number of rows affected
    * @throws java.lang.Exception
    */
    public static int addPowerSource(String powerSource) throws Exception{
        //Declare Objects here so we can close them
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            //id for power source
            int id = 1 + getPowerSources().size();
            
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
            String sql = "INSERT INTO powersource (id, description) VALUES (?, ?);";
            
            ps = conn.prepareStatement(sql);
            
            // set parameter values
            ps.setInt(1, id);
            ps.setString(2, powerSource);
            
            //rows affected
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

    //
    /**
    * function to delete power source from database
    * @param powerSourceId
    * @return int number of rows affected
    * @throws java.lang.Exception
    */
    public static int deletePowerSource(int powerSourceId) throws Exception{
        //Declare Objects here so we can close them
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
            String sql = "DELETE FROM powersource WHERE powersource.id = ?";
            
            ps = conn.prepareStatement(sql);
            
            // set parameter values
            ps.setInt(1, powerSourceId);
            
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
