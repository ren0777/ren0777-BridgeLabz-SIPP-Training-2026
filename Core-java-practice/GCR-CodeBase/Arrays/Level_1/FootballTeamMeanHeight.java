import java.util.Scanner;

public class FootballTeamMeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];
        
        // Take input for 11 players' heights
        System.out.println("Enter the heights of 11 players in the football team:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = scanner.nextDouble();
        }
        
        // Calculate sum of all heights
        double sum = 0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }
        
        // Calculate mean height
        double mean = sum / heights.length;
        
        // Display mean height
        System.out.println("\n--- Mean Height ---");
        System.out.println("Mean height of the football team: " + mean);
        
        scanner.close();
    }
}
