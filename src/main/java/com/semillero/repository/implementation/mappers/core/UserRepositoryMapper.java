package com.semillero.repository.implementation.mappers.core;

import java.util.ArrayList;
import java.util.List;

import com.semillero.repository.contracts.dbModels.core.UserDbModel;
import com.semillero.repository.implementation.dataModel.core.User;
import com.semillero.repository.implementation.mappers.DbModelMapperBase;

public class UserRepositoryMapper extends DbModelMapperBase<UserDbModel, User>{

    @Override
    public UserDbModel DatabaseToDbModelMapper(User input) {
        return new UserDbModel(input.getName(), input.getSurname(), input.getIdentificationCard());
    }

    @Override
    public User DbModelToDatabaseMapper(UserDbModel input) {
        return new User(input.getName(), input.getSurname(), input.getIdentificationCard());
    }

    @Override
    public List<UserDbModel> DatabaseToDbModelMapper(List<User> input) {
        List<UserDbModel> list = new ArrayList<UserDbModel>();
        for (User item : input) {
            list.add(this.DatabaseToDbModelMapper(item));
        }
        return list;
    }

    @Override
    public List<User> DbModelToDatabaseMapper(List<UserDbModel> input) {
        List<User> list = new ArrayList<User>();
        for (UserDbModel item : input) {
            list.add(this.DbModelToDatabaseMapper(item));
        }
        return list;
    }
    
}
