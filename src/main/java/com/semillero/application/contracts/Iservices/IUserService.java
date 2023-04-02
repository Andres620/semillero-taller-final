package com.semillero.application.contracts.Iservices;

import com.semillero.application.contracts.DTO.core.UserDTO;

public interface IUserService {
    void saveUser(UserDTO data);
    UserDTO findUser(String identificationCard);
    void updateUser(UserDTO data);
    void deleteUser(String identificationCard);
}
