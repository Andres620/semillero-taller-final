package com.semillero.application.contracts.DTO.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;
import com.semillero.application.contracts.DTO.parameters.TransactionType;

public class TransactionDTO {
    private String date;
    private String time;
    private TransactionType transactionType;
    private double amount;
    private int accountId;
    private AccountType destinationAccountType;

    public TransactionDTO(String date, String time, TransactionType transactionType, double amount, int accountId, AccountType destinationAccountType) {
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

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
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

    public AccountType getDestinationAccountType() {
        return destinationAccountType;
    }

    public void setDestinationAccountType(AccountType destinationAccountType) {
        this.destinationAccountType = destinationAccountType;
    }
}
