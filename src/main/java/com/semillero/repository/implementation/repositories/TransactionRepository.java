package com.semillero.repository.implementation.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.semillero.repository.contracts.Irepositories.ITransactionRepository;
import com.semillero.repository.contracts.dbModels.core.TransactionDbModel;
import com.semillero.repository.implementation.dataModel.core.Transaction;
import com.semillero.repository.implementation.mappers.core.TransactionRepositoryMapper;

public class TransactionRepository implements ITransactionRepository{
    private String connectionString;
    private TransactionRepositoryMapper mapper;

    public TransactionRepository() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            connectionString = "jdbc:sqlite:banco.db";
            mapper = new TransactionRepositoryMapper();
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e);
        }
    }
    
    @Override
    public void save(TransactionDbModel object) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            Transaction transaction = mapper.DbModelToDatabaseMapper(object);
            String sqlQuery = "INSERT INTO TRANSACCIONES (fecha, hora, tipo_transaccion, monto, id_cuenta, tipo_cuenta_destino) " 
                + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement  = connection.prepareStatement(sqlQuery);
            statement.setString(1, transaction.getDate());
            statement.setString(2, transaction.getTime());
            statement.setString(3, transaction.getTransactionType());
            statement.setDouble(4,  transaction.getAmount());
            statement.setInt(5,  transaction.getAccountId());
            statement.setString(6, transaction.getDestinationAccountType());


            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Connection error: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }     
    }

    @Override
    public void deleteTransactionsByAccountId(int acountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTransactionsByAccountId'");
    }

    @Override
    public List<?> listTransactionByAccountId(int acountId) {
        List<Transaction> transactions = new ArrayList<Transaction>();

        try(Connection connection = DriverManager.getConnection(connectionString)){
            String sqlQuery = "SELECT * FROM transacciones WHERE id_cuenta = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, acountId);
            ResultSet response = statement.executeQuery();
            
            if(response != null){
                while(response.next()){
                    Transaction transaction = null;
                    int id =  response.getInt("id"); 
                    String date =  response.getString("fecha"); 
                    String time = response.getString("hora"); 
                    String transactionType = response.getString("tipo_transaccion"); 
                    double amount = response.getDouble("monto"); 
                    int accountId =  response.getInt("id_cuenta"); 
                    String destinationAccountType = response.getString("tipo_cuenta_destino"); 
                    transaction = new Transaction(id, date, time, transactionType, amount, accountId, destinationAccountType);
                    transactions.add(transaction);
                }

                List<TransactionDbModel> transactionsDbModel = mapper.DatabaseToDbModelMapper(transactions);
                return transactionsDbModel;
            }

        }catch (SQLException e) {
            System.err.println("Error listing transactions: " + e);
        }
        return null;
    }
    
}
