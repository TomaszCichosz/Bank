package bank.menu.customersubmenu;

import bank.Bank;
import bank.InputOutputMethods;
import bank.menu.MenuMessages;
import bank.transactions.Transaction;

import java.util.UUID;

public class CustomerTransactionsMenu {

    static void menu(String accountNumber) {
        final int MAKE_TRANSFER = 1;
        final int TRANSACTION_HISTORY = 2;
        final int PRINT_TRANSACTION = 3;
        final int EXIT_OPTION = 0;

        boolean exit = false;
        int decision;

        while (!exit) {
            MenuMessages.customerTransactionsMenuInfo();
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
                            get(UUID.fromString(InputOutputMethods.getStringInput())).transactionInfo(),"Transaction");
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
