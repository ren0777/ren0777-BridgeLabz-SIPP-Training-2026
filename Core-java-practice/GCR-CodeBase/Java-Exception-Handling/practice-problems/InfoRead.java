// Problem 5: try-with-resources
// Read the first line of info.txt using BufferedReader.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InfoRead {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            String firstLine = reader.readLine();
            System.out.println(firstLine);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
