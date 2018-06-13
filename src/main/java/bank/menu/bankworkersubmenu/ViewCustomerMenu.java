package bank.menu.bankworkersubmenu;

import bank.Bank;
import bank.InputOutputMethods;
import bank.menu.MenuMessages;

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

        boolean exit = false;
        int decision;

        while (!exit) {
            MenuMessages.viewCustomerMenuInfo();
            decision = InputOutputMethods.getIntInput();
            switch (decision) {
                case CUSTOMER_INFO:
                    System.out.println(Bank.getInstance().getCustomers().get(customerId));
                    break;
                case EDIT_CUSTOMER:
                    Bank.getInstance().editCustomer(customerId);
                    break;
                case LIST_OF_ACCOUNTS:
                    Bank.getInstance().listOfCustomerAccounts(Bank.getInstance().getAllCustomerAccounts(customerId));
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
                    MenuMessages.errorMessage();
                    break;
            }
        }
    }
}
