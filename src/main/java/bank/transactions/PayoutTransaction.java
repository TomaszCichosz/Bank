package bank.transactions;

import bank.Bank;

import java.sql.Timestamp;
import java.util.UUID;

public class PayoutTransaction extends Transaction {

    public PayoutTransaction(UUID customerId, String accountNumber, float value) {
        transactionId = UUID.randomUUID();
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.value = value;
        type = TransactionTypes.PAYOUT;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String transactionInfo() {
        return "Transaction type:\n" + type
                + "\nCustomer:\n" + Bank.getInstance().getCustomers().get(customerId)
                + "\nFrom account:\n" + accountNumber
                + "\nAmount:\n" + value;
    }
}
