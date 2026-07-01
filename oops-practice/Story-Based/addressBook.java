import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-25s", name, phone, email);
    }
}

class AddressBook {
    private final ArrayList<Contact> contactList = new ArrayList<>();
    private final HashMap<String, Contact> nameIndex = new HashMap<>();
    private final HashSet<String> phoneSet = new HashSet<>();

    void add(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number: " + phone);
            return;
        }
        Contact c = new Contact(name, phone, email);
        contactList.add(c);
        nameIndex.put(name.toLowerCase(), c);
        phoneSet.add(phone);
        System.out.println("Added: " + name);
    }
                                                                                
    Contact search(String name) {
        return nameIndex.get(name.toLowerCase());
    }

    void delete(String name) {
        Contact c = nameIndex.remove(name.toLowerCase());
        if (c == null) {
            System.out.println("Contact not found: " + name);
            return;
        }
        contactList.remove(c);
        phoneSet.remove(c.phone);
        System.out.println("Deleted: " + name);
    }

    void displaySorted() {
        ArrayList<Contact> sorted = new ArrayList<>(contactList);
        sorted.sort(Comparator.comparing(a -> a.name));
        System.out.println("\n----- ADDRESS BOOK -----");
        System.out.printf("%-20s %-15s %-25s%n", "Name", "Phone", "Email");
        System.out.println("-".repeat(60));
        for (Contact c : sorted) System.out.println(c);
    }

    public static void main(String[] args) {
        AddressBook book = new AddressBook();

        book.add("Alice", "111-222-3333", "alice@email.com");
        book.add("Bob", "444-555-6666", "bob@email.com");
        book.add("Charlie", "777-888-9999", "charlie@email.com");
        book.add("Alice", "111-222-3333", "dup@email.com"); // duplicate phone

        System.out.println("\nSearch for 'bob': " + book.search("bob"));

        book.displaySorted();

        book.delete("bob");
        book.delete("nobody");

        book.displaySorted();
    }
}
