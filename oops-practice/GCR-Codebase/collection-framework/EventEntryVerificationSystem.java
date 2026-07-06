import java.util.HashSet;

public class EventEntryVerificationSystem {
    private final HashSet<String> participantEmails = new HashSet<>();

    public void registerParticipant(String email) {
        if (participantEmails.add(email)) {
            System.out.println("Registration successful: " + email);
        } else {
            System.out.println("Duplicate registration rejected: " + email);
        }
    }

    public void displayUniqueParticipants() {
        System.out.println("\n--- Unique Registered Participants ---");
        for (String email : participantEmails) {
            System.out.println(email);
        }
        System.out.println("Total Eligible Attendees: " + participantEmails.size());
    }

    public static void main(String[] args) {
        EventEntryVerificationSystem system = new EventEntryVerificationSystem();

        system.registerParticipant("alice@tech.com");
        system.registerParticipant("bob@tech.com");
        system.registerParticipant("alice@tech.com");
        system.registerParticipant("charlie@tech.com");

        system.displayUniqueParticipants();
    }
}
