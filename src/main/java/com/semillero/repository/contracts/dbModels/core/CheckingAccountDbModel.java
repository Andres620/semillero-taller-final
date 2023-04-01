package com.semillero.repository.contracts.dbModels.core;

public class CheckingAccountDbModel extends BankAccountDbModel{

    public CheckingAccountDbModel(String accountNumber, float balance, String type, String owner) {
        super(accountNumber, balance, type, owner);
    }
    
}
