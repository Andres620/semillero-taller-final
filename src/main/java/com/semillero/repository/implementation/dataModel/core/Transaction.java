package com.semillero.repository.implementation.dataModel.core;

import java.sql.Time;
import java.util.Date;

public class Transaction {
    private Date date;
    private Time time;
    private String transactionType;
    private double amount;
    private String accountId;
    private String destinationAccountType;

    public Transaction(Date date, Time time, String transactionType, double amount, String accountId, String destinationAccountType) {
        this.date = date;
        this.time = time;
        this.transactionType = transactionType;
        this.amount = amount;
        this.accountId = accountId;
        this.destinationAccountType = destinationAccountType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDestinationAccountType() {
        return destinationAccountType;
    }

    public void setDestinationAccountType(String destinationAccountType) {
        this.destinationAccountType = destinationAccountType;
    }
}
