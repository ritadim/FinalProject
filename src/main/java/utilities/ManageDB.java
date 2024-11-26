package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps{


    // Opens a connection to the specified database.
    // param dbURL - The URL of the database.
    // param: user - The username for the database.
    // param: pass - The password for the database.
    public static void openConnection(String dbURL, String user, String pass){
        try {
            // Load the MySQL database driver class dynamically
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database using the provided credentials
            con = DriverManager.getConnection(dbURL,user,pass);

            // Create a Statement object to execute SQL queries
            stmt = con.createStatement();
        }
        catch (Exception e) {
            // Handle and log any exceptions during the connection process
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
    }
    // Closes the database connection
    public static void closeConnection(){
        try {
            // Close the database connection if it's open
            con.close();
        }
        catch(SQLException e) {
            // Handle and log any exceptions during the closure process
            System.out.println("Error Occurred While Closing JDBC, See Details: " + e);
        }
    }
}