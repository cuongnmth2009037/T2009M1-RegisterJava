package com.example.t2009m1demo.model;

import com.example.t2009m1demo.controllers.RegisterServlet;
import com.example.t2009m1demo.entity.Account;
import com.example.t2009m1demo.until.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlAccountModel implements AccountModel {
    private static final String INSERT_ACCOUNT = "INSERT INTO users (username, password, fullname, email, phone, birthday, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_ACCOUNT = "UPDATE users SET username = ?, password = ?, fullname = ?, email = ?, phone = ?, birthday = ?, status = ? WHERE id = ?";
    private static final String DELETE_ACCOUNT = "UPDATE users SET status = ? WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String FIND_BY_ALL = "SELECT * FROM users";


    @Override
    public boolean save(Account account) {
        try {
                Connection connection = ConnectionHelper.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
                preparedStatement.setString(1,account.getUsername());
                preparedStatement.setString(2,account.getPassword());
                preparedStatement.setString(3,account.getFullname());
                preparedStatement.setString(4,account.getEmail());
                preparedStatement.setString(5,account.getPhone());
                preparedStatement.setString(6,account.getBirthday());
                preparedStatement.setInt(7,account.getStatus());
                preparedStatement.executeUpdate();
                return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, Account updateAccount) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT);
            preparedStatement.setString(1,updateAccount.getUsername());
            preparedStatement.setString(2,updateAccount.getPassword());
            preparedStatement.setString(3,updateAccount.getFullname());
            preparedStatement.setString(4,updateAccount.getEmail());
            preparedStatement.setString(5,updateAccount.getPhone());
            preparedStatement.setString(6,updateAccount.getBirthday());
            preparedStatement.setInt(7,updateAccount.getStatus());
            preparedStatement.setInt(8, id);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionHelper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT);
            preparedStatement.setInt(1,-1);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullname = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String birthday = resultSet.getString("birthday");
                int status = resultSet.getInt("status");
                Account account = new Account(id, username, password, fullname, email, phone, birthday, status);
                return account;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullname = resultSet.getString("fullname");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String birthday = resultSet.getString("birthday");
                int status = resultSet.getInt("status");
                Account account = new Account(id, username, password, fullname, email, phone, birthday, status);
                accounts.add(account);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return accounts;
    }
}
