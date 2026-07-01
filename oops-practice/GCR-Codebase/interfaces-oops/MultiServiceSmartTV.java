interface StreamingService {
    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("StreamingService: Premium plan - Unlimited movies and shows.");
    }
}

interface GamingService {
    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("GamingService: Pro plan - Access to 500+ games.");
    }
}

class SmartTV implements StreamingService, GamingService {

    private String[] movies = {"Inception", "Interstellar", "The Dark Knight", "Avatar"};
    private String[] games = {"FIFA 25", "Call of Duty", "Minecraft", "GTA V"};

    @Override
    public void streamMovie(String movieName) {
        System.out.println("Now Streaming: " + movieName);
    }

    @Override
    public void playGame(String gameName) {
        System.out.println("Now Playing Game: " + gameName);
    }

    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public void displayAllContent() {
        System.out.println("\n--- Available Movies ---");
        for (String movie : movies) {
            System.out.println("  " + movie);
        }
        System.out.println("\n--- Available Games ---");
        for (String game : games) {
            System.out.println("  " + game);
        }
    }
}

public class MultiServiceSmartTV {
    public static void main(String[] args) {
        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();
        tv.displayAllContent();

        System.out.println();
        tv.streamMovie("Inception");
        tv.playGame("FIFA 25");
    }
}
