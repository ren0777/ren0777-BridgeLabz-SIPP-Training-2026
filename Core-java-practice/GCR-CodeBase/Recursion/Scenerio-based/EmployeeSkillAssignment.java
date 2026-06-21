// Scenario 3: Employee Skill Assignment
// Find all possible project teams whose total skill score equals a target value.

import java.util.ArrayList;
import java.util.List;

public class EmployeeSkillAssignment {
    public static void findTeams(int[] skills, int index, int target, List<Integer> team) {
        if (target == 0) {
            System.out.println(team);
            return;
        }

        if (index == skills.length || target < 0) {
            return;
        }

        team.add(skills[index]);
        findTeams(skills, index + 1, target - skills[index], team);
        team.remove(team.size() - 1);

        findTeams(skills, index + 1, target, team);
    }

    public static void main(String[] args) {
        int[] skills = {2, 3, 5, 7};
        int target = 10;
        findTeams(skills, 0, target, new ArrayList<Integer>());
    }
}
