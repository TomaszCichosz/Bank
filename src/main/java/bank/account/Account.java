package bank.account;

import bank.Bank;
import bank.transactions.DepositTransaction;
import bank.transactions.PayoutTransaction;
import bank.transactions.Transaction;
import bank.transactions.TransferTransaction;

import java.util.*;

public class Account {
    private UUID customerId;
    private String accountNumber;
    private float balance;
    private Map<UUID, Transaction> transactions;

    public Account(UUID customerId, String accountNumber) {
        this.customerId = customerId;
        transactions = new HashMap<>();
        balance = 0F;
        this.accountNumber = accountNumber;
    }

    public void deposit(float value) {
        this.balance += value;
        Transaction depositTransaction = new DepositTransaction(customerId, accountNumber, value);
        transactions.put(depositTransaction.getTransactionId(), depositTransaction);
    }

    public void payout(float value) {
        this.balance -= value;
        Transaction payoutTransaction = new PayoutTransaction(customerId, accountNumber, value);
        transactions.put(payoutTransaction.getTransactionId(), payoutTransaction);
    }

    public void transfer(String toAccountNumber, float transferValue) {
        if (transferValue <= Bank.getInstance().getAccounts().get(accountNumber).getBalance()) {
            decreaseBalance(transferValue);
            Bank.getInstance().getAccounts().get(toAccountNumber).increaseBalance(transferValue);
            Transaction transferTransaction = new TransferTransaction(customerId, accountNumber, toAccountNumber, transferValue);
            transactions.put(transferTransaction.getTransactionId(), transferTransaction);
        } else System.out.println("Insufficient funds");
    }

    public void transactionHistory() {
        for (Map.Entry<UUID, Transaction> temp : transactions.entrySet()) {
            System.out.println(temp.getValue());
        }
    }

    @Override
    public String toString() {
        return "account number: " + accountNumber + "\tbalance: " + balance;
    }

    public void increaseBalance(float amount) {
        this.balance += amount;
    }

    public void decreaseBalance(float amount) {
        this.balance -= amount;
    }

    public float getBalance() {
        return balance;
    }

    public Map<UUID, Transaction> getTransactions() {
        return transactions;
    }

    public UUID getCustomerId() {
        return customerId;
    }

}
