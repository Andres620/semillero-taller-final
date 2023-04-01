package com.semillero.repository.contracts.dbModels.core;

public class SavingsAccountDbModel extends BankAccountDbModel{

    public SavingsAccountDbModel(String accountNumber, float balance, String type, String owner) {
        super(accountNumber, balance, type, owner);
    }

}
