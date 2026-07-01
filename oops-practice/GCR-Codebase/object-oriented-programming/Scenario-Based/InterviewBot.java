public class InterviewBot {

    private String botName;
    private String technology;

    public InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    public void conductInterview() {
        System.out.println("Bot: " + botName + " is conducting a " + technology + " interview.");
        System.out.println("Question 1: What are the core concepts of " + technology + "?");
        System.out.println("Question 2: Describe a project you built using " + technology + ".");
        System.out.println("Question 3: What are common challenges in " + technology + "?");
        System.out.println();
    }

    public static void main(String[] args) {
        InterviewBot bot1 = new InterviewBot("JavaBot", "Java");
        InterviewBot bot2 = new InterviewBot("PyBot", "Python");
        InterviewBot bot3 = new InterviewBot("WebBot", "React");

        bot1.conductInterview();
        bot2.conductInterview();
        bot3.conductInterview();
    }
}
