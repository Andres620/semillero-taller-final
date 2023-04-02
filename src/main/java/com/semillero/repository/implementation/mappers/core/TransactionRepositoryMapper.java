package com.semillero.repository.implementation.mappers.core;

import java.util.ArrayList;
import java.util.List;

import com.semillero.repository.contracts.dbModels.core.TransactionDbModel;
import com.semillero.application.contracts.DTO.parameters.AccountType;
import com.semillero.application.contracts.DTO.parameters.TransactionType;
import com.semillero.repository.implementation.dataModel.core.Transaction;
import com.semillero.repository.implementation.mappers.DbModelMapperBase;

public class TransactionRepositoryMapper extends DbModelMapperBase<TransactionDbModel, Transaction>{

    @Override
    public TransactionDbModel DatabaseToDbModelMapper(Transaction input) {
        return new TransactionDbModel(
            input.getId(), 
            input.getDate(),
            input.getTime(),
            TransactionType.valueOf(input.getTransactionType()),
            input.getAmount(),
            input.getAccountId(),
            AccountType.valueOf(input.getDestinationAccountType())
        );
    }

    @Override
    public Transaction DbModelToDatabaseMapper(TransactionDbModel input) {
        return new Transaction(
            input.getId(), 
            input.getDate(),
            input.getTime(),
            input.getTransactionType().toString(),
            input.getAmount(),
            input.getAccountId(),
            input.getDestinationAccountType().toString()
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
