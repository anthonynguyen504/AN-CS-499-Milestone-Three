public class Contact {
    // Private fields for storing contact information
    private String contactID;  // Unique identifier for each contact
    private String firstName;   // First name of the contact
    private String lastName;    // Last name of the contact
    private String phoneNumber;  // Phone number of the contact
    private String address;      // Address of the contact

    // Constructor to initialize the Contact object
    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        this.contactID = contactID;  // Initialize contactID
        this.firstName = firstName;  // Initialize firstName
        this.lastName = lastName;    // Initialize lastName
        this.phoneNumber = phoneNumber;  // Initialize phoneNumber
        this.address = address;      // Initialize address
    }

    // Getter for contactID
    public String getContactID() {
        return contactID;
    }

    // Setter for contactID
    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName with validation
    public void setFirstName(String firstName) {
        if (firstName != null && firstName.length() <= 10) {
            this.firstName = firstName;  // Set firstName if valid
        } else {
            throw new IllegalArgumentException("First name cannot be null or longer than 10 characters");
        }
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter for lastName with validation
    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() <= 10) {
            this.lastName = lastName;  // Set lastName if valid
        } else {
            throw new IllegalArgumentException("Last name cannot be null or longer than 10 characters");
        }
    }

    // Getter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for phoneNumber with validation
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;  // Set phoneNumber if valid
        } else {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address with validation
    public void setAddress(String address) {
        if (address != null && address.length() <= 30) {
            this.address = address;  // Set address if valid
        } else {
            throw new IllegalArgumentException("Address cannot be null or longer than 30 characters");
        }
    }

    // Override toString method to provide a string representation of the contact
    @Override
    public String toString() {
        return "Contact{" +
                "contactID='" + contactID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
