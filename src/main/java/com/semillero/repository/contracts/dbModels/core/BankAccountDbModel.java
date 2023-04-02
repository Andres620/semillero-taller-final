package com.semillero.repository.contracts.dbModels.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public abstract class BankAccountDbModel{ 
    private int id;
    private String accountNumber;
	private float balance;
    private AccountType type;
	private int owner;

  

    public BankAccountDbModel(int id, String accountNumber, float balance, AccountType type, int owner) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.owner = owner;
    }

    public BankAccountDbModel(String accountNumber, float balance, AccountType type, int owner) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}