import java.util.Scanner;

public class YoungestTallestFriends {

    public static int findYoungestIndex(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    public static int findTallestIndex(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        System.out.println("Enter age and height for Amar, Akbar and Anthony:");
        for (int i = 0; i < names.length; i++) {
            System.out.print("\n" + names[i] + ":");
            System.out.print("\nAge: ");
            ages[i] = scanner.nextInt();
            System.out.print("Height (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        int youngestIndex = findYoungestIndex(ages);
        int tallestIndex = findTallestIndex(heights);

        System.out.println("\n========== Results ==========");
        System.out.println("Youngest Friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest Friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");

        scanner.close();
    }
}