import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVFileReader implements FileReaderStrategy  {

    public List<String[]> readFile(String filePath) {

        List<String[]> dataStore = new ArrayList<>();
        try {
            File file = new File("input_file-1.csv");
            Scanner sc = new Scanner(file);
            if (sc.hasNextLine()) {
                sc.nextLine(); 
            }

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split(",");
                dataStore.add(values);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataStore;
    }
    
    
    public void writeFile(List<String[]> output, String outputPath) {
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(outputPath);
            // Writing the header
            csvWriter.append("cardNumber,cardType\n");

            // Writing the data
            for (String[] data : output) {
                csvWriter.append(String.join(",", data));
                csvWriter.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (csvWriter != null) {
                    csvWriter.flush();
                    csvWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
