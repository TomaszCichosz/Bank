package bank.menu.bankworkersubmenu;

import bank.Bank;
import bank.InputOutputMethods;
import bank.menu.MenuMessages;

public class ViewAccountMenu {

    static void menu(String accountNumber) {
        final int TRANSACTIONS_HISTORY = 1;
        final int MAKE_DEPOSIT = 2;
        final int MAKE_PAYOUT = 3;
        final int EXIT_OPTION = 0;

        boolean exit = false;
        int decision;

        while (!exit) {
            MenuMessages.viewAccountMenuInfo();
            decision = InputOutputMethods.getIntInput();
            switch (decision) {
                case TRANSACTIONS_HISTORY:
                    Bank.getInstance().getAccounts().get(accountNumber).transactionHistory();
                    break;
                case MAKE_DEPOSIT:
                    System.out.println("Deposit amount:");
                    Bank.getInstance().getAccounts().get(accountNumber).deposit(InputOutputMethods.getFloatInput());
                    break;
                case MAKE_PAYOUT:
                    System.out.println("Payout amount:");
                    Bank.getInstance().getAccounts().get(accountNumber).payout(InputOutputMethods.getFloatInput());
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
