import java.util.Arrays;

public class FootballTeamHeightStats {

    public static int[] generatePlayerHeights(int size) {
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = 150 + (int) (Math.random() * 101);
        }
        return heights;
    }

    public static int sumOfHeights(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    public static double meanHeight(int[] heights) {
        return sumOfHeights(heights) / (double) heights.length;
    }

    public static int shortestHeight(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            shortest = Math.min(shortest, height);
        }
        return shortest;
    }

    public static int tallestHeight(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            tallest = Math.max(tallest, height);
        }
        return tallest;
    }

    public static void main(String[] args) {
        int[] heights = generatePlayerHeights(11);

        System.out.println("Player heights (cm): " + Arrays.toString(heights));
        System.out.println("Shortest height: " + shortestHeight(heights));
        System.out.println("Tallest height: " + tallestHeight(heights));
        System.out.printf("Mean height: %.2f%n", meanHeight(heights));
    }
}