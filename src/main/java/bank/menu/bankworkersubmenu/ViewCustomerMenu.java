package bank.menu.bankworkersubmenu;

import bank.Bank;
import bank.Constants;
import bank.InputOutputMethods;

import java.util.UUID;

class ViewCustomerMenu {

    static void menu(UUID customerId) {
        final int CUSTOMER_INFO = 1;
        final int EDIT_CUSTOMER = 2;
        final int LIST_OF_ACCOUNTS = 3;
        final int ADD_ACCOUNT = 4;
        final int REMOVE_ACCOUNT = 5;
        final int VIEW_ACCOUNT = 6;
        final int EXIT_OPTION = 0;

        final String info = "Customer info: 1\nEdit Customer: 2\nList of customer accounts: 3\n" +
                "Add account: 4\nRemove account: 5\nView account: 6\nExit: 0";

        boolean exit = false;
        int decision;

        while (!exit) {
            System.out.println(info);
            decision = InputOutputMethods.getIntInput();
            switch (decision) {
                case CUSTOMER_INFO:
                    System.out.println(Bank.getInstance().getCustomers().get(customerId));
                    break;
                case EDIT_CUSTOMER:
                    Bank.getInstance().editCustomer(customerId);
                    break;
                case LIST_OF_ACCOUNTS:
                    Bank.getInstance().printListOfCustomerAccounts(Bank.getInstance().getAllCustomerAccounts(customerId));
                    break;
                case ADD_ACCOUNT:
                    Bank.getInstance().addAccount(customerId);
                    break;
                case REMOVE_ACCOUNT:
                    Bank.getInstance().removeAccount(customerId);
                    break;
                case VIEW_ACCOUNT:
                    System.out.println("Account number:");
                    ViewAccountMenu.menu(InputOutputMethods.getStringInput());
                    break;
                case EXIT_OPTION:
                    exit = true;
                    break;
                default:
                    System.out.println(Constants.errorMessage);
                    break;
            }
        }
    }
}
