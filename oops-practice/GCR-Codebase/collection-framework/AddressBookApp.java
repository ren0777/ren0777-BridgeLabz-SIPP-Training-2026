import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class AddressBookApp {
    private final ArrayList<Contact> contacts = new ArrayList<>();
    private final HashMap<String, Contact> contactsByName = new HashMap<>();
    private final HashSet<String> usedPhones = new HashSet<>();

    public boolean addContact(String name, String phone, String email) {
        if (contactsByName.containsKey(name)) {
            System.out.println("Contact with name '" + name + "' already exists.");
            return false;
        }
        if (usedPhones.contains(phone)) {
            System.out.println("Duplicate phone number not allowed: " + phone);
            return false;
        }

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        contactsByName.put(name, contact);
        usedPhones.add(phone);
        return true;
    }

    public Contact searchContact(String name) {
        return contactsByName.get(name);
    }

    public boolean deleteContact(String name) {
        Contact removed = contactsByName.remove(name);
        if (removed == null) {
            return false;
        }

        usedPhones.remove(removed.getPhone());
        contacts.remove(removed);
        return true;
    }

    public void displaySortedContacts() {
        List<Contact> sorted = new ArrayList<>(contacts);
        Collections.sort(sorted, Comparator.comparing(Contact::getName));

        System.out.println("\n--- Contacts Sorted by Name ---");
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        AddressBookApp app = new AddressBookApp();

        app.addContact("Riya", "9876543210", "riya@gmail.com");
        app.addContact("Aarav", "9876500000", "aarav@gmail.com");
        app.addContact("Kabir", "9999999999", "kabir@gmail.com");
        app.addContact("Mira", "9876543210", "mira@gmail.com");

        Contact found = app.searchContact("Aarav");
        System.out.println("\nSearch Result: " + (found != null ? found : "Not found"));

        boolean deleted = app.deleteContact("Kabir");
        System.out.println("Delete Kabir: " + (deleted ? "Success" : "Not found"));

        app.displaySortedContacts();
    }
}
