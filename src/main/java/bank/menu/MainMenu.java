package bank.menu;

import bank.Constants;
import bank.InputOutputMethods;
import bank.menu.bankworkersubmenu.BankWorkerMenu;
import bank.menu.customersubmenu.CustomerMenu;

import java.util.UUID;

public class MainMenu {

    public static void start() {
        final int LOG_AS_CUSTOMER = 1;
        final int LOG_AS_BANK_WORKER = 2;
        final int EXIT_OPTION = 0;

        final String info = "Log as customer: 1\nLog as bank worker: 2\nExit: 0";

        boolean exit = false;
        int decision;

        while (!exit) {
            System.out.println(info);
            decision = InputOutputMethods.getIntInput();
            switch (decision) {
                case LOG_AS_CUSTOMER:
                    System.out.println("Customer UUID:");
                    CustomerMenu.menu(UUID.fromString(InputOutputMethods.getStringInput()));
                    break;
                case LOG_AS_BANK_WORKER:
                    BankWorkerMenu.menu();
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
