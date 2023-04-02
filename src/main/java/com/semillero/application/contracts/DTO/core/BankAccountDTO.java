package com.semillero.application.contracts.DTO.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public abstract class BankAccountDTO {
    private String accountNumber;
	private float balance;
	private String owner;
    private AccountType type;
    private int withdrawalCount;

    
    public BankAccountDTO(String accountNumber, float balance, AccountType type, String owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.owner = owner;
        this.withdrawalCount = 0;
    }
    
    public BankAccountDTO(String accountNumber, float balance, String owner, AccountType type, int withdrawalCount) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
        this.type = type;
        this.withdrawalCount = withdrawalCount;
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

    public int getWithdrawalCount() {
        return withdrawalCount;
    }

    public void setWithdrawalCount(int withdrawalCount) {
        this.withdrawalCount = withdrawalCount;
    }
}
