package com.semillero.application.implementation.mappers.core;

import java.util.ArrayList;
import java.util.List;

import com.semillero.application.contracts.DTO.core.BankAccountDTO;
import com.semillero.application.contracts.DTO.core.CheckingAccountDTO;
import com.semillero.application.implementation.mappers.DTOMapperBase;
import com.semillero.repository.contracts.dbModels.core.BankAccountDbModel;
import com.semillero.repository.contracts.dbModels.core.CheckingAccountDbModel;

public class CheckingAccountApplicationMapper extends DTOMapperBase<BankAccountDTO, BankAccountDbModel>{

    @Override
    public BankAccountDTO DbModelToDTOMapper(BankAccountDbModel input) {
        return new CheckingAccountDTO(
            input.getAccountNumber(),
            input.getBalance(),
            input.getType(),
            input.getOwner()
        );
    }

    @Override
    public BankAccountDbModel DTOToDbModelMapper(BankAccountDTO input) {
        return new CheckingAccountDbModel(
            input.getAccountNumber(),
            input.getBalance(),
            input.getType(),
            input.getOwner()
        );
    }

    @Override
    public List<BankAccountDTO> DbModelToDTOMapper(List<BankAccountDbModel> input) {
        List<BankAccountDTO> list = new ArrayList<BankAccountDTO>();
        for (BankAccountDbModel item : input) {
            list.add(this.DbModelToDTOMapper(item));
        }
        return list;
    }

    @Override
    public List<BankAccountDbModel> DTOToDbModelMapper(List<BankAccountDTO> input) {
        List<BankAccountDbModel> list = new ArrayList<BankAccountDbModel>();
        for (BankAccountDTO item : input) {
            list.add(this.DTOToDbModelMapper(item));
        }
        return list;
    }

    
}
