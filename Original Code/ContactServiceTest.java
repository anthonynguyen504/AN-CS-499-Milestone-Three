
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setup() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact);

        assertEquals(contact, contactService.getContact("1"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact);
        contactService.deleteContact("1");

        assertNull(contactService.getContact("1"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact);
        contactService.updateContact("1", "Jane", null, null, "456 Avenue");

        Contact updatedContact = contactService.getContact("1");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("456 Avenue", updatedContact.getAddress());
    }

    @Test
    public void testAddDuplicateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Street");
        contactService.addContact(contact);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact);
        });

        String expectedMessage = "Contact with ID 1 already exists";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
