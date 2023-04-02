package com.semillero.controllers.models.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public class SavingsAccountModel extends BankAccountModel{

    public SavingsAccountModel(String accountNumber, float balance, AccountType type, String owner) {
        super(accountNumber, balance, type, owner);
    }
    
}
