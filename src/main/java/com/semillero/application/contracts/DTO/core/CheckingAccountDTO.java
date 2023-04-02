package com.semillero.application.contracts.DTO.core;

import com.semillero.application.contracts.DTO.parameters.AccountType;

public class CheckingAccountDTO extends BankAccountDTO{
    public static final int MAX_NUM_WITHDRAWALS = 5;
    public static final int MAX_NUM_SAVINGS_TRANSFERS = 2;
    public static final double TRANSFER_FEE_PERCENTAGE = 0.02;
    private int savingsTransfersCount;

    public CheckingAccountDTO(int id, String accountNumber, float balance, AccountType type, int owner,
            int withdrawalCount, int savingsTransfersCount) {
        super(id, accountNumber, balance, type, owner, withdrawalCount);
        this.savingsTransfersCount = savingsTransfersCount;
    }

    public CheckingAccountDTO(String accountNumber, float balance, int owner, AccountType type, int withdrawalCount,
            int savingsTransfersCount) {
        super(accountNumber, balance, owner, type, withdrawalCount);
        this.savingsTransfersCount = savingsTransfersCount;
    }

    public CheckingAccountDTO(String accountNumber, float balance, AccountType type, int owner) {
        super(accountNumber, balance, type, owner);
        this.savingsTransfersCount= 0;
    }

    public CheckingAccountDTO(int id, String accountNumber, float balance, AccountType type, int owner) {
        super(id, accountNumber, balance, type, owner);
        this.savingsTransfersCount= 0;
    }

    public static int getMaxNumWithdrawals() {
        return MAX_NUM_WITHDRAWALS;
    }

    public static int getMaxNumSavingsTransfers() {
        return MAX_NUM_SAVINGS_TRANSFERS;
    }

    public static double getTransferFeePercentage() {
        return TRANSFER_FEE_PERCENTAGE;
    }

    public int getSavingsTransfersCount() {
        return savingsTransfersCount;
    }

    public void setSavingsTransfersCount(int savingsTransfersCount) {
        this.savingsTransfersCount = savingsTransfersCount;
    }
}
