package com.semillero.controllers.models.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public class CheckingAccountModel extends BankAccountModel{

    public CheckingAccountModel(String accountNumber, float balance, AccountType type, String owner) {
        super(accountNumber, balance, type, owner);
    }
    
}
