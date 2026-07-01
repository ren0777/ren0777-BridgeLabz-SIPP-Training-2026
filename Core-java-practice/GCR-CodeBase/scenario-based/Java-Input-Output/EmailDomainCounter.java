import java.io.*;
import java.util.*;

class EmailDomainCounter {
    static final String EMAIL_FILE = "employees_email.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Email Domain Counter ===\n");

        while (true) {
            System.out.println("1. Create Sample Email List");
            System.out.println("2. Analyze Email Domains");
            System.out.println("3. Add Email");
            System.out.println("4. Exit");
            System.out.print("\nSelect option (1-4): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createSampleEmailList();
                    break;
                case "2":
                    analyzeEmailDomains();
                    break;
                case "3":
                    addEmail(scanner);
                    break;
                case "4":
                    System.out.println("Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    static void createSampleEmailList() {
        System.out.println("\n--- Creating Sample Email List ---\n");

        String[] sampleEmails = {
            "rahul@gmail.com",
            "ankit@yahoo.com",
            "priya@gmail.com",
            "aditya@outlook.com",
            "neha@gmail.com",
            "rohan@yahoo.com",
            "deepak@gmail.com",
            "maya@rediffmail.com",
            "arjun@yahoo.com",
            "sneha@gmail.com"
        };

        try (FileWriter fw = new FileWriter(EMAIL_FILE);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (String email : sampleEmails) {
                bw.write(email);
                bw.newLine();
            }

            System.out.println("✓ Sample email list created!");
            System.out.println("✓ File: " + EMAIL_FILE + "\n");

        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage() + "\n");
        }
    }

    static void analyzeEmailDomains() {
        System.out.println("\n--- Email Domain Analysis ---\n");

        Map<String, Integer> domainCount = new HashMap<>();
        List<String> emails = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(EMAIL_FILE))) {

            String line;
            System.out.println("Employee Emails:");
            System.out.println("-".repeat(40));

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    emails.add(line);
                    System.out.println("  " + line);

                    String domain = extractDomain(line);
                    domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);
                }
            }

            System.out.println("-".repeat(40));
            System.out.println("Total Employees: " + emails.size());

            System.out.println("\n--- Domain Statistics ---\n");
            List<Map.Entry<String, Integer>> sortedDomains = new ArrayList<>(domainCount.entrySet());
            sortedDomains.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            for (Map.Entry<String, Integer> entry : sortedDomains) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " user(s)");
            }

            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println("❌ Email file not found: " + EMAIL_FILE);
            System.out.println("Please create sample email list first.\n");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage() + "\n");
        }
    }

    static void addEmail(Scanner scanner) {
        System.out.println("\n--- Add Email ---\n");

        System.out.print("Enter email address: ");
        String email = scanner.nextLine().trim();

        if (!isValidEmail(email)) {
            System.out.println("Invalid email format.\n");
            return;
        }

        try (FileWriter fw = new FileWriter(EMAIL_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(email);
            bw.newLine();

            String domain = extractDomain(email);
            System.out.println("✓ Email added successfully!");
            System.out.println("  Email: " + email);
            System.out.println("  Domain: " + domain + "\n");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage() + "\n");
        }
    }

    static String extractDomain(String email) {
        int atIndex = email.indexOf("@");
        if (atIndex != -1) {
            return email.substring(atIndex + 1);
        }
        return "unknown";
    }

    static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
}
