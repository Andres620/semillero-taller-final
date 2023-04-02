package com.semillero.repository.implementation.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.semillero.repository.contracts.Irepositories.IUserRepository;
import com.semillero.repository.contracts.dbModels.core.UserDbModel;
import com.semillero.repository.implementation.dataModel.core.User;
import com.semillero.repository.implementation.mappers.core.UserRepositoryMapper;

public class UserRepository implements IUserRepository{

    private String connectionString;
    private UserRepositoryMapper mapper;

    public UserRepository() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            connectionString = "jdbc:sqlite:pruebas.db";
            mapper = new UserRepositoryMapper();
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e);
        }
    }
    
    @Override
    public void save(UserDbModel object) {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            mapper = new UserRepositoryMapper();
            User user = mapper.DbModelToDatabaseMapper(object);
            String sqlQuery = "INSERT INTO usuarios (nombre, apellido, cedula) " 
                + "VALUES (?, ?, ?)";
            
            PreparedStatement statement  = connection.prepareStatement(sqlQuery);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getIdentificationCard());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Connection error: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
        
    }

    @Override
    public void delete(String identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Object search(String identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public List<?> list() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public void updateId(Object object, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateId'");
    }
    
}
