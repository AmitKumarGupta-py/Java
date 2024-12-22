import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


public class Phonebook {
    // java program to manage a simple phonebook that allows user to perform add, display,search and delete operations.
    private Map<String, String> contacts;

    public Phonebook(){
        this.contacts = new HashMap<String, String>();
    }

    // Method to add a contact to the phonebook
    public void addContact(String name, String phone_no){
        if(contacts.containsKey(name)){
            System.out.println("Contact already exists.");
            return;
        }
        else {
            contacts.put(name, phone_no);
            System.out.println("Added contact : \n" + name + " : " + phone_no);
        }
    }

    // Method to display all contacts
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Contact List is empty.");
        }
        else {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    // Method to search for a contact by name and display their phone number
    public void searchContact(String name){
        if (contacts.containsKey(name)) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
        else {
            System.out.println(name + " not found in the contact list.");
        }
    }


    // Method to delete a contact by name
    public void deleteContact(String name) {
        if (contacts.remove(name) != null) {
            System.out.println("Contact deleted: " + name);
        } else {
            System.out.println("Contact not found.");
        }
    }

    //Main Method containing a User Menu for accessing and perform the stated operations in the phonebook
    public static void main(String[] args){
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Phonebook Application");
        do {
            System.out.println("Phonebook Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("You have selected the Add Contact Operation!");
                    System.out.print("Please Enter the Name of the Contact: ");
                    String name = scanner.nextLine();
                    System.out.print("Please enter Phone number: ");
                    String phone = scanner.nextLine();
                    phonebook.addContact(name, phone);
                    break;
                case 2:
                    System.out.println("You have selected the Display Phonebook Operation!");
                    phonebook.displayContacts();
                    break;
                case 3:
                    System.out.println("You have selected the Search Contact Operation!");
                    System.out.println("Please Enter the Contact Name you wish to search : ");
                    name = scanner.nextLine();
                    phonebook.searchContact(name);
                    break;
                case 4:
                    System.out.println("You have selected the Delete Contact Operation!");
                    System.out.println("Please Enter the Contact Name you wish to delete : ");
                    name = scanner.nextLine();
                    phonebook.deleteContact(name);
                    break;
                case 5:
                    System.out.println("Thank you for using the Phonebook Application. Goodbye!");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        while (choice != 5);
    }
}






