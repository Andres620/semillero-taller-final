package com.semillero.application.contracts.Iservices;

import java.util.List;

import com.semillero.application.contracts.DTO.core.UserDTO;

public interface IUserService {
    void saveUser(UserDTO data);
    UserDTO findUser(String identificationCard) throws Exception;
    void updateUser(UserDTO data);
    void deleteUser(String identificationCard);
    List<?> listUsers();
}
