package com.semillero.repository.implementation.dataModel.core;

public class Account{ 
    private int id;
    private String accountNumber;
	private float balance;
    private String type;
	private int owner;



    public Account(int id, String accountNumber, float balance, String type, int owner) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.owner = owner;
    }

    public Account(String accountNumber, float balance, String type, int owner) {
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
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}