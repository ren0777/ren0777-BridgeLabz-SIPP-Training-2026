import java.util.Scanner;

public class Matrix2Dto1D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take input for rows and columns
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();
        
        // Create 2D array (Matrix)
        int[][] matrix = new int[rows][columns];
        
        // Take user input for matrix
        System.out.println("\nEnter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Create 1D array to store matrix elements
        int[] array1D = new int[rows * columns];
        int index = 0;
        
        // Copy 2D array elements to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array1D[index] = matrix[i][j];
                index++;
            }
        }
        
        // Display 2D array
        System.out.println("\n--- 2D Matrix ---");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Display 1D array
        System.out.println("\n--- 1D Array (Flattened Matrix) ---");
        for (int i = 0; i < array1D.length; i++) {
            System.out.print(array1D[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
