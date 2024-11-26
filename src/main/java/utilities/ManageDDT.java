package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;


public class ManageDDT extends CommonOps{

    // Method name: getDataObject
    // Method description: Data Provider for TestNG to supply test data
    // Method return: 2D Object array (containing data from a CSV file)
    @DataProvider(name = "data-provider-productPrices")
    public Object[][] getDataObject(){
        // Fetches test data from the CSV file whose path is defined in the DataConfig.xml file
        return getDataFromCSV(getData("DDTFile"));
    }


    // Method name: readCSV
    // Method description: Reads all lines from a CSV file and returns them as a list of strings.
    // Method parameters: String
    // Method return:a List of strings, where each string represents a line from the CSV file.
    public static List<String> readCSV(String csvFile){
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            // Reads all lines from the CSV file using UTF-8 encoding.
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    // Method name: getDataFromCSV
    // Method description: converts data from a CSV file into a 2D Object array for TestNG compatibility.
    // Method parameters: String
    // Method return: 2D Object array
    public static Object[][] getDataFromCSV(String filePath){
        // Initializes a 2D Object array to hold 15 rows with 2 columns each.
        Object[][] data = new Object[15][2];

        // Reads the lines from the CSV file.
        List<String> csvData = readCSV(filePath);

        for(int i = 0; i < csvData.size(); i++){
            data[i][0] = csvData.get(i).split(",")[0]; // First column
            data[i][1] = csvData.get(i).split(",")[1]; // Second column
        }
        return data;
    }
}