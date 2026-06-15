import java.util.Scanner;

public class YoungstTallestFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        
        // Take input for age and height of 3 friends
        System.out.println("Enter age and height for 3 friends:");
        for (int i = 0; i < 3; i++) {
            System.out.print("\n" + names[i] + ":");
            System.out.print("\nAge: ");
            ages[i] = scanner.nextInt();
            System.out.print("Height (in cm): ");
            heights[i] = scanner.nextDouble();
        }
        
        // Find youngest friend
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        
        // Find tallest friend
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        // Display results
        System.out.println("\n========== Results ==========");
        System.out.println("Youngest Friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest Friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");
        
        scanner.close();
    }
}
