package bank.menu.customersubmenu;

import bank.Bank;
import bank.Constants;
import bank.InputOutputMethods;

import java.util.UUID;

class CustomerTransactionsMenu {

    static void menu(String accountNumber) {
        final int MAKE_TRANSFER = 1;
        final int TRANSACTION_HISTORY = 2;
        final int PRINT_TRANSACTION = 3;
        final int EXIT_OPTION = 0;

        final String info = "Make transfer: 1\nTransaction history: 2\nPrint transaction: 3\nExit: 0";

        boolean exit = false;
        int decision;

        while (!exit) {
            System.out.println(info);
            decision = InputOutputMethods.getIntInput();
            switch (decision) {
                case MAKE_TRANSFER:
                    Bank.getInstance().transfer();
                    break;
                case TRANSACTION_HISTORY:
                    Bank.getInstance().getAccounts().get(accountNumber).transactionHistory();
                    break;
                case PRINT_TRANSACTION:
                    System.out.println("Transaction UUID:");
                    InputOutputMethods.stringToFile(Bank.getInstance().getAccounts().get(accountNumber).getTransactions().
                            get(UUID.fromString(InputOutputMethods.getStringInput())).transactionInfo(), "Transaction");
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
