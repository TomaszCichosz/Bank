package bank.menu.bankworkersubmenu;

import bank.Bank;
import bank.InputOutputMethods;
import bank.menu.MenuMessages;

import java.util.UUID;

class CustomerOperationsMenu {

    static void menu() {
        final int CREATE_CUSTOMER = 1;
        final int REMOVE_CUSTOMER = 2;
        final int VIEW_CUSTOMER = 3;
        final int EXIT_OPTION = 0;

        boolean exit = false;
        int decision;

        while (!exit) {
            MenuMessages.customerOperationsMenuInfo();
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
                    MenuMessages.errorMessage();
                    break;
            }
        }
    }
}
