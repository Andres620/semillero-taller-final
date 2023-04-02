package com.semillero.controllers.models.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public abstract class BankAccountModel {
    private String accountNumber;
	private float balance;
	private int owner;
    private AccountType type;
    
    public BankAccountModel(String accountNumber, float balance, AccountType type, int owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public float getBalance() {
        return balance;
    }
    
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    public int getOwner() {
        return owner;
    }
    
    public void setOwner(int owner) {
        this.owner = owner;
    }
    
    public AccountType getType() {
        return type;
    }
    
    public void setType(AccountType type) {
        this.type = type;
    }
}
