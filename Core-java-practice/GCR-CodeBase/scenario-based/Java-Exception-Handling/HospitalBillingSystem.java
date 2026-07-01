import java.util.Scanner;

class InsufficientFundsException extends Exception {
    double requiredAmount;
    double availableAmount;

    InsufficientFundsException(double required, double available) {
        super("Payment failed! Required: ₹" + required + ", Available: ₹" + available);
        this.requiredAmount = required;
        this.availableAmount = available;
    }

    double getShortfall() {
        return requiredAmount - availableAmount;
    }
}

class Patient {
    String patientId;
    String name;
    double balance;
    int itemCount;
    double totalAmount;

    Patient(String patientId, String name, double balance, int itemCount, double totalAmount) {
        this.patientId = patientId;
        this.name = name;
        this.balance = balance;
        this.itemCount = itemCount;
        this.totalAmount = totalAmount;
    }
}

class HospitalBillingSystem {
    static Patient[] patients = new Patient[10];
    static int patientCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Hospital Billing System ===\n");

        while (true) {
            System.out.println("1. Add Patient");
            System.out.println("2. Calculate Bill");
            System.out.println("3. Process Payment");
            System.out.println("4. View Patient");
            System.out.println("5. Exit");
            System.out.print("\nSelect option (1-5): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addPatient(scanner);
                    break;
                case "2":
                    calculateBill(scanner);
                    break;
                case "3":
                    processPayment(scanner);
                    break;
                case "4":
                    viewPatient(scanner);
                    break;
                case "5":
                    System.out.println("Thank you for using Hospital Billing System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.\n");
            }
        }
    }

    static void addPatient(Scanner scanner) {
        System.out.println("\n--- Add Patient ---\n");

        try {
            if (patientCount >= 10) {
                System.out.println("❌ Cannot add more patients. System full.\n");
                return;
            }

            System.out.print("Enter Patient ID: ");
            String patientId = scanner.nextLine().trim();

            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Account Balance: ₹");
            double balance = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Enter Number of Items: ");
            int itemCount = Integer.parseInt(scanner.nextLine().trim());

            if (itemCount == 0) {
                throw new ArithmeticException("Cannot bill a patient with zero items!");
            }

            System.out.print("Enter Total Amount: ₹");
            double totalAmount = Double.parseDouble(scanner.nextLine().trim());

            patients[patientCount] = new Patient(patientId, name, balance, itemCount, totalAmount);
            patientCount++;

            System.out.println("✓ Patient added successfully!\n");

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input format! Please enter valid numbers.\n");
        } catch (ArithmeticException e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        }
    }

    static void calculateBill(Scanner scanner) {
        System.out.println("\n--- Calculate Bill ---\n");

        try {
            System.out.print("Enter Patient Index (0-" + (patientCount - 1) + "): ");
            int index = Integer.parseInt(scanner.nextLine().trim());

            if (index < 0 || index >= patientCount) {
                throw new ArrayIndexOutOfBoundsException("Patient index " + index + " is out of bounds! Valid range: 0-" + (patientCount - 1));
            }

            Patient patient = patients[index];

            double billPerItem = calculateBillPerItem(patient.totalAmount, patient.itemCount);

            System.out.println("\n--- Bill Details ---");
            System.out.println("Patient ID: " + patient.patientId);
            System.out.println("Patient Name: " + patient.name);
            System.out.println("Total Amount: ₹" + patient.totalAmount);
            System.out.println("Number of Items: " + patient.itemCount);
            System.out.println("Bill per Item: ₹" + String.format("%.2f", billPerItem));
            System.out.println("Account Balance: ₹" + patient.balance + "\n");

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Please enter a valid number.\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        } catch (ArithmeticException e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        }
    }

    static double calculateBillPerItem(double totalAmount, int itemCount) throws ArithmeticException {
        if (itemCount == 0) {
            throw new ArithmeticException("Division by zero! Cannot calculate bill with zero items.");
        }
        return totalAmount / itemCount;
    }

    static void processPayment(Scanner scanner) {
        System.out.println("\n--- Process Payment ---\n");

        try {
            System.out.print("Enter Patient Index (0-" + (patientCount - 1) + "): ");
            int index = Integer.parseInt(scanner.nextLine().trim());

            if (index < 0 || index >= patientCount) {
                throw new ArrayIndexOutOfBoundsException("Patient index " + index + " is out of bounds! Valid range: 0-" + (patientCount - 1));
            }

            Patient patient = patients[index];

            System.out.print("Enter Payment Amount: ₹");
            double paymentAmount = Double.parseDouble(scanner.nextLine().trim());

            if (paymentAmount > patient.balance) {
                throw new InsufficientFundsException(paymentAmount, patient.balance);
            }

            patient.balance -= paymentAmount;

            System.out.println("\n✓ Payment successful!");
            System.out.println("Amount Paid: ₹" + paymentAmount);
            System.out.println("Remaining Balance: ₹" + patient.balance + "\n");

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Please enter valid numbers.\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        } catch (InsufficientFundsException e) {
            System.out.println("❌ " + e.getMessage());
            System.out.println("Shortfall: ₹" + e.getShortfall() + "\n");
        }
    }

    static void viewPatient(Scanner scanner) {
        System.out.println("\n--- View Patient ---\n");

        try {
            System.out.print("Enter Patient Index (0-" + (patientCount - 1) + "): ");
            int index = Integer.parseInt(scanner.nextLine().trim());

            if (index < 0 || index >= patientCount) {
                throw new ArrayIndexOutOfBoundsException("Patient index " + index + " is out of bounds! Valid range: 0-" + (patientCount - 1));
            }

            Patient patient = patients[index];

            System.out.println("\n--- Patient Information ---");
            System.out.println("Patient ID: " + patient.patientId);
            System.out.println("Name: " + patient.name);
            System.out.println("Balance: ₹" + patient.balance);
            System.out.println("Items: " + patient.itemCount);
            System.out.println("Total Amount: ₹" + patient.totalAmount + "\n");

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input! Please enter a valid number.\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Error: " + e.getMessage() + "\n");
        }
    }
}
