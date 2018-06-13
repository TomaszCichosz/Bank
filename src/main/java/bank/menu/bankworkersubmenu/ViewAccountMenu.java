package bank.menu.bankworkersubmenu;

import bank.Bank;
import bank.Constants;
import bank.InputOutputMethods;

class ViewAccountMenu {

    static void menu(String accountNumber) {
        final int TRANSACTIONS_HISTORY = 1;
        final int MAKE_DEPOSIT = 2;
        final int MAKE_PAYOUT = 3;
        final int EXIT_OPTION = 0;

        final String info = "Transactions history: 1\nMake deposit: 2\nMake payout: 3\nExit: 0";

        boolean exit = false;
        int decision;

        while (!exit) {
            System.out.println(info);
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
                    System.out.println(Constants.errorMessage);
                    break;
            }
        }
    }
}
