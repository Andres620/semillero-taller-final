package com.semillero.repository.implementation.mappers.core;

import java.util.ArrayList;
import java.util.List;

import com.semillero.repository.contracts.dbModels.core.TransactionDbModel;
import com.semillero.repository.implementation.dataModel.core.Transaction;
import com.semillero.repository.implementation.mappers.DbModelMapperBase;

public class TransactionRepositoryMaper extends DbModelMapperBase<TransactionDbModel, Transaction>{

    @Override
    public TransactionDbModel DatabaseToDbModelMapper(Transaction input) {
        return new TransactionDbModel(
            input.getDate(),
            input.getTime(),
            input.getTransactionType(),
            input.getAmount(),
            input.getAccountId(),
            input.getDestinationAccountType()
        );
    }

    @Override
    public Transaction DbModelToDatabaseMapper(TransactionDbModel input) {
        return new Transaction(
            input.getDate(),
            input.getTime(),
            input.getTransactionType(),
            input.getAmount(),
            input.getAccountId(),
            input.getDestinationAccountType()
        );
    }

    @Override
    public List<TransactionDbModel> DatabaseToDbModelMapper(List<Transaction> input) {
        List<TransactionDbModel> list = new ArrayList<TransactionDbModel>();
        for (Transaction item : input) {
            list.add(this.DatabaseToDbModelMapper(item));
        }
        return list;
    }

    @Override
    public List<Transaction> DbModelToDatabaseMapper(List<TransactionDbModel> input) {
        List<Transaction> list = new ArrayList<Transaction>();
        for (TransactionDbModel item : input) {
            list.add(this.DbModelToDatabaseMapper(item));
        }
        return list;
    }
    
    
}
