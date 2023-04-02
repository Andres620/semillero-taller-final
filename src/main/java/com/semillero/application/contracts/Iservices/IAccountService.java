package com.semillero.application.contracts.Iservices;

import java.util.List;

import com.semillero.application.contracts.DTO.core.BankAccountDTO;

public interface IAccountService {
    void saveAccount(BankAccountDTO data);
    BankAccountDTO findAccount(String accountNumber) throws Exception;
    void updateAccount(String accountNumber);
    void deleteAccount(String accountNumber);
    List<?> listAccountsByUserId(int userId);
}
