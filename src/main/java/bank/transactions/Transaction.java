package bank.transactions;

import bank.Bank;

import java.sql.Timestamp;
import java.util.UUID;

public abstract class Transaction {
    TransactionTypes type;
    float value;
    Timestamp timestamp;
    String accountNumber;
    UUID transactionId, customerId;

    public UUID getTransactionId() {
        return transactionId;
    }

    abstract public String transactionInfo();

    @Override
    public String toString() {
        return "Transaction id:\t" + transactionId + "\tTransaction type:\t" + type + "\tTime:\t" + timestamp;
    }
}
