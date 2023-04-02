package com.semillero.repository.contracts.dbModels.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public abstract class BankAccountDbModel{ 
    private String accountNumber;
	private float balance;
	private String owner;
    private AccountType type;

    public BankAccountDbModel(String accountNumber, float balance, AccountType type, String owner) {
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
    
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public AccountType getType() {
        return type;
    }
    
    public void setType(AccountType type) {
        this.type = type;
    }
}