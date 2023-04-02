package com.semillero.repository.contracts.dbModels.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public class SavingsAccountDbModel extends BankAccountDbModel{

    public SavingsAccountDbModel(String accountNumber, float balance, AccountType type, int owner) {
        super(accountNumber, balance, type, owner);
    }

}
