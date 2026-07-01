import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EmployeeSkillAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Employee Skill Assignment ===\n");

        System.out.print("Enter number of employees: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println("Number of employees must be positive.");
                scanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            scanner.close();
            return;
        }

        int[] skillScores = new int[n];
        System.out.println("\nEnter skill scores for each employee:");

        for (int i = 0; i < n; i++) {
            System.out.print("Employee " + (i + 1) + " skill score: ");
            try {
                skillScores[i] = Integer.parseInt(scanner.nextLine().trim());
                if (skillScores[i] < 0) {
                    System.out.println("Skill score cannot be negative.");
                    i--;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                i--;
            }
        }

        System.out.print("\nEnter target skill score: ");
        int target;
        try {
            target = Integer.parseInt(scanner.nextLine().trim());
            if (target < 0) {
                System.out.println("Target cannot be negative.");
                scanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            scanner.close();
            return;
        }

        System.out.println("\n--- Results ---");
        System.out.println("Skill Scores: " + arrayToString(skillScores));
        System.out.println("Target Sum: " + target);

        List<List<Integer>> allTeams = new ArrayList<>();
        findTeams(skillScores, target, 0, new ArrayList<>(), allTeams);

        if (allTeams.isEmpty()) {
            System.out.println("\n❌ No valid teams found with target skill score " + target);
        } else {
            System.out.println("\n✓ Found " + allTeams.size() + " possible team(s):\n");
            displayTeams(allTeams);
        }

        scanner.close();
    }

    static void findTeams(int[] skills, int target, int index, List<Integer> currentTeam, 
                         List<List<Integer>> allTeams) {
        if (target == 0) {
            allTeams.add(new ArrayList<>(currentTeam));
            return;
        }

        if (index >= skills.length || target < 0) {
            return;
        }

        currentTeam.add(skills[index]);
        findTeams(skills, target - skills[index], index + 1, currentTeam, allTeams);

        currentTeam.remove(currentTeam.size() - 1);
        findTeams(skills, target, index + 1, currentTeam, allTeams);
    }

    static void displayTeams(List<List<Integer>> teams) {
        int teamNumber = 1;
        for (List<Integer> team : teams) {
            System.out.print("Team " + teamNumber + ": [");
            int sum = 0;
            for (int i = 0; i < team.size(); i++) {
                System.out.print(team.get(i));
                sum += team.get(i);
                if (i < team.size() - 1) System.out.print(", ");
            }
            System.out.println("] → Sum = " + sum);
            teamNumber++;
        }
    }

    static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
