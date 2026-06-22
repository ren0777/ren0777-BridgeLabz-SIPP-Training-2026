import java.io.*;

public class SchoolResultPortal {

    public static void main(String[] args) {

        try (
                BufferedReader br = new BufferedReader(
                        new FileReader("students.txt"));

                FileWriter fw = new FileWriter("report.txt", true);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(" ");

                String name = data[0];

                int sum = 0;

                for (int i = 1; i < data.length; i++) {
                    sum += Integer.parseInt(data[i]);
                }

                double average = (double) sum / (data.length - 1);

                bw.write("Student: " + name);
                bw.newLine();

                bw.write("Average: " + average);
                bw.newLine();

                bw.write("----------------------");
                bw.newLine();
            }

            System.out.println("Report generated successfully.");

        } catch (FileNotFoundException e) {

            System.out.println("Student file not found.");

        } catch (IOException e) {

            System.out.println("Error while processing file.");
        }
    }
}