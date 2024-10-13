import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService contactService; // Instance of ContactService to be tested

    // Set up method that runs before each test
    @BeforeEach
    public void setup() {
        contactService = new ContactService(); // Initialize a new ContactService instance
    }

    // Test case for adding a contact
    @Test
    public void testAddContact() {
        // Create a new contact
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact); // Add the contact to the service

        // Verify that the contact was added correctly
        assertEquals(contact, contactService.getContact("1")); // Check if retrieved contact matches the added contact
    }

    // Test case for deleting a contact
    @Test
    public void testDeleteContact() {
        // Create and add a contact
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact);
        contactService.deleteContact("1"); // Delete the contact by ID

        // Verify that the contact has been deleted
        assertNull(contactService.getContact("1")); // Check if the contact is no longer retrievable
    }

    // Test case for updating a contact
    @Test
    public void testUpdateContact() {
        // Create and add a contact
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact);
        // Update the contact's first name and address
        contactService.updateContact("1", "Jane", null, null, "456 Avenue");

        // Retrieve the updated contact and verify changes
        Contact updatedContact = contactService.getContact("1");
        assertEquals("Jane", updatedContact.getFirstName()); // Check if the first name was updated
        assertEquals("456 Avenue", updatedContact.getAddress()); // Check if the address was updated
    }

    // Test case for adding a duplicate contact
    @Test
    public void testAddDuplicateContact() {
        // Create and add a contact
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact);

        // Attempt to add the same contact again and expect an exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact); // This should throw an exception
        });

        // Verify the exception message
        String expectedMessage = "Contact with ID 1 already exists"; // Expected error message
        String actualMessage = exception.getMessage(); // Actual error message from the exception
        assertTrue(actualMessage.contains(expectedMessage)); // Check if the actual message matches the expected message
    }
}
