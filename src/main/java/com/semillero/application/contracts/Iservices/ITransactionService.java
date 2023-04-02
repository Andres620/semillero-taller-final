package com.semillero.application.contracts.Iservices;

import java.util.List;

import com.semillero.application.contracts.DTO.core.TransactionDTO;

public interface ITransactionService {
    void saveTransaction(TransactionDTO data);
    void deleteTransactionsAccount(int accountId);
    List<?> listTransactionsAccount(int accountId);
}
