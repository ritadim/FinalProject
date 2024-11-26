package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    // Method name: getCredentials
    // Method parameters: String - the SQL query to execute for fetching credentials
    // Method return: List of strings
    @Step("get credentials from database")
    public static List<String> getCredentials(String query){

        // List to store the retrieved credentials.
        List<String> credentials = new ArrayList<String>();

        try {
            // Executes the provided SQL query and stores the result in 'rs' (ResultSet).
            rs = stmt.executeQuery(query);

            // Iterates through the ResultSet to retrieve each record
            while (rs.next()){
                // Adds the first column value from the current row to the credentials list.
                credentials.add(rs.getString(1));
            }
        }
        catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
        return credentials;
    }
}