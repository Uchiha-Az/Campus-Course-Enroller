import java.util.Date;

public class Person
{
    private String firstName;
    private String lastName;
    Address address;

    //default constructor
    public Person() {

    }
    //constructor with all variables
    public Person(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    //getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //override toString
    @Override
    public String toString() {
        return
                "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Address: " + address +'\n';
    }
}

