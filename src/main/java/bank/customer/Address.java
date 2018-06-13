package bank.customer;

import java.util.Objects;

public class Address {
    private String street, number, postalCode, city;

    public Address(String street, String number, String postalCode, String city) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }

    @Override
    public String toString() {
        return "address:\nstreet: " + street + ",\nnumber: " + number + ",\npostal code: " + postalCode + ",\ncity: " + city + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(number, address.number) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, postalCode, city);
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }
}