interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("TextModeration Policy: Posts with offensive language will be removed immediately.");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restrictedWords = {"hate", "violence", "abuse", "threat"};
        String lowerPost = post.toLowerCase();
        for (String word : restrictedWords) {
            if (lowerPost.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("SpamDetection Policy: Posts with repeated links or promotional content will be flagged.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {

    @Override
    public boolean isOffensive(String post) {
        return TextModeration.containsRestrictedWords(post);
    }

    @Override
    public boolean isSpam(String post) {
        int linkCount = 0;
        String[] words = post.split(" ");
        for (String word : words) {
            if (word.startsWith("http") || word.startsWith("www")) {
                linkCount++;
            }
        }
        return linkCount >= 2;
    }

    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }
}

public class ContentModerationPlatform {
    public static void main(String[] args) {
        ContentModerator moderator = new ContentModerator();

        String[] posts = {
            "I love this sunny day!",
            "Buy now! Visit www.fakesite.com and http://scam.net for deals!",
            "This is full of hate and violence.",
            "Check out my new blog post, very informative.",
            "Abuse and threat are not acceptable.",
            "Great product! Highly recommended.",
            "Visit http://spam1.com http://spam2.com for free stuff!"
        };

        moderator.displayModerationPolicy();
        System.out.println("\n--- Post Moderation Results ---");

        for (String post : posts) {
            boolean offensive = moderator.isOffensive(post);
            boolean spam = moderator.isSpam(post);

            if (offensive) {
                System.out.println("OFFENSIVE  | " + post);
            } else if (spam) {
                System.out.println("SPAM       | " + post);
            } else {
                System.out.println("VALID      | " + post);
            }
        }
    }
}
