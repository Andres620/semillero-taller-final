package com.semillero.application.contracts.DTO.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public class CheckingAccountDTO extends BankAccountDTO{
    public CheckingAccountDTO(String accountNumber, float balance, AccountType type, String owner) {
        super(accountNumber, balance, type, owner);
    }
}
