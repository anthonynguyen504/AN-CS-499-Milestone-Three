/*
* Contact.java
* Author: Anthony
* Contact Info: anthony@example.com
* Date: 10/11/2024
* Version: 1.1
* Purpose: This class models a Contact object with attributes like contactID, firstName, lastName, 
*          phoneNumber, and address. Provides methods to get, set, and display the contact details.
* Issues: None
*/

package contact;

public class Contact {
    // Defining fields to store contact details
    String contactID;
    String firstName;
    String lastName;
    String phoneNumber;
    String address;

    // Constructor to initialize Contact object
    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getter and Setter methods for each field
    public String getContactID() {
        return contactID;
    }

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        // Added validation to ensure firstName is not too long
        if (firstName.length() <= 10) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        // Added validation to ensure lastName is not too long
        if (lastName.length() <= 10) {
            this.lastName = lastName;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        // Added validation to ensure phone number is exactly 10 digits
        if (phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        // Added validation to ensure address is not too long
        if (address.length() <= 30) {
            this.address = address;
        }
    }

    @Override
    public String toString() {
        return "Contact [contactID=" + contactID + ", firstName=" + firstName + ", lastName=" + lastName
                + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
    }
}
