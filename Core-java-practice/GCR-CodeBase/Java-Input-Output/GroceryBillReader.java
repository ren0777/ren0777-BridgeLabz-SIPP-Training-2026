import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class GroceryBillReader {
    private static final String BILL_FILE = "bill.txt";

    public static void main(String[] args) {
        int lineCount = 0;

        try (FileReader fr = new FileReader(BILL_FILE);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            System.out.println("Bill Contents:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lineCount++;
            }

            System.out.println("Total number of lines = " + lineCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + BILL_FILE);
        } catch (IOException e) {
            System.out.println("Error reading bill file: " + e.getMessage());
        }
    }
}
