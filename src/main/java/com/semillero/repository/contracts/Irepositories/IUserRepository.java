package com.semillero.repository.contracts.Irepositories;

import java.util.List;

import com.semillero.repository.contracts.dbModels.core.UserDbModel;

public interface IUserRepository {
    public void save(UserDbModel object);

    public void delete(String identifier);

    public void update(Object object);

    public Object search(String identifier);

    public List<?> list();

    public void updateId(Object object, String id);
}
