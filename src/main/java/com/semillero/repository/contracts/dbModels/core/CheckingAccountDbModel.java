package com.semillero.repository.contracts.dbModels.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public class CheckingAccountDbModel extends BankAccountDbModel{

    public CheckingAccountDbModel(int id, String accountNumber, float balance, AccountType type, int owner) {
        super(id, accountNumber, balance, type, owner);
    }

    public CheckingAccountDbModel(String accountNumber, float balance, AccountType type, int owner) {
        super(accountNumber, balance, type, owner);
    }
    
}
