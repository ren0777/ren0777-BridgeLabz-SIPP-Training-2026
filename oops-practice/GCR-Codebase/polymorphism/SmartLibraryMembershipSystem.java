import java.util.Scanner;

class LibraryMember {
    protected String memberName;
    protected String memberId;
    protected int booksIssued;

    public LibraryMember(String memberName, String memberId, int booksIssued) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.booksIssued = booksIssued;
    }

    public double calculateFine(int overdueDays) {
        return overdueDays * 5.0;
    }

    public void displayDetails() {
        System.out.println("Name: " + memberName);
        System.out.println("Member ID: " + memberId);
        System.out.println("Books Issued: " + booksIssued);
    }

    public String getMemberId() {
        return memberId;
    }
}

class StudentMember extends LibraryMember {
    private String studentId;
    private String department;

    public StudentMember(String memberName, String memberId, int booksIssued, String studentId, String department) {
        super(memberName, memberId, booksIssued);
        this.studentId = studentId;
        this.department = department;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.0;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Student Member ===");
        super.displayDetails();
        System.out.println("Student ID: " + studentId);
        System.out.println("Department: " + department);
        System.out.println("Membership Type: Student");
    }
}

class FacultyMember extends LibraryMember {
    private String faculty;
    private String designation;

    public FacultyMember(String memberName, String memberId, int booksIssued, String faculty, String designation) {
        super(memberName, memberId, booksIssued);
        this.faculty = faculty;
        this.designation = designation;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 3.0;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Faculty Member ===");
        super.displayDetails();
        System.out.println("Faculty: " + faculty);
        System.out.println("Designation: " + designation);
        System.out.println("Membership Type: Faculty");
    }
}

class GuestMember extends LibraryMember {
    private String registrationDate;
    private int maxBooksAllowed;

    public GuestMember(String memberName, String memberId, int booksIssued, String registrationDate, int maxBooksAllowed) {
        super(memberName, memberId, booksIssued);
        this.registrationDate = registrationDate;
        this.maxBooksAllowed = maxBooksAllowed;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 10.0;
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Guest Member ===");
        super.displayDetails();
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Max Books Allowed: " + maxBooksAllowed);
        System.out.println("Membership Type: Guest");
    }
}

public class SmartLibraryMembershipSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Smart Library Membership System ===\n");

        LibraryMember[] members = new LibraryMember[7];
        members[0] = new StudentMember("Raj Kumar", "MEM001", 5, "STU001", "Computer Science");
        members[1] = new FacultyMember("Dr. Smith", "MEM002", 10, "Science", "Professor");
        members[2] = new GuestMember("John Doe", "MEM003", 2, "2024-01-15", 3);
        members[3] = new StudentMember("Priya Singh", "MEM004", 4, "STU002", "Electronics");
        members[4] = new FacultyMember("Dr. Johnson", "MEM005", 12, "Engineering", "Associate Professor");
        members[5] = new GuestMember("Alice Johnson", "MEM006", 1, "2024-02-20", 2);
        members[6] = new StudentMember("Mike Brown", "MEM007", 6, "STU003", "Mechanical");

        System.out.println("--- All Members ---\n");
        for (int i = 0; i < members.length; i++) {
            System.out.println("Member " + (i + 1) + ":");
            members[i].displayDetails();
            System.out.println();
        }

        System.out.println("--- Fine Calculation (Overdue: 5 days) ---\n");
        int overdueDays = 5;
        for (LibraryMember member : members) {
            double fine = member.calculateFine(overdueDays);
            System.out.println(member.memberName + " (" + member.memberId + "): Fine = $" + String.format("%.2f", fine));
        }

        System.out.println("\n--- Search Member by ID ---");
        String searchId = "MEM002";
        LibraryMember foundMember = null;
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(searchId)) {
                foundMember = member;
                break;
            }
        }

        if (foundMember != null) {
            System.out.println("\nMember Found:");
            foundMember.displayDetails();
            System.out.println("\nFine for 7 overdue days: $" + String.format("%.2f", foundMember.calculateFine(7)));
        } else {
            System.out.println("Member with ID " + searchId + " not found.");
        }

        System.out.println("\n--- Membership Statistics ---");
        int studentCount = 0, facultyCount = 0, guestCount = 0;
        for (LibraryMember member : members) {
            if (member instanceof StudentMember) {
                studentCount++;
            } else if (member instanceof FacultyMember) {
                facultyCount++;
            } else if (member instanceof GuestMember) {
                guestCount++;
            }
        }

        System.out.println("Student Members: " + studentCount);
        System.out.println("Faculty Members: " + facultyCount);
        System.out.println("Guest Members: " + guestCount);
        System.out.println("Total Members: " + members.length);

        sc.close();
    }
}
