import java.util.Scanner;

/**
 * Program to display a calendar for a given month and year
 */
public class CalendarDisplay {
    
    private static final String[] MONTHS = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    
    private static final String[] DAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    /**
     * Check if a year is a leap year
     * @param year The year to check
     * @return true if leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * Get the number of days in a month
     * @param month Month number (1-12)
     * @param year Year
     * @return Number of days in the month
     */
    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return DAYS_IN_MONTH[month - 1];
    }
    
    /**
     * Get the name of the month
     * @param month Month number (1-12)
     * @return Name of the month
     */
    public static String getMonthName(int month) {
        return MONTHS[month - 1];
    }
    
    /**
     * Get the first day of the month using Gregorian calendar algorithm
     * Algorithm: 
     * y0 = y - (14 - m) / 12
     * x = y0 + y0/4 - y0/100 + y0/400
     * m0 = m + 12 * ((14 - m) / 12) - 2
     * d0 = (d + x + 31*m0/12) mod 7
     * @param day Day (1)
     * @param month Month number (1-12)
     * @param year Year
     * @return First day of the month (0=Sunday, 1=Monday, etc.)
     */
    public static int getFirstDayOfMonth(int month, int year) {
        int day = 1;
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31 * m) / 12) % 7;
        return d;
    }
    
    /**
     * Display the calendar for a given month and year
     * @param month Month number (1-12)
     * @param year Year
     */
    public static void displayCalendar(int month, int year) {
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);
        
        // Display header
        System.out.println("\n" + getMonthName(month) + " " + year);
        System.out.println("=" .repeat(35));
        
        // Display day names
        for (String dayName : DAYS) {
            System.out.printf("%4s", dayName);
        }
        System.out.println();
        System.out.println("-" .repeat(35));
        
        // Print spaces for the first week
        for (int i = 0; i < firstDay; i++) {
            System.out.printf("%4s", "");
        }
        
        // Print the days of the month
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%4d", day);
            
            // Move to next line after Saturday
            if ((firstDay + day - 1) % 7 == 6) {
                System.out.println();
            }
        }
        
        System.out.println("\n" + "=" .repeat(35));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        
        // Validate month
        if (month < 1 || month > 12) {
            System.out.println("Invalid month! Please enter a value between 1 and 12.");
        } else {
            displayCalendar(month, year);
            
            System.out.println("\nLeap Year: " + isLeapYear(year));
            System.out.println("Days in month: " + getDaysInMonth(month, year));
        }
        
        scanner.close();
    }
}
