package com.semillero.application.contracts.DTO.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public class SavingsAccountDTO extends BankAccountDTO{

    public static final int MAX_NUM_WITHDRAWALS = 3;
    public static final double WITHDRAWAL_PERCENTAGE = 0.01;
    public static final double DEPOSIT_PERCENTAGE = 0.005;
    public static final double MAX_NUM_DEPOSITS = 2;
    public static final double CURRENT_ACCOUNT_TRANSFER_FEE_PERCENTAGE = 0.015;
    private int numDeposits;

    
    public SavingsAccountDTO(int id, String accountNumber, float balance, AccountType type, int owner,
            int withdrawalCount) {
        super(id, accountNumber, balance, type, owner, withdrawalCount);
    }

    public SavingsAccountDTO(int id, String accountNumber, float balance, AccountType type, int owner) {
        super(id, accountNumber, balance, type, owner);
        this.numDeposits = 0;
    }
    
    public SavingsAccountDTO(String accountNumber, float balance, AccountType type, int owner) {
        super(accountNumber, balance, type, owner);
        this.numDeposits = 0;
    }
    
    public int getNumDeposits() {
        return numDeposits;
    }

    public void setNumDeposits(int numDeposits) {
        this.numDeposits = numDeposits;
    }

}
