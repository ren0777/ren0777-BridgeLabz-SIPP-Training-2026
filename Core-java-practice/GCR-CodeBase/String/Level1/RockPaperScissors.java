import java.util.Scanner;

/**
 * Program to play Rock-Paper-Scissors game between user and computer
 */
public class RockPaperScissors {
    
    private static final String[] CHOICES = {"Rock", "Paper", "Scissors"};
    
    /**
     * Get computer's choice using Math.random()
     * @return Computer's choice (0=Rock, 1=Paper, 2=Scissors)
     */
    public static int getComputerChoice() {
        return (int) (Math.random() * 3);
    }
    
    /**
     * Determine winner between user and computer
     * Rules: Rock beats Scissors, Scissors beats Paper, Paper beats Rock
     * @param userChoice User's choice
     * @param computerChoice Computer's choice
     * @return 1 if user wins, -1 if computer wins, 0 if tie
     */
    public static int determineWinner(int userChoice, int computerChoice) {
        // If both choose same, it's a tie
        if (userChoice == computerChoice) {
            return 0;
        }
        
        // Rock beats Scissors
        if ((userChoice == 0 && computerChoice == 2) ||
            // Scissors beats Paper
            (userChoice == 2 && computerChoice == 1) ||
            // Paper beats Rock
            (userChoice == 1 && computerChoice == 0)) {
            return 1; // User wins
        }
        
        return -1; // Computer wins
    }
    
    /**
     * Calculate and return win statistics
     * @param userWins User's wins
     * @param computerWins Computer's wins
     * @param totalGames Total games played
     * @return 2D array with statistics
     */
    public static String[][] calculateWinStatistics(int userWins, int computerWins, int totalGames) {
        String[][] stats = new String[3][2];
        
        double userPercentage = (userWins / (double) totalGames) * 100;
        double computerPercentage = (computerWins / (double) totalGames) * 100;
        
        stats[0][0] = "User";
        stats[0][1] = userWins + " wins (" + String.format("%.2f", userPercentage) + "%)";
        
        stats[1][0] = "Computer";
        stats[1][1] = computerWins + " wins (" + String.format("%.2f", computerPercentage) + "%)";
        
        stats[2][0] = "Ties";
        stats[2][1] = String.valueOf(totalGames - userWins - computerWins);
        
        return stats;
    }
    
    /**
     * Display game results in tabular format
     * @param stats Statistics array
     */
    public static void displayStatistics(String[][] stats) {
        System.out.println("\n=====================================================");
        System.out.println("Player       | Result");
        System.out.println("=====================================================");
        
        for (String[] row : stats) {
            System.out.printf("%-12s | %s%n", row[0], row[1]);
        }
        
        System.out.println("=====================================================");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Rock-Paper-Scissors Game ===");
        System.out.print("Enter number of games to play: ");
        int numOfGames = scanner.nextInt();
        
        int userWins = 0;
        int computerWins = 0;
        
        System.out.println("\nChoices: 0=Rock, 1=Paper, 2=Scissors");
        
        // Play multiple games
        for (int i = 1; i <= numOfGames; i++) {
            System.out.print("\nGame " + i + " - Enter your choice (0-2): ");
            int userChoice = scanner.nextInt();
            
            // Validate user input
            if (userChoice < 0 || userChoice > 2) {
                System.out.println("Invalid choice! Skipping this game.");
                continue;
            }
            
            int computerChoice = getComputerChoice();
            int result = determineWinner(userChoice, computerChoice);
            
            // Display game result
            System.out.println("You chose: " + CHOICES[userChoice]);
            System.out.println("Computer chose: " + CHOICES[computerChoice]);
            
            if (result == 1) {
                System.out.println("You win this round!");
                userWins++;
            } else if (result == -1) {
                System.out.println("Computer wins this round!");
                computerWins++;
            } else {
                System.out.println("It's a tie!");
            }
        }
        
        // Calculate and display statistics
        String[][] stats = calculateWinStatistics(userWins, computerWins, numOfGames);
        
        System.out.println("\n=== Final Results ===");
        displayStatistics(stats);
        
        scanner.close();
    }
}
