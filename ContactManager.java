package contactManager;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {

	    static Scanner sc = new Scanner(System.in);
	    static ArrayList<Contact> contacts = new ArrayList<>();

	    public static void main(String[] args) {

	        boolean running = true;

	        while (running) {

	            System.out.println("\n===== CONTACT MANAGER =====");
	            System.out.println("1. Add Contact");
	            System.out.println("2. View Contacts");
	            System.out.println("3. Search Contact");
	            System.out.println("4. Update Contact");
	            System.out.println("5. Delete Contact");
	            System.out.println("6. Clear Screen");
	            System.out.println("7. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    addContact();
	                    break;

	                case 2:
	                    viewContacts();
	                    break;

	                case 3:
	                    searchContact();
	                    break;

	                case 4:
	                    updateContact();
	                    break;

	                case 5:
	                    deleteContact();
	                    break;

	                case 6:
	                    clearScreen();
	                    break;

	                case 7:
	                    running = false;
	                    System.out.println("Contact Manager closed.");
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }

	        sc.close();
	    }

	    static void addContact() {

	        System.out.println("\n===== ADD CONTACT =====");

	        System.out.print("Enter Contact ID: ");
	        int id = sc.nextInt();

	        sc.nextLine();

	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Phone: ");
	        String phone = sc.nextLine();

	        System.out.print("Enter Email: ");
	        String email = sc.nextLine();

	        Contact contact = new Contact(id, name, phone, email);

	        contacts.add(contact);

	        System.out.println("Contact added successfully.");
	    }

	    static void viewContacts() {

	        System.out.println("\n===== ALL CONTACTS =====");

	        if (contacts.isEmpty()) {
	            System.out.println("No contacts found.");
	            return;
	        }

	        for (Contact contact : contacts) {
	            contact.displayContact();
	        }
	    }

	    static void searchContact() {

	        System.out.println("\n===== SEARCH CONTACT =====");

	        System.out.print("Enter Contact ID: ");
	        int id = sc.nextInt();

	        for (Contact contact : contacts) {

	            if (contact.getId() == id) {

	                System.out.println("Contact found.");
	                contact.displayContact();
	                return;
	            }
	        }

	        System.out.println("Contact not found.");
	    }

	    static void updateContact() {

	        System.out.println("\n===== UPDATE CONTACT =====");

	        System.out.print("Enter Contact ID: ");
	        int id = sc.nextInt();

	        for (Contact contact : contacts) {

	            if (contact.getId() == id) {

	                sc.nextLine();

	                System.out.print("Enter new name: ");
	                String name = sc.nextLine();

	                System.out.print("Enter new phone: ");
	                String phone = sc.nextLine();

	                System.out.print("Enter new email: ");
	                String email = sc.nextLine();

	                contact.setName(name);
	                contact.setPhone(phone);
	                contact.setEmail(email);

	                System.out.println("Contact updated successfully.");
	                return;
	            }
	        }

	        System.out.println("Contact not found.");
	    }

	    static void deleteContact() {

	        System.out.println("\n===== DELETE CONTACT =====");

	        System.out.print("Enter Contact ID: ");
	        int id = sc.nextInt();

	        for (Contact contact : contacts) {

	            if (contact.getId() == id) {

	                contacts.remove(contact);

	                System.out.println("Contact deleted successfully.");
	                return;
	            }
	        }

	        System.out.println("Contact not found.");
	    }

	    static void clearScreen() {

	        System.out.print("\033[H\033[2J");
	        System.out.flush();
	    }

}
