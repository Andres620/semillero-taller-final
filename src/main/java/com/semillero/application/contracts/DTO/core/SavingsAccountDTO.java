package com.semillero.application.contracts.DTO.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public class SavingsAccountDTO extends BankAccountDTO{
    public SavingsAccountDTO(String accountNumber, float balance, AccountType type, String owner) {
        super(accountNumber, balance, type, owner);
    }

}
