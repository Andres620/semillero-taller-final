package com.semillero.repository.implementation.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            connectionString = "jdbc:sqlite:banco.db";
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
            String sqlQuery = "INSERT INTO USUARIOS (nombre, apellido, cedula) " 
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
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            String sqlQuery = "DELETE FROM usuarios WHERE cedula = ?;";
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
            String sqlQuery = "SELECT * FROM usuarios WHERE cedula = ?";

            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, identifier);
            ResultSet response = statement.executeQuery();
            if (response != null && response.next()) {
                User user = null;
                String name =  response.getString("nombre"); 
                String surname = response.getString("apellido"); 
                String identificationCard = response.getString("cedula"); 
                user = new User(name, surname, identificationCard);
                UserDbModel userDbModel = mapper.DatabaseToDbModelMapper(user);
                return userDbModel;
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }

    @Override
    public List<?> list() {
        List<User> users = new ArrayList<User>();

        try(Connection connection = DriverManager.getConnection(connectionString)){
            String sqlQuery = "SELECT * FROM usuarios";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet response = statement.executeQuery();
            
            if(response != null){
                while(response.next()){
                    User user = null;
                    String name =  response.getString("nombre"); 
                    String surname = response.getString("apellido"); 
                    String identificationCard = response.getString("cedula"); 
                    user = new User(name, surname, identificationCard);
                    users.add(user);
                }
                List<UserDbModel> usersDbModel = mapper.DatabaseToDbModelMapper(users);
                return usersDbModel;
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
