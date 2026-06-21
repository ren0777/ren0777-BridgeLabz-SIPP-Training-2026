import java.util.Arrays;
import java.util.Scanner;

public class Random4DigitNumbers {

    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + (int) (Math.random() * 9000);
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        long sum = 0;

        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        return new double[]{sum / (double) numbers.length, min, max};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Size must be greater than 0.");
            scanner.close();
            return;
        }

        int[] numbers = generate4DigitRandomArray(size);
        double[] result = findAverageMinMax(numbers);

        System.out.println("Random numbers: " + Arrays.toString(numbers));
        System.out.println("Average: " + result[0]);
        System.out.println("Minimum: " + (int) result[1]);
        System.out.println("Maximum: " + (int) result[2]);

        scanner.close();
    }
}