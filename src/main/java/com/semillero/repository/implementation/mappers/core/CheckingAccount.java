package com.semillero.repository.implementation.mappers.core;

import java.util.ArrayList;
import java.util.List;

import com.semillero.repository.contracts.dbModels.core.BankAccountDbModel;
import com.semillero.repository.contracts.dbModels.core.CheckingAccountDbModel;
import com.semillero.repository.implementation.dataModel.core.Account;
import com.semillero.repository.implementation.mappers.DbModelMapperBase;

public class CheckingAccount  extends DbModelMapperBase<BankAccountDbModel, Account>{

    @Override
    public BankAccountDbModel DatabaseToDbModelMapper(Account input) {
        return new CheckingAccountDbModel(
            input.getAccountNumber(),
            input.getBalance(),
            input.getType(),
            input.getOwner()
        );
    }

    @Override
    public Account DbModelToDatabaseMapper(BankAccountDbModel input) {
        return new Account(
            input.getAccountNumber(),
            input.getBalance(),
            input.getType(),
            input.getOwner()
        );
    }

    @Override
    public List<BankAccountDbModel> DatabaseToDbModelMapper(List<Account> input) {
        List<BankAccountDbModel> list = new ArrayList<BankAccountDbModel>();
        for (Account item : input) {
            list.add(this.DatabaseToDbModelMapper(item));
        }
        return list;
    }

    @Override
    public List<Account> DbModelToDatabaseMapper(List<BankAccountDbModel> input) {
        List<Account> list = new ArrayList<Account>();
        for (BankAccountDbModel item : input) {
            list.add(this.DbModelToDatabaseMapper(item));
        }
        return list;
    }
    
    
}
