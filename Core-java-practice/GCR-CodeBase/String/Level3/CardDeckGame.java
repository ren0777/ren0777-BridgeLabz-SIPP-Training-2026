import java.util.Scanner;

/**
 * Program to create a deck of cards, shuffle, and distribute to players
 */
public class CardDeckGame {
    
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    
    /**
     * Initialize the deck of cards
     * @return Array of cards in the deck
     */
    public static String[] initializeDeck() {
        int numOfCards = SUITS.length * RANKS.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        
        // Create cards with format "rank of suit"
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index] = rank + " of " + suit;
                index++;
            }
        }
        
        return deck;
    }
    
    /**
     * Shuffle the deck of cards using random swaps
     * @param deck The deck to shuffle
     * @param n Number of cards in deck
     * @return Shuffled deck
     */
    public static String[] shuffleDeck(String[] deck, int n) {
        // Iterate over the deck and swap each card with a random card
        for (int i = 0; i < n; i++) {
            // Generate random card number between i and n
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            
            // Swap current card with random card
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        
        return deck;
    }
    
    /**
     * Distribute n cards to x number of players
     * @param deck The deck to distribute
     * @param numOfCards Number of cards to distribute
     * @param numOfPlayers Number of players
     * @return 2D array containing players and their cards
     */
    public static String[][] distributeCards(String[] deck, int numOfCards, int numOfPlayers) {
        // Check if cards can be distributed to players
        if (numOfCards > deck.length) {
            System.out.println("Error: Not enough cards in deck!");
            return null;
        }
        
        // Calculate cards per player
        int cardsPerPlayer = numOfCards / numOfPlayers;
        
        if (cardsPerPlayer == 0) {
            System.out.println("Error: Cannot distribute cards. Not enough cards for each player!");
            return null;
        }
        
        // Create 2D array to store players and their cards
        String[][] players = new String[numOfPlayers][cardsPerPlayer];
        int cardIndex = 0;
        
        // Distribute cards to each player
        for (int player = 0; player < numOfPlayers; player++) {
            for (int card = 0; card < cardsPerPlayer; card++) {
                players[player][card] = deck[cardIndex];
                cardIndex++;
            }
        }
        
        return players;
    }
    
    /**
     * Print the players and their cards
     * @param players 2D array containing players and their cards
     */
    public static void printPlayers(String[][] players) {
        if (players == null) {
            return;
        }
        
        System.out.println("\n" + "=" .repeat(60));
        System.out.println("CARD DISTRIBUTION TO PLAYERS");
        System.out.println("=" .repeat(60));
        
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " Cards:");
            System.out.println("-" .repeat(60));
            
            for (int j = 0; j < players[i].length; j++) {
                System.out.printf("%2d. %-30s", (j + 1), players[i][j]);
                
                // Print 2 cards per line
                if ((j + 1) % 2 == 0) {
                    System.out.println();
                }
            }
            
            if (players[i].length % 2 != 0) {
                System.out.println();
            }
        }
        
        System.out.println("=" .repeat(60));
    }
    
    /**
     * Print the deck
     * @param deck The deck to print
     * @param numOfCards Number of cards to print
     */
    public static void printDeck(String[] deck, int numOfCards) {
        System.out.println("\n" + "=" .repeat(60));
        System.out.println("SHUFFLED DECK (" + numOfCards + " cards shown)");
        System.out.println("=" .repeat(60));
        
        for (int i = 0; i < numOfCards && i < deck.length; i++) {
            System.out.printf("%2d. %-30s", (i + 1), deck[i]);
            
            // Print 2 cards per line
            if ((i + 1) % 2 == 0) {
                System.out.println();
            }
        }
        
        if (numOfCards % 2 != 0) {
            System.out.println();
        }
        
        System.out.println("=" .repeat(60));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CARD DECK GAME ===");
        System.out.print("Enter number of players: ");
        int numOfPlayers = scanner.nextInt();
        
        System.out.print("Enter number of cards to distribute to each player: ");
        int cardsPerPlayer = scanner.nextInt();
        
        int totalCardsNeeded = numOfPlayers * cardsPerPlayer;
        int totalCardsInDeck = SUITS.length * RANKS.length;
        
        if (totalCardsNeeded > totalCardsInDeck) {
            System.out.println("Error: Cannot distribute " + totalCardsNeeded + " cards. Deck only has " + totalCardsInDeck + " cards!");
            scanner.close();
            return;
        }
        
        // Initialize deck
        String[] deck = initializeDeck();
        System.out.println("\nDeck initialized with " + deck.length + " cards.");
        
        // Shuffle deck
        deck = shuffleDeck(deck, deck.length);
        System.out.println("Deck shuffled successfully!");
        
        // Print shuffled deck (optional - show first few cards)
        printDeck(deck, Math.min(10, deck.length));
        
        // Distribute cards
        String[][] players = distributeCards(deck, totalCardsNeeded, numOfPlayers);
        
        // Print players and their cards
        if (players != null) {
            printPlayers(players);
            System.out.println("\nTotal cards distributed: " + totalCardsNeeded);
            System.out.println("Cards per player: " + cardsPerPlayer);
        }
        
        scanner.close();
    }
}
