package bank;

import bank.account.Account;
import bank.customer.Address;
import bank.customer.Customer;

import java.io.*;
import java.util.*;

public class Bank {

    private Map<UUID, Customer> customers;
    private Map<String, Account> accounts;

    private Bank() {
        customers = new HashMap<>();
        accounts = new HashMap<>();
    }

    public static Bank getInstance() {
        return BankSingletonHolder.INSTANCE;
    }

    private static class BankSingletonHolder {
        private static final Bank INSTANCE = new Bank();
    }

    public Map<UUID, Customer> getCustomers() {
        return customers;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void listOfCustomerAccounts(List<Account> accounts) {
        for (Account temp : accounts) {
            System.out.println(temp);
        }
    }

    public List<Account> getAllCustomerAccounts(UUID customerId) {
        List<Account> accountList = new ArrayList<>();
        for (Map.Entry<String, Account> temp : accounts.entrySet()) {
            if (temp.getValue().getCustomerId().equals(customerId)) {
                accountList.add(temp.getValue());
            }
        }
        return accountList;
    }

    public void addAccount(UUID customerId) {
        System.out.println("Account number:");
        String accountNumber = InputOutputMethods.getStringInput();
        Bank.getInstance().getAccounts().put(accountNumber, new Account(customerId, accountNumber));
    }

    public void removeAccount(UUID customerId) {
        System.out.println("Account number:");
        String accountNumber = InputOutputMethods.getStringInput();
        if (Bank.getInstance().getAccounts().get(accountNumber).getCustomerId().equals(customerId)) {
            Bank.getInstance().getAccounts().remove(accountNumber);
        }
    }

    public void removeCustomer() {
        System.out.println("Customer UUID:");
        Bank.getInstance().getCustomers().remove(UUID.fromString(InputOutputMethods.getStringInput()));
    }

    public void createCustomer() {
        System.out.println("Name:");
        String name = InputOutputMethods.getStringInput();
        System.out.println("Surname");
        String surname = InputOutputMethods.getStringInput();
        System.out.println("Street:");
        String street = InputOutputMethods.getStringInput();
        System.out.println("Number:");
        String number = InputOutputMethods.getStringInput();
        System.out.println("Postal code:");
        String postalCode = InputOutputMethods.getStringInput();
        System.out.println("City:");
        String city = InputOutputMethods.getStringInput();
        Customer newCustomer = new Customer(name, surname, new Address(street, number, postalCode, city));
        Bank.getInstance().getCustomers().put(newCustomer.getId(), newCustomer);
    }

    public void editCustomer(UUID customerId) {
        System.out.println("Name:");
        Bank.getInstance().getCustomers().get(customerId).setName(InputOutputMethods.getStringInput());
        System.out.println("Surname:");
        Bank.getInstance().getCustomers().get(customerId).setSurname(InputOutputMethods.getStringInput());
        System.out.println("Street:");
        Bank.getInstance().getCustomers().get(customerId).getAddress().setStreet(InputOutputMethods.getStringInput());
        System.out.println("Number:");
        Bank.getInstance().getCustomers().get(customerId).getAddress().setNumber(InputOutputMethods.getStringInput());
        System.out.println("Postal code:");
        Bank.getInstance().getCustomers().get(customerId).getAddress().setPostalCode(InputOutputMethods.getStringInput());
        System.out.println("City:");
        Bank.getInstance().getCustomers().get(customerId).getAddress().setCity(InputOutputMethods.getStringInput());
    }

    public void transfer() {
        System.out.println("Account number:");
        String accountNumber = InputOutputMethods.getStringInput();
        System.out.println("Target account number:");
        String targetAccountNumber = InputOutputMethods.getStringInput();
        System.out.println("Amount:");
        float amount = InputOutputMethods.getFloatInput();
        Bank.getInstance().getAccounts().get(accountNumber).transfer(targetAccountNumber, amount);
    }

    public void listOfCustomers() {
        for (Map.Entry temp : Bank.getInstance().getCustomers().entrySet()) {
            System.out.println(temp.getValue());
        }
    }

    public void listOfAccounts() {
        for (Map.Entry<String, Account> temp : Bank.getInstance().getAccounts().entrySet()) {
            System.out.println("Customer id: " + temp.getValue().getCustomerId() + "\t" + temp.getValue());
        }
    }

    void serialization() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("customers.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customers);
            fileOutputStream = new FileOutputStream("accounts.ser");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accounts);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    void deserialization() {
        try {
            FileInputStream fileInputStream = new FileInputStream("customers.ser");
            ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);
            customers = (HashMap) objectOutputStream.readObject();
            fileInputStream = new FileInputStream("accounts.ser");
            objectOutputStream = new ObjectInputStream(fileInputStream);
            accounts = (HashMap) objectOutputStream.readObject();
            objectOutputStream.close();
            fileInputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }
}
