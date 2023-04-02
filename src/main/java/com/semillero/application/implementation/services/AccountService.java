package com.semillero.application.implementation.services;

import java.util.List;

import com.semillero.application.contracts.DTO.core.BankAccountDTO;
import com.semillero.application.contracts.DTO.parameters.AccountType;
import com.semillero.application.contracts.Iservices.IAccountService;
import com.semillero.application.implementation.mappers.core.CheckingAccountApplicationMapper;
import com.semillero.application.implementation.mappers.core.SavingsAccountApplicationMapper;
import com.semillero.repository.contracts.Irepositories.IAccountRepository;
import com.semillero.repository.contracts.Irepositories.IUserRepository;
import com.semillero.repository.contracts.dbModels.core.BankAccountDbModel;
import com.semillero.repository.implementation.repositories.AccountRepository;
import com.semillero.repository.implementation.repositories.UserRepository;

public class AccountService implements IAccountService{
    private IAccountRepository accountRepository;
    private IUserRepository userRepository;
    private CheckingAccountApplicationMapper mapperCheckingAccount;
    private SavingsAccountApplicationMapper mapperSavingsAccount;

    public AccountService() {
        accountRepository = new AccountRepository();
        userRepository = new UserRepository();
        mapperCheckingAccount = new CheckingAccountApplicationMapper();
        mapperSavingsAccount = new SavingsAccountApplicationMapper();
    }

    @Override
    public void saveAccount(BankAccountDTO data) {
        BankAccountDbModel account = null;
        if (data.getType().equals(AccountType.SAVINGS)) {
            account = mapperSavingsAccount.DTOToDbModelMapper(data);
        } else{
            account = mapperCheckingAccount.DTOToDbModelMapper(data);
        }
        if (userRepository.search(String.valueOf(account.getOwner())) != null){
            accountRepository.save(account);
        } else {
            throw new UnsupportedOperationException("The user does not exist");
        }
        
    }
    

    @Override
    public BankAccountDTO findAccount(String accountNumber) throws Exception {
        BankAccountDbModel accountDbModel = (BankAccountDbModel) accountRepository.search(accountNumber);
        if (accountDbModel == null) {
            throw new Exception("The user was not found");
        }
        BankAccountDTO accountDTO = null;
        if (accountDbModel.getType().equals(AccountType.SAVINGS)) {
            accountDTO = mapperSavingsAccount.DbModelToDTOMapper(accountDbModel);
        } else{
            accountDTO = mapperCheckingAccount.DbModelToDTOMapper(accountDbModel);
        }
        return accountDTO;
    }

    @Override
    public void updateAccount(String accountNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }

    @Override
    public void deleteAccount(String accountNumber) {
        accountRepository.delete(accountNumber);
    }

    @Override
    public List<?> listAccountsByUserId(int userId) {
        List<BankAccountDTO> users =  mapperCheckingAccount.DbModelToDTOMapper((List<BankAccountDbModel>) accountRepository.listByUserId(userId));
        return users;
    }
    
}
