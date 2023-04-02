package com.semillero.application.implementation.services;

import java.util.List;

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
    public UserDTO findUser(String identificationCard) throws Exception {
        UserDbModel userDbModel = (UserDbModel) userRepository.search(identificationCard);
        if (userDbModel == null) {
            throw new Exception("The user was not found");
        }
        UserDTO userDTO = mapper.DbModelToDTOMapper(userDbModel);
        return userDTO;
    }

    @Override
    public void updateUser(UserDTO data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(String identificationCard) {
        userRepository.delete(identificationCard);
    }


    @Override
    public List<UserDTO> listUsers() {
        List<UserDTO> users =  mapper.DbModelToDTOMapper((List<UserDbModel>) userRepository.list());
        return users;
    }
    
}
