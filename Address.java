//instantiate our address class to be accessed in the test class

public class Address
{
    //initialize private variables so they cant be accessed in test class
    private String street;
    private String city;
    private String state;
    private String Zip;

    public Address ()
    {

    }

    //constructor
    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        Zip = zip;
    }

    //instantiate all of our getters and setters for our variables
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    //our override toString
    @Override
    public String toString() {
        return
                "Street: " + street + '\n' +
                "City: " + city + '\n' +
                "State: " + state + '\n' +
                "Zip: " + Zip + '\n';
    }
}
