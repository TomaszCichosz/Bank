package bank.menu.customersubmenu;

import bank.Bank;
import bank.InputOutputMethods;
import bank.menu.MenuMessages;

import java.util.UUID;

public class CustomerMenu {

    public static void menu(UUID customerId) {
        final int EDIT_YOUR_INFO = 1;
        final int VIEW_ACCOUNTS = 2;
        final int TRANSACTIONS = 3;
        final int EXIT_OPTION = 0;

        boolean exit = false;
        int decision;

        while (!exit) {
            MenuMessages.customerMenuInfo();
            decision = InputOutputMethods.getIntInput();
            switch (decision) {
                case EDIT_YOUR_INFO:
                    break;
                case VIEW_ACCOUNTS:
                    Bank.getInstance().listOfCustomerAccounts(Bank.getInstance().getAllCustomerAccounts(customerId));
                    break;
                case TRANSACTIONS:
                    System.out.println("Account number:");
                    String accountNumber = InputOutputMethods.getStringInput();
                    if (Bank.getInstance().getCustomers().get(customerId).getId().equals(Bank.getInstance().getAccounts().get(accountNumber).getCustomerId())) {
                        CustomerTransactionsMenu.menu(accountNumber);
                    } else System.out.println("Wrong account number!");
                    break;
                case EXIT_OPTION:
                    exit = true;
                    break;
                default:
                    MenuMessages.errorMessage();
                    break;
            }
        }
    }
}
