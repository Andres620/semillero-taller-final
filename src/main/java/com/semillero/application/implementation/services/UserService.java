package com.semillero.application.implementation.services;

import com.semillero.application.contracts.DTO.core.UserDTO;
import com.semillero.application.contracts.Iservices.IUserService;
import com.semillero.application.implementation.mappers.core.UserApplicationMapper;
import com.semillero.repository.contracts.Irepositories.IUserRepository;
import com.semillero.repository.contracts.dbModels.core.UserDbModel;
import com.semillero.repository.implementation.repositories.UserRepository;

public class UserService implements IUserService{

    private IUserRepository userRepository;
    UserApplicationMapper mapper;

    public UserService() {
        userRepository = new UserRepository();
        mapper = new UserApplicationMapper();
    }
     

    @Override
    public void saveUser(UserDTO data) {
        UserDbModel user = mapper.DTOToDbModelMapper(data);
        userRepository.save(user);
    }

    @Override
    public UserDTO findUser(String identificationCard) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUser'");
    }

    @Override
    public void updateUser(UserDTO data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(String identificationCard) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
    
}
