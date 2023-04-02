package com.semillero.repository.contracts.dbModels.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public class SavingsAccountDbModel extends BankAccountDbModel{

    public SavingsAccountDbModel(int id, String accountNumber, float balance, AccountType type, int owner) {
        super(id, accountNumber, balance, type, owner);
    }

    public SavingsAccountDbModel(String accountNumber, float balance, AccountType type, int owner) {
        super(accountNumber, balance, type, owner);
    }

}
