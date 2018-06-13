package bank.customer;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private String surname;
    private Address address;

    public Customer(String name, String surname, Address address) {
        id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    @Override
    public String toString() {
        return "customer id: " + id + "\tname: " + name + "\tsurname: " + surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UUID getId() {
        return id;
    }
}
