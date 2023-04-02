package com.semillero.repository.implementation.dataModel.core;

public class Transaction {
    private int id;
    private String date;
    private String time;
    private String transactionType;
    private double amount;
    private int accountId;
    private String destinationAccountType;

    public Transaction(int id, String date, String time, String transactionType, double amount, int accountId,
            String destinationAccountType) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.transactionType = transactionType;
        this.amount = amount;
        this.accountId = accountId;
        this.destinationAccountType = destinationAccountType;
    }

    public Transaction(String date, String time, String transactionType, double amount, int accountId, String destinationAccountType) {
        this.date = date;
        this.time = time;
        this.transactionType = transactionType;
        this.amount = amount;
        this.accountId = accountId;
        this.destinationAccountType = destinationAccountType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getDestinationAccountType() {
        return destinationAccountType;
    }

    public void setDestinationAccountType(String destinationAccountType) {
        this.destinationAccountType = destinationAccountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
