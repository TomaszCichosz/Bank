package bank.customer;

import bank.InputOutputMethods;

public class CustomerOperations {

    private static Address setAddress() {
        System.out.println("Street:");
        String street = InputOutputMethods.getStringInput();
        System.out.println("Number:");
        String number = InputOutputMethods.getStringInput();
        System.out.println("Postal code:");
        String postalCode = InputOutputMethods.getStringInput();
        System.out.println("City:");
        String city = InputOutputMethods.getStringInput();
        return new Address(street, number, postalCode, city);
    }

    public static Customer createCustomer() {
        System.out.println("Name:");
        String name = InputOutputMethods.getStringInput();
        System.out.println("Surname");
        String surname = InputOutputMethods.getStringInput();
        Address address = setAddress();
        return new Customer(name, surname, address);
    }
}
