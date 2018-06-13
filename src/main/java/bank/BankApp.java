package bank;


import bank.menu.MainMenu;


public class BankApp {
    public static void main(String[] args) {
        Bank.getInstance().deserialization();
        MainMenu.start();
        Bank.getInstance().serialization();
    }
}
