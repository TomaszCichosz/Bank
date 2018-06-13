package bank.menu.bankworkersubmenu;

import bank.Bank;
import bank.Constants;
import bank.InputOutputMethods;

import java.util.UUID;

class CustomerOperationsMenu {

    static void menu() {
        final int CREATE_CUSTOMER = 1;
        final int REMOVE_CUSTOMER = 2;
        final int VIEW_CUSTOMER = 3;
        final int EXIT_OPTION = 0;

        final String info = "Create customer: 1\nRemove customer: 2\nView customer: 3\nExit: 0";

        boolean exit = false;
        int decision;

        while (!exit) {
            System.out.println(info);
            decision = InputOutputMethods.getIntInput();
            switch (decision) {
                case CREATE_CUSTOMER:
                    Bank.getInstance().createCustomer();
                    break;
                case REMOVE_CUSTOMER:
                    Bank.getInstance().removeCustomer();
                    break;
                case VIEW_CUSTOMER:
                    System.out.println("Customer UUID:");
                    ViewCustomerMenu.menu(UUID.fromString(InputOutputMethods.getStringInput()));
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
