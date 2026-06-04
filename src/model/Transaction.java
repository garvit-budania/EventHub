package model;

public class Transaction {

    private int transactionId;
    private int userId;
    private double amount;
    private String transactionType;

    public Transaction() {}

    public Transaction(int transactionId,
                       int userId,
                       double amount,
                       String transactionType) {

        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.transactionType = transactionType;
    }
}
