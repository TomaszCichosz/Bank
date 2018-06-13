package bank.model;

import java.io.Serializable;

public class Address implements Serializable {
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