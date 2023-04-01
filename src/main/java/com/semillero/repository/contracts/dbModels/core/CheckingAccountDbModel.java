package com.semillero.repository.contracts.dbModels.core;

import com.semillero.repository.contracts.dbModels.parameters.AccountType;

public class CheckingAccountDbModel extends BankAccountDbModel{

    public CheckingAccountDbModel(String accountNumber, float balance, AccountType type, String owner) {
        super(accountNumber, balance, type, owner);
    }
    
}
