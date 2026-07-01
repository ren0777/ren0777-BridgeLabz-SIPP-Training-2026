// Sample Program 7: Hospital Management System
// Concepts: static, this, final, instanceof

public class Patient {

    // 1. STATIC – hospitalName and totalPatients shared across all instances
    static String hospitalName  = "City Care Hospital";
    static int    totalPatients = 0;

    // 3. FINAL – patientID is a permanent unique identifier, cannot be changed
    final String patientID;

    String name;
    int    age;
    String ailment;
    boolean admitted;

    // 2. THIS – resolves ambiguity for name, age, ailment
    Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;     // 'this' used for all four fields
        this.name      = name;
        this.age       = age;
        this.ailment   = ailment;
        this.admitted  = true;
        totalPatients++;
    }

    void discharge() {
        admitted = false;
        System.out.println("Patient " + name + " (ID: " + patientID + ") has been discharged.");
        totalPatients--;
    }

    void updateAilment(String newAilment) {
        System.out.println("Ailment updated for " + name + ": "
                         + ailment + " → " + newAilment);
        this.ailment = newAilment;
    }

    void display() {
        System.out.println("Hospital  : " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name      : " + name);
        System.out.println("Age       : " + age);
        System.out.println("Ailment   : " + ailment);
        System.out.println("Status    : " + (admitted ? "Admitted" : "Discharged"));
    }

    // 1. STATIC METHOD
    static void getTotalPatients() {
        System.out.println("Hospital       : " + hospitalName);
        System.out.println("Total Patients : " + totalPatients);
    }

    public static void main(String[] args) {

        Patient p1  = new Patient("PAT-001", "Deepa Joshi",  45, "Diabetes");
        Patient p2  = new Patient("PAT-002", "Suresh Kumar", 60, "Hypertension");
        Patient p3  = new Patient("PAT-003", "Meena Lal",    30, "Fracture");
        Object     obj = new Object();   // plain Object, not a Patient

        System.out.println("=== Patient 1 ===");
        // 4. INSTANCEOF – validate before displaying details
        if (p1 instanceof Patient) {
            p1.display();
        }

        System.out.println("\n=== Patient 2 – Update Ailment ===");
        if (p2 instanceof Patient) {
            p2.display();
            p2.updateAilment("Hypertension + Diabetes");
            System.out.println("After update:");
            p2.display();
        }

        System.out.println("\n=== Patient 3 – Discharge ===");
        if (p3 instanceof Patient) {
            p3.display();
            p3.discharge();
        }

        System.out.println("\n=== instanceof check on plain Object ===");
        if (!(obj instanceof Patient)) {
            System.out.println("Object is NOT a Patient instance. Skipping display.");
        }

        System.out.println();
        Patient.getTotalPatients();   // static method call (reflects discharge)

        // Prove final – uncommenting causes compile error:
        // p1.patientID = "PAT-999";   // ERROR: cannot assign a value to final variable
    }
}
