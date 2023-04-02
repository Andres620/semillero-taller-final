package com.semillero.controllers.mappers.core;

import java.util.ArrayList;
import java.util.List;

import com.semillero.application.contracts.DTO.core.UserDTO;
import com.semillero.controllers.mappers.ModelMapperBase;
import com.semillero.controllers.models.core.UserModel;

public class UserControllerMapper extends ModelMapperBase<UserModel, UserDTO>{

    @Override
    public UserModel DTOToModelMapper(UserDTO input) {
        return new UserModel(input.getName(), input.getSurname(), input.getIdentificationCard());
    }

    @Override
    public UserDTO ModelToDTOMapper(UserModel input) {
        return new UserDTO(input.getName(), input.getSurname(), input.getIdentificationCard());
    }

    @Override
    public List<UserModel> DTOToModelMapper(List<UserDTO> input) {
        List<UserModel> list = new ArrayList<UserModel>();
        for (UserDTO item : input) {
            list.add(this.DTOToModelMapper(item));
        }
        return list;
    }

    @Override
    public List<UserDTO> ModelToDTOMapper(List<UserModel> input) {
        List<UserDTO> list = new ArrayList<UserDTO>();
        for (UserModel item : input) {
            list.add(this.ModelToDTOMapper(item));
        }
        return list;
    }
    
}
