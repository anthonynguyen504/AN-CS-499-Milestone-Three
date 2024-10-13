import java.util.HashMap;

public class ContactService {
    private final HashMap<String, Contact> contactsMap; // Map to store contacts with their IDs as keys

    // Constructor to initialize the contactsMap
    public ContactService() {
        this.contactsMap = new HashMap<>();
    }

    // Add a new contact to the map
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null"); // Check for null contact
        }

        // Check if the contact ID already exists
        if (contactsMap.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact with ID " + contact.getContactID() + " already exists");
        }

        // Add the contact to the map
        contactsMap.put(contact.getContactID(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactID) {
        // Validate the contact ID
        if (contactID == null || !contactsMap.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        // Remove the contact from the map
        contactsMap.remove(contactID);
    }

    // Update a contact by ID
    public void updateContact(String contactID, String newFirstName, String newLastName, String newPhoneNumber, String newAddress) {
        Contact contact = contactsMap.get(contactID); // Retrieve the contact by ID
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found"); // Check if the contact exists
        }

        // Update fields if new values are provided
        if (newFirstName != null) contact.setFirstName(newFirstName);
        if (newLastName != null) contact.setLastName(newLastName);
        if (newPhoneNumber != null) contact.setPhoneNumber(newPhoneNumber);
        if (newAddress != null) contact.setAddress(newAddress);
    }

    // Retrieve a contact by ID
    public Contact getContact(String contactID) {
        return contactsMap.get(contactID); // Return the contact associated with the ID
    }
}
