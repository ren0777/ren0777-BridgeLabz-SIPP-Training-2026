import java.util.Scanner;

class PollingBooth {
    static final int VOTING_AGE = 18;
    static final String EXIT_CODE = "STOP";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int candidate1Votes = 0;
        int candidate2Votes = 0;
        int candidate3Votes = 0;
        int rejectedVotes = 0;
        int voterCount = 0;

        System.out.println("=== Election Booth Manager ===\n");
        System.out.println("Candidates:");
        System.out.println("1. Candidate A");
        System.out.println("2. Candidate B");
        System.out.println("3. Candidate C");
        System.out.println("Type '" + EXIT_CODE + "' as voter ID to close booth\n");

        while (true) {
            System.out.print("Enter voter ID (or '" + EXIT_CODE + "' to close): ");
            String voterId = scanner.nextLine().trim().toUpperCase();

            if (voterId.equals(EXIT_CODE)) {
                break;
            }

            System.out.print("Enter age: ");
            int voterAge;
            try {
                voterAge = Integer.parseInt(scanner.nextLine().trim());
                if (voterAge < 0) {
                    System.out.println("Age cannot be negative. Try again.\n");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid age input. Please enter a number.\n");
                continue;
            }

            if (voterAge < VOTING_AGE) {
                System.out.println("Not eligible to vote. Minimum age is " + VOTING_AGE + " years.\n");
                continue;
            }

            System.out.print("Enter vote (1, 2, or 3): ");
            int vote;
            try {
                vote = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid vote. Please enter 1, 2, or 3.\n");
                continue;
            }

            voterCount++;
            boolean isValidVote = recordVote(vote);

            if (vote == 1) {
                candidate1Votes++;
                System.out.println("✓ Vote recorded for Candidate A");
            } else if (vote == 2) {
                candidate2Votes++;
                System.out.println("✓ Vote recorded for Candidate B");
            } else if (vote == 3) {
                candidate3Votes++;
                System.out.println("✓ Vote recorded for Candidate C");
            } else {
                rejectedVotes++;
                System.out.println("✗ Invalid vote - Vote rejected");
            }

            System.out.println("Voter ID: " + voterId + ", Age: " + voterAge);
            System.out.println();
        }

        printFinalResults(candidate1Votes, candidate2Votes, candidate3Votes, rejectedVotes, voterCount);

        scanner.close();
    }

    static boolean recordVote(int vote) {
        return (vote >= 1 && vote <= 3);
    }

    static void printFinalResults(int votes1, int votes2, int votes3, int rejected, int total) {
        System.out.println("\n=== Final Voting Results ===");
        System.out.println("Total Voters: " + total);
        System.out.println("Valid Votes: " + (total - rejected));
        System.out.println("Rejected Votes: " + rejected);

        System.out.println("\nVote Count:");
        System.out.println("Candidate A: " + votes1 + " votes");
        System.out.println("Candidate B: " + votes2 + " votes");
        System.out.println("Candidate C: " + votes3 + " votes");

        if (total > 0) {
            System.out.println("\nPercentage:");
            System.out.println("Candidate A: " + String.format("%.2f", (votes1 * 100.0 / total)) + "%");
            System.out.println("Candidate B: " + String.format("%.2f", (votes2 * 100.0 / total)) + "%");
            System.out.println("Candidate C: " + String.format("%.2f", (votes3 * 100.0 / total)) + "%");

            int maxVotes = Math.max(votes1, Math.max(votes2, votes3));
            String winner = determineWinner(votes1, votes2, votes3, maxVotes);
            System.out.println("\nWinner: " + winner);
        }

        System.out.println("\nBooth Closed. Thank you!");
    }

    static String determineWinner(int votes1, int votes2, int votes3, int maxVotes) {
        if (votes1 == votes2 && votes2 == votes3) {
            return "Tie - All candidates have equal votes";
        } else if (votes1 == votes2 || votes2 == votes3 || votes1 == votes3) {
            return "Tie between multiple candidates";
        } else if (votes1 == maxVotes) {
            return "Candidate A";
        } else if (votes2 == maxVotes) {
            return "Candidate B";
        } else {
            return "Candidate C";
        }
    }
}
