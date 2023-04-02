package com.semillero.repository.contracts.Irepositories;

import java.util.List;

import com.semillero.repository.contracts.dbModels.core.BankAccountDbModel;

public interface IAccountRepository {
    public void save(BankAccountDbModel object);

    public void delete(String identifier);

    public void update(Object object);

    public Object search(int identifier);

    public List<?> listByUserId(int userId);

    public void updateId(Object object, String id);
}
