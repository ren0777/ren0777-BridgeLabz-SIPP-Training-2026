import java.util.List;

public final class GenericsUtils {
    private GenericsUtils() {
    }

    // Bounded generic method: works only with Comparable types.
    public static <T extends Comparable<? super T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    // Wildcard utility method: can print list of any type.
    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

    // Upper bounded wildcard: read-only numeric processing.
    public static double sumNumbers(List<? extends Number> numbers) {
        double total = 0;
        for (Number number : numbers) {
            total += number.doubleValue();
        }
        return total;
    }

    // Lower bounded wildcard: write integers safely.
    public static void addDefaultScores(List<? super Integer> scores) {
        scores.add(50);
        scores.add(75);
        scores.add(100);
    }
}
