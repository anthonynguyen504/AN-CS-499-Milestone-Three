package contact;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class ContactServiceTest {

//need to test add, delete and update
//templates
/*
* Contact("1413252", "John", "Doe", "5555555555", "Sample 24 Drive");
Contact("1309403", "Mike", "Shawn", "2187123404", "Valley of Thorns");
Contact("9752319", "Will", "Smith", "9215501793", "Land of Proxynee");
*/

@Test
public void testAdd()
{
ContactService cs = new ContactService();
Contact test1 = new Contact("1413252", "John", "Doe", "5555555555", "Sample 24 Drive");
assertEquals(true, cs.addContact(test1));
}

@Test
public void testDelete()
{
ContactService cs = new ContactService();

Contact test1 = new Contact("1413252", "John", "Doe", "5555555555", "Sample 24 Drive");
Contact test2 = new Contact("1309403", "Mike", "Shawn", "2187123404", "Valley of Thorns");
Contact test3 = new Contact("9752319", "Will", "Smith", "9215501793", "Land of Proxynee");

cs.addContact(test1);
cs.addContact(test2);
cs.addContact(test3);

assertEquals(true, cs.deleteContact("1309403"));
assertEquals(false, cs.deleteContact("1309404"));
assertEquals(false, cs.deleteContact("1309403"));
}

@Test
public void testUpdate()
{
ContactService cs = new ContactService();

Contact test1 = new Contact("1413252", "John", "Doe", "5555555555", "Sample 24 Drive");
Contact test2 = new Contact("1309403", "Mike", "Shawn", "2187123404", "Valley of Thorns");
Contact test3 = new Contact("9752319", "Will", "Smith", "9215501793", "Land of Proxynee");

cs.addContact(test1);
cs.addContact(test2);
cs.addContact(test3);

assertEquals(true, cs.updateContact("9752319", "WillFirst", "SmithLast", "9215501793", "Land of Proxynee"));
assertEquals(false, cs.updateContact("9752322", "WillFirst", "SmithLast", "9215501793", "Land of Proxynee"));
}

}