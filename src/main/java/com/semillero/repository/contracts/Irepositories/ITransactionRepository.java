package com.semillero.repository.contracts.Irepositories;

import java.util.List;

import com.semillero.repository.contracts.dbModels.core.TransactionDbModel;

public interface ITransactionRepository {
    public void save(TransactionDbModel object);

    public void deleteTransactionsByAccountId(int acountId);

    public List<?> listTransactionByAccountId(int acountId);
}
