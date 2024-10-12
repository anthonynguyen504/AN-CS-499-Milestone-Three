/*
* ContactService.java
* Author: Anthony
* Contact Info: anthony@example.com
* Date: 10/11/2024
* Version: 1.1
* Purpose: Manages the list of contacts. Provides functionality to add, delete, and update contacts.
* Issues: None
*/

package contact;
import java.util.ArrayList;

public class ContactService {

    // List to store Contact objects
    private ArrayList<Contact> contacts;

    // Constructor initializes the ArrayList of contacts
    public ContactService() {
        contacts = new ArrayList<>();
    }

    // Adds a new contact, ensuring no duplicates
    public boolean addContact(Contact contact) {
        for (Contact contactList : contacts) {
            if (contactList.equals(contact)) {
                return false;  // Contact already exists
            }
        }
        contacts.add(contact);  // Contact successfully added
        return true;
    }

    // Deletes a contact by ID
    public boolean deleteContact(String contactID) {
        for (Contact contactList : contacts) {
            if (contactList.getContactID().equals(contactID)) {
                contacts.remove(contactList);
                return true;  // Contact successfully removed
            }
        }
        return false;  // Contact not found
    }

    // Updates an existing contact's details, ensuring valid updates
    public boolean updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        for (Contact contactList : contacts) {
            if (contactList.getContactID().equals(contactID)) {
                if (!firstName.equals("") && firstName.length() <= 10) {
                    contactList.setFirstName(firstName);
                }
                if (!lastName.equals("") && lastName.length() <= 10) {
                    contactList.setLastName(lastName);
                }
                if (!phoneNumber.equals("") && phoneNumber.length() == 10) {
                    contactList.setPhoneNumber(phoneNumber);
                }
                if (!address.equals("") && address.length() <= 30) {
                    contactList.setAddress(address);
                }
                return true;  // Contact successfully updated
            }
        }
        return false;  // Contact ID not found
    }
}
