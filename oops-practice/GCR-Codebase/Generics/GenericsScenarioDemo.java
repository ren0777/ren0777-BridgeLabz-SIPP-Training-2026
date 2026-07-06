import java.util.ArrayList;
import java.util.List;

public class GenericsScenarioDemo {

    public static void main(String[] args) {
        Pair<String, Integer> nameAge = new Pair<>("Riya", 21);
        System.out.println(nameAge);

        GenericStack<String> stack = new GenericStack<>();
        stack.push("Java");
        stack.push("Generics");
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());

        Integer[] numbers = {4, 8, 2, 14, 9};
        System.out.println("Max number: " + GenericsUtils.findMax(numbers));

        String[] names = {"Mira", "Aarav", "Kabir"};
        System.out.println("Max string: " + GenericsUtils.findMax(names));

        Repository<String> studentRepository = new Repository<>();
        studentRepository.add("Riya");
        studentRepository.add("Aarav");

        Repository<Integer> scoreRepository = new Repository<>();
        scoreRepository.add(95);
        scoreRepository.add(88);

        System.out.println("\nStudents:");
        GenericsUtils.printList(studentRepository.getAll());

        System.out.println("\nScores:");
        GenericsUtils.printList(scoreRepository.getAll());

        List<Integer> marks = new ArrayList<>();
        marks.add(80);
        marks.add(90);
        marks.add(70);
        System.out.println("\nSum of marks: " + GenericsUtils.sumNumbers(marks));

        List<Number> scoreBoard = new ArrayList<>();
        GenericsUtils.addDefaultScores(scoreBoard);
        System.out.println("Score board after writes:");
        GenericsUtils.printList(scoreBoard);
    }
}
