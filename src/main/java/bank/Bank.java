package bank;

import bank.account.Account;
import bank.customer.Customer;
import bank.customer.CustomerOperations;

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
        Customer newCustomer = CustomerOperations.createCustomer();
        Bank.getInstance().getCustomers().put(newCustomer.getId(), newCustomer);
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
}
