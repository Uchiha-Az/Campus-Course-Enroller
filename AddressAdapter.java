public class AddressAdapter implements ExternalAddress {
    private Address address;

    public AddressAdapter(Address address) {
        this.address = address;
    }

    @Override
    public String getFullAddress() {
        return address.getStreet() + ", " + address.getCity() + ", " + address.getState() + " " + address.getZipCode();
    }
}