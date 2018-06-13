package bank.menu.bankworkersubmenu;

import bank.Bank;
import bank.InputOutputMethods;
import bank.menu.MenuMessages;

public class BankWorkerMenu {

    public static void menu() {
        final int LIST_OF_CUSTOMERS = 1;
        final int LIST_OF_ACCOUNTS = 2;
        final int CUSTOMER_OPERATIONS = 3;
        final int EXIT_OPTION = 0;

        boolean exit = false;
        int decision;

        while (!exit) {
            MenuMessages.bankWorkerMenuInfo();
            decision = InputOutputMethods.getIntInput();
            switch (decision) {
                case LIST_OF_CUSTOMERS:
                    Bank.getInstance().listOfCustomers();
                    break;
                case LIST_OF_ACCOUNTS:
                    Bank.getInstance().listOfAccounts();
                    break;
                case CUSTOMER_OPERATIONS:
                    CustomerOperationsMenu.menu();
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
