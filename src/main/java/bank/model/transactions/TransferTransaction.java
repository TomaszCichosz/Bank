package bank.model.transactions;

import bank.Bank;

import java.sql.Timestamp;
import java.util.UUID;

public class TransferTransaction extends Transaction {

    private String toAccountNumber;

    public TransferTransaction(UUID customerId, String accountNumber, String toAccountNumber, float transferValue) {
        transactionId = UUID.randomUUID();
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.toAccountNumber = toAccountNumber;
        this.value = transferValue;
        type = TransactionTypes.TRANSFER;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String transactionInfo() {
        return "Transaction type:\n" + type
                + "\nCustomer:\n" + Bank.getInstance().getCustomers().get(customerId)
                + "\nFrom account:\n" + accountNumber
                + "\nAmount:\n" + value
                + "\nTo account:\n" + Bank.getInstance().getAccounts().get(toAccountNumber).getCustomerId();
    }
}
