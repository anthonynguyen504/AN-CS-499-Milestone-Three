/*
* ContactServiceTest.java
* Author: Anthony
* Contact Info: anthony@example.com
* Date: 10/11/2024
* Version: 1.1
* Purpose: Unit tests for the ContactService class. Tests adding, deleting, and updating contacts.
* Issues: None
*/

package contact;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContactServiceTest {

    @Test
    public void testAdd() {
        ContactService cs = new ContactService();
        Contact test1 = new Contact("1413252", "John", "Doe", "5555555555", "Sample 24 Drive");
        assertEquals(true, cs.addContact(test1));  // Test successful add
    }

    @Test
    public void testDelete() {
        ContactService cs = new ContactService();
        Contact test1 = new Contact("1413252", "John", "Doe", "5555555555", "Sample 24 Drive");
        Contact test2 = new Contact("1309403", "Mike", "Shawn", "2187123404", "Valley of Thorns");
        Contact test3 = new Contact("9752319", "Will", "Smith", "9215501793", "Land of Proxynee");

        cs.addContact(test1);
        cs.addContact(test2);
        cs.addContact(test3);

        assertEquals(true, cs.deleteContact("1309403"));  // Test successful delete
        assertEquals(false, cs.deleteContact("1309404")); // Test delete for non-existing contact
    }

    @Test
    public void testUpdate() {
        ContactService cs = new ContactService();
        Contact test1 = new Contact("1413252", "John", "Doe", "5555555555", "Sample 24 Drive");
        Contact test2 = new Contact("1309403", "Mike", "Shawn", "2187123404", "Valley of Thorns");
        Contact test3 = new Contact("9752319", "Will", "Smith", "9215501793", "Land of Proxynee");

        cs.addContact(test1);
        cs.addContact(test2);
        cs.addContact(test3);

        // Test successful update
        assertEquals(true, cs.updateContact("9752319", "WillFirst", "SmithLast", "9215501793", "Land of Proxynee"));

        // Test unsuccessful update for non-existing contact
        assertEquals(false, cs.updateContact("9752322", "WillFirst", "SmithLast", "9215501793", "Land of Proxynee"));
    }
}
