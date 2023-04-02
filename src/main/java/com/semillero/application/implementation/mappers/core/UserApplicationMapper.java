package com.semillero.application.implementation.mappers.core;

import java.util.ArrayList;
import java.util.List;

import com.semillero.application.contracts.DTO.core.UserDTO;
import com.semillero.application.implementation.mappers.DTOMapperBase;
import com.semillero.repository.contracts.dbModels.core.UserDbModel;

public class UserApplicationMapper extends DTOMapperBase<UserDTO, UserDbModel>{

    @Override
    public UserDTO DbModelToDTOMapper(UserDbModel input) {
        return new UserDTO(input.getName(), input.getSurname(), input.getIdentificationCard());
    }

    @Override
    public UserDbModel DTOToDbModelMapper(UserDTO input) {
        return new UserDbModel(input.getName(), input.getSurname(), input.getIdentificationCard());
    }

    @Override
    public List<UserDTO> DbModelToDTOMapper(List<UserDbModel> input) {
        List<UserDTO> list = new ArrayList<UserDTO>();
        for (UserDbModel item : input) {
            list.add(this.DbModelToDTOMapper(item));
        }
        return list;
    }

    @Override
    public List<UserDbModel> DTOToDbModelMapper(List<UserDTO> input) {
        List<UserDbModel> list = new ArrayList<UserDbModel>();
        for (UserDTO item : input) {
            list.add(this.DTOToDbModelMapper(item));
        }
        return list;
    }
    
}
