package com.semillero.controllers.mappers.core;

import java.util.ArrayList;
import java.util.List;

import com.semillero.application.contracts.DTO.core.BankAccountDTO;
import com.semillero.application.contracts.DTO.core.CheckingAccountDTO;
import com.semillero.controllers.mappers.ModelMapperBase;
import com.semillero.controllers.models.core.BankAccountModel;
import com.semillero.controllers.models.core.CheckingAccountModel;

public class CheckingAccountControllerMapper extends ModelMapperBase<BankAccountModel, BankAccountDTO>{

    @Override
    public BankAccountModel DTOToModelMapper(BankAccountDTO input) {
        return new CheckingAccountModel(
            input.getAccountNumber(),
            input.getBalance(),
            input.getType(),
            input.getOwner()
        );
    }

    @Override
    public BankAccountDTO ModelToDTOMapper(BankAccountModel input) {
        return new CheckingAccountDTO(
            input.getAccountNumber(),
            input.getBalance(),
            input.getType(),
            input.getOwner()
        );
    }

    @Override
    public List<BankAccountModel> DTOToModelMapper(List<BankAccountDTO> input) {
        List<BankAccountModel> list = new ArrayList<BankAccountModel>();
        for (BankAccountDTO item : input) {
            list.add(this.DTOToModelMapper(item));
        }
        return list;
    }

    @Override
    public List<BankAccountDTO> ModelToDTOMapper(List<BankAccountModel> input) {
        List<BankAccountDTO> list = new ArrayList<BankAccountDTO>();
        for (BankAccountModel item : input) {
            list.add(this.ModelToDTOMapper(item));
        }
        return list;
    }
    
}
