package bank.menu;

public class MenuMessages {

    public static void errorMessage() {
        System.out.println("Wrong command!");
    }

    static void mainMenuInfo() {
        System.out.println("Log as customer: 1");
        System.out.println("Log as bank worker: 2");
        System.out.println("Exit: 0");
    }

    public static void bankWorkerMenuInfo() {
        System.out.println("List of customers: 1");
        System.out.println("List of accounts: 2");
        System.out.println("Customer operations: 3");
        System.out.println("Exit: 0");
    }

    public static void customerOperationsMenuInfo() {
        System.out.println("Create customer: 1");
        System.out.println("Remove customer: 2");
        System.out.println("View customer: 3");
        System.out.println("Exit: 0");
    }

    public static void viewCustomerMenuInfo() {
        System.out.println("Customer info: 1");
        System.out.println("Edit Customer: 2");
        System.out.println("List of customer accounts: 3");
        System.out.println("Add account: 4");
        System.out.println("Remove account: 5");
        System.out.println("View account: 6");
        System.out.println("Exit: 0");
    }

    public static void viewAccountMenuInfo() {
        System.out.println("Transactions history: 1");
        System.out.println("Make deposit: 2");
        System.out.println("Make payout: 3");
        System.out.println("Exit: 0");
    }

    public static void customerMenuInfo() {
        System.out.println("Edit your info: 1");
        System.out.println("View accounts: 2");
        System.out.println("Transactions: 3");
        System.out.println("Exit: 0");
    }

    public static void customerTransactionsMenuInfo() {
        System.out.println("Make transfer: 1");
        System.out.println("Transaction history: 2");
        System.out.println("Print transaction: 3");
        System.out.println("Exit: 0");
    }
}
