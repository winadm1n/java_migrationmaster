import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PropellantInventoryReport {
    
    public static void main(String[] args) {
        new PropellantInventoryReport().generateReports();
    }
    
    private void generateReports() {
        try {
            generateReport("INALL", "RPTALL", "PROPELLANT GRAIN INVENTORY REPORT - ALL");
            generateReport("INACT", "RPTACT", "PROPELLANT GRAIN INVENTORY REPORT - ACTIVE");
            generateReport("INSPN", "RPTSPN", "PROPELLANT GRAIN INVENTORY REPORT - SPENT");
            generateReport("INDES", "RPTDES", "PROPELLANT GRAIN INVENTORY REPORT - DESTROYED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void generateReport(String inputFile, String outputFile, String header) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            
            // Write header
            writer.write("HAYNIE RESEARCH & DEVELOPMENT\n");
            writer.write(header + "\n");
            writer.write("REPORT DATE:"); // Append date here
            
            // Write column headers
            writer.write("SERIAL       STATUS    TYPE       FORMULA            QA   WEIGHT\n");
            writer.write("------------ ---------- ---------- --------------- ---- ----------\n");
            
            // Read input file and write to output file
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\s+");
                String status = getStatus(fields[3]);
                writer.write(fields[0] + " " + status + " " + fields[1] + " " + fields[2] + " " + fields[4] + " " + fields[8] + "G\n");
            }
        }
    }
    
    private String getStatus(String code) {
        switch (code) {
            case "0":
                return "ACTIVE";
            case "1":
                return "SPENT";
            case "3":
                return "DESTROYED";
            default:
                return "OTHER";
        }
    }
}
