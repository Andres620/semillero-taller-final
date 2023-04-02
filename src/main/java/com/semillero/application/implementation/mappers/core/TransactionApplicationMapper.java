package com.semillero.application.implementation.mappers.core;

import java.util.ArrayList;
import java.util.List;

import com.semillero.application.contracts.DTO.core.TransactionDTO;
import com.semillero.application.implementation.mappers.DTOMapperBase;
import com.semillero.repository.contracts.dbModels.core.TransactionDbModel;

public class TransactionApplicationMapper extends DTOMapperBase<TransactionDTO, TransactionDbModel>{

    @Override
    public TransactionDTO DbModelToDTOMapper(TransactionDbModel input) {
        return new TransactionDTO(
            input.getDate(),
            input.getTime(),
            input.getTransactionType(),
            input.getAmount(),
            input.getAccountId(),
            input.getDestinationAccountType()
        );
    }

    @Override
    public TransactionDbModel DTOToDbModelMapper(TransactionDTO input) {
        return new TransactionDbModel(
            input.getDate(),
            input.getTime(),
            input.getTransactionType(),
            input.getAmount(),
            input.getAccountId(),
            input.getDestinationAccountType()
        );
    }

    @Override
    public List<TransactionDTO> DbModelToDTOMapper(List<TransactionDbModel> input) {
        List<TransactionDTO> list = new ArrayList<TransactionDTO>();
        for (TransactionDbModel item : input) {
            list.add(this.DbModelToDTOMapper(item));
        }
        return list;
    }

    @Override
    public List<TransactionDbModel> DTOToDbModelMapper(List<TransactionDTO> input) {
        List<TransactionDbModel> list = new ArrayList<TransactionDbModel>();
        for (TransactionDTO item : input) {
            list.add(this.DTOToDbModelMapper(item));
        }
        return list;
    }
    
}
