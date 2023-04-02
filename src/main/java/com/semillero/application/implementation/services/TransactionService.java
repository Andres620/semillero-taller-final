package com.semillero.application.implementation.services;

import java.util.List;

import com.semillero.application.contracts.DTO.core.TransactionDTO;
import com.semillero.application.contracts.Iservices.ITransactionService;
import com.semillero.application.implementation.mappers.core.TransactionApplicationMapper;
import com.semillero.repository.contracts.Irepositories.IAccountRepository;
import com.semillero.repository.contracts.Irepositories.ITransactionRepository;
import com.semillero.repository.contracts.dbModels.core.TransactionDbModel;
import com.semillero.repository.implementation.repositories.AccountRepository;
import com.semillero.repository.implementation.repositories.TransactionRepository;

public class TransactionService implements ITransactionService{
    private ITransactionRepository transactionRepository;
    private IAccountRepository accountRepository;
    private TransactionApplicationMapper mapper;

    public TransactionService() {
        transactionRepository = new TransactionRepository();
        accountRepository = new AccountRepository();
        mapper = new TransactionApplicationMapper();
    }
    @Override
    public void saveTransaction(TransactionDTO data) {
        TransactionDbModel transaction = mapper.DTOToDbModelMapper(data);
        if (accountRepository.search(transaction.getAccountId()) != null){
            transactionRepository.save(transaction);
        } else {
            throw new UnsupportedOperationException("The account does not exist");
        }
        
    }

    @Override
    public void deleteTransactionsAccount(int accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTransactionsAccount'");
    }

    @Override
    public List<?> listTransactionsAccount(int accountId) {
        List<TransactionDTO> transactions =  mapper.DbModelToDTOMapper((List<TransactionDbModel>) 
                transactionRepository.listTransactionByAccountId(accountId));
        return transactions;
    }
    
}
