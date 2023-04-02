package com.semillero.repository.implementation.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semillero.application.contracts.DTO.parameters.AccountType;
import com.semillero.repository.contracts.Irepositories.IAccountRepository;
import com.semillero.repository.contracts.dbModels.core.BankAccountDbModel;
import com.semillero.repository.implementation.dataModel.core.Account;
import com.semillero.repository.implementation.mappers.core.CheckingAccountRepositoryMapper;
import com.semillero.repository.implementation.mappers.core.SavingsAccountRepositoryMapper;

public class AccountRepository implements IAccountRepository{

    private String connectionString;
    private CheckingAccountRepositoryMapper mapperCheckingAccount;
    private SavingsAccountRepositoryMapper mapperSavingsAccount;

    public AccountRepository() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            connectionString = "jdbc:sqlite:banco.db";
            mapperCheckingAccount = new CheckingAccountRepositoryMapper();
            mapperSavingsAccount = new SavingsAccountRepositoryMapper();
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e);
        }
    }
    @Override
    public void save(BankAccountDbModel object) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            Account account;
            if(object.getType().equals(AccountType.SAVINGS)) {
                account = mapperSavingsAccount.DbModelToDatabaseMapper(object);
            } else {
                account = mapperCheckingAccount.DbModelToDatabaseMapper(object);
            }
            String sqlQuery = "INSERT INTO cuentas (numero_cuenta, saldo, tipo_cuenta, id_usuario) " 
                + "VALUES (?, ?, ?, ?)";

            PreparedStatement statement  = connection.prepareStatement(sqlQuery);
            statement.setString(1, account.getAccountNumber());
            statement.setDouble(2, account.getBalance());
            statement.setString(3, account.getType());
            statement.setInt(4, account.getOwner());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Connection error: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }     
    }

    @Override
    public void delete(String identifier) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sqlQuery = "DELETE FROM cuentas WHERE id_usuario = ?;";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, identifier);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting account:  " + e.getMessage());
        }
    }

    @Override
    public void update(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Object search(String identifier) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sqlQuery = "SELECT * FROM cuentas WHERE numero_cuenta = ?";

            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, identifier);
            ResultSet response = statement.executeQuery();
            if (response != null && response.next()) {
                Account account = null;
                BankAccountDbModel accountDbModel = null;
                int id = response.getInt("id");
                String accountNumber = response.getString("numero_cuenta");
                float balance = response.getFloat("saldo");
                String type = response.getString("tipo_cuenta");
                int owner = response.getInt("id_usuario");


                if(type.equals(AccountType.SAVINGS)) {
                    account = new Account(id, accountNumber, balance, type, owner);
                    accountDbModel = mapperSavingsAccount.DatabaseToDbModelMapper(account);
                } else {
                    account = new Account(id, accountNumber, balance, type, owner);
                    accountDbModel = mapperCheckingAccount.DatabaseToDbModelMapper(account);
                }
                return accountDbModel;
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public List<?> listByUserId(int userId) {
        List<BankAccountDbModel> accounts = new ArrayList<BankAccountDbModel>();

        try(Connection connection = DriverManager.getConnection(connectionString)){
            String sqlQuery = "SELECT * FROM cuentas WHERE id_usuario = ?;";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, userId);
            ResultSet response = statement.executeQuery();
            if(response != null){
                while(response.next()){
                    Account account = null;
                    BankAccountDbModel accountDbModel = null;
                    int id =  response.getInt("id"); 
                    String accountNumber =  response.getString("numero_cuenta"); 
                    Float balance = response.getFloat("saldo"); 
                    String type = response.getString("tipo_cuenta");
                    int owner =  response.getInt("id_usuario"); 

                    account = new Account(id, accountNumber, balance, type, owner);
                    if(type.equals(AccountType.SAVINGS)) {
                        accountDbModel = mapperSavingsAccount.DatabaseToDbModelMapper(account);
                    } else {
                        accountDbModel = mapperCheckingAccount.DatabaseToDbModelMapper(account);
                    }
                    accounts.add(accountDbModel);
                }
                return accounts;
            }

        }catch (SQLException e) {
            System.err.println("Error listing users: " + e);
        }
        return null;
    }

    @Override
    public void updateId(Object object, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateId'");
    }
}
