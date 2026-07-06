import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CustomerFeedbackAnalyzer {
    public static void main(String[] args) {
        try {
            readAndCountGoodFeedback();
        } catch (IOException e) {
            System.out.println("Error while reading feedback: " + e.getMessage());
        }
    }

    static void readAndCountGoodFeedback() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goodFeedbackCount = 0;

        System.out.println("Enter 5 feedback messages:");

        for (int i = 1; i <= 5; i++) {
            String message = br.readLine();
            if (message != null && message.toLowerCase().contains("good")) {
                // Count messages containing "good" at least once.
                goodFeedbackCount++;
            }
        }

        System.out.println("Good Feedback Count = " + goodFeedbackCount);
    }
}
