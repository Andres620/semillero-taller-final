package com.semillero.controllers.mappers.core;

import java.util.ArrayList;
import java.util.List;

import com.semillero.application.contracts.DTO.core.TransactionDTO;
import com.semillero.controllers.mappers.ModelMapperBase;
import com.semillero.controllers.models.core.TransactionModel;

public class TransactionControllerMapper extends ModelMapperBase<TransactionModel, TransactionDTO>{

    @Override
    public TransactionModel DTOToModelMapper(TransactionDTO input) {
        return new TransactionModel(
            input.getDate(),
            input.getTime(),
            input.getTransactionType(),
            input.getAmount(),
            input.getAccountId(),
            input.getDestinationAccountType()
        );
    }

    @Override
    public TransactionDTO ModelToDTOMapper(TransactionModel input) {
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
    public List<TransactionModel> DTOToModelMapper(List<TransactionDTO> input) {
        List<TransactionModel> list = new ArrayList<TransactionModel>();
        for (TransactionDTO item : input) {
            list.add(this.DTOToModelMapper(item));
        }
        return list;
    }

    @Override
    public List<TransactionDTO> ModelToDTOMapper(List<TransactionModel> input) {
        List<TransactionDTO> list = new ArrayList<TransactionDTO>();
        for (TransactionModel item : input) {
            list.add(this.ModelToDTOMapper(item));
        }
        return list;
    }
    
}
