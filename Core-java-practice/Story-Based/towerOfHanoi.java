// A temple has N disks in the Tower of Hanoi puzzle. Solve it
// recursively and count moves. Also implement recursive: binary
// search on a sorted price list, sum of digits, reverse a string, and
// check balanced parentheses without a stack.

public class towerOfHanoi {
    
    static int moveCount = 0;

    public static void main(String[] args) {
        int N = 3; // Number of disks
        System.out.println("Tower of Hanoi solution for " + N + " disks:");
        solveTowerOfHanoi(N, 'A', 'C', 'B'); // A, B and C are names of rods
        System.out.println("Total moves: " + moveCount);
    }

    static void solveTowerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            moveCount++;
            return;
        }
        solveTowerOfHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        moveCount++;
        solveTowerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }
}
