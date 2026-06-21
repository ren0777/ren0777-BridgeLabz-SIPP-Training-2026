// Problem 8: Generate All Subsets of an Array
// Given an array, generate all possible subsets recursively.

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void generateSubsets(int[] array, int index, int targetSize, List<Integer> current) {
        if (current.size() == targetSize) {
            System.out.println(current);
            return;
        }

        if (index == array.length) {
            return;
        }

        current.add(array[index]);
        generateSubsets(array, index + 1, targetSize, current);
        current.remove(current.size() - 1);

        generateSubsets(array, index + 1, targetSize, current);
    }

    public static void printAllSubsets(int[] array) {
        for (int size = 0; size <= array.length; size++) {
            generateSubsets(array, 0, size, new ArrayList<Integer>());
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2};
        printAllSubsets(array);
    }
}
