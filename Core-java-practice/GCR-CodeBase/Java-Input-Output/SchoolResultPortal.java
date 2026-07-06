import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class SchoolResultPortal {
    private static final String INPUT_FILE = "students.txt";
    private static final String OUTPUT_FILE = "report_card.txt";

    public static void main(String[] args) {
        generateReport();
    }

    static void generateReport() {
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
             BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {

            String line;
            bw.write("===== New Report Batch =====");
            bw.newLine();

            while ((line = br.readLine()) != null) {
                // Expected line format: Name 78 88 91
                String[] parts = line.trim().split("\\s+");
                if (parts.length < 2) {
                    continue;
                }

                String name = parts[0];
                int total = 0;
                int markCount = 0;

                for (int i = 1; i < parts.length; i++) {
                    total += Integer.parseInt(parts[i]);
                    markCount++;
                }

                double average = (double) total / markCount;

                bw.write("Student: " + name);
                bw.newLine();
                bw.write("Average: " + String.format("%.2f", average));
                bw.newLine();
                bw.write("---------------------------");
                bw.newLine();
            }

            bw.newLine();
            System.out.println("Report card generated and appended to " + OUTPUT_FILE);

        } catch (FileNotFoundException e) {
            System.out.println("Student file not found: " + INPUT_FILE);
        } catch (IOException e) {
            System.out.println("I/O error while processing files: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid marks format found in input file.");
        }
    }
}
