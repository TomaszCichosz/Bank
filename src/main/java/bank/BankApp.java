package bank;


import bank.menu.MainMenu;


public class BankApp {
    public static void main(String[] args) {
        if (Bank.getInstance().deserialize()) {
            System.out.println("Deserialization successful");
        } else System.out.println("Deserialization unsuccessful");
        MainMenu.start();
        if (Bank.getInstance().serialize()) {
            System.out.println("Serialization successful");
        } else System.out.println("Serialization unsuccessful");
    }
}
