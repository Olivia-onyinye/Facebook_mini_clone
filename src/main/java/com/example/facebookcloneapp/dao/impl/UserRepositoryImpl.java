package com.example.facebookcloneapp.dao.impl;

import com.example.facebookcloneapp.dao.UserRepository;
import com.example.facebookcloneapp.dtos.UserDto;
import com.example.facebookcloneapp.model.User;
import com.example.facebookcloneapp.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements UserRepository {
    final static String userInsert =
            "insert into User (userName, email, gender, user_bio, password) " + "values (?,?,?,?,?)";
    final static String emailPassword =
            "select * from User where email = ? and password = ?";
    final static String userDelete = "DELETE FROM User where user_id = ?";
    final static String selectId = "SELECT * FROM User where user_id = ?";
    final static String userUpdate = "UPDATE User SET userName = ?, email = ?, gender = ?, user_bio = ?, password = ? where id = ?";

    @Override
    public int createUser(UserDto userDto) {
        int status = 0;
        try {
            Connection connects = DataBaseConnection.INSTANCE.getDatasource().getConnection();
            PreparedStatement statement = connects.prepareStatement(userInsert);
            statement.setString(1, userDto.getUserName());
            statement.setString(2, userDto.getEmail());
            statement.setString(3, userDto.getGender());
            statement.setString(4, userDto.getUser_bio());
            statement.setString(5, userDto.getPassword());
            status = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public User checkLogin(User user) {
        User foundUser = new User();
        try {
            Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();
            PreparedStatement statement = connection.prepareStatement(emailPassword);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            ResultSet reSet = statement.executeQuery();
            while (reSet.next()) {
                foundUser.setUser_id(reSet.getInt("user_id"));
                foundUser.setUserName(reSet.getString("userName"));
                foundUser.setEmail(reSet.getString("email"));
                foundUser.setGender(reSet.getString("gender"));
                foundUser.setUser_bio(reSet.getString("user_bio"));
                foundUser.setPassword(reSet.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return foundUser;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from User");
            ResultSet rstSet = ps.executeQuery();
            while ((rstSet.next())) {
                int user_id = rstSet.getInt("user_id");
                String userName = rstSet.getString("userName");
                String email = rstSet.getString("email");
                String gender = rstSet.getString("gender");
                String user_bio = rstSet.getString("user_bio");
                String password = rstSet.getString("password");
                list.add(new User(user_id, userName, email, gender, user_bio, password));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public int updateUserInfo(UserDto userDto) {
        int answer = 0;
        try {
            Connection connect1 = DataBaseConnection.INSTANCE.getDatasource().getConnection();
            PreparedStatement ps = connect1.prepareStatement(userUpdate);
            ps.setString(1, userDto.getUserName());
            ps.setString(2, userDto.getEmail());
            ps.setString(3, userDto.getGender());
            ps.setString(4, userDto.getUser_bio());
            ps.setString(5, userDto.getPassword());
            answer = ps.executeUpdate();
            connect1.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return answer;
    }

    @Override
    public int deleteUser(UserDto userDto) {
        int resultSet = 0;
        try (Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(userDelete);
            statement.setInt(1, userDto.getUser_id());
            resultSet = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    @Override
    public User getUserById(int user_id) {
        User user = new User();
            try (Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection()) {
                PreparedStatement preSt = connection.prepareStatement(selectId);
                preSt.setInt(1, user_id);
                ResultSet rs = preSt.executeQuery();
                if (rs.next()) {
                    user.setUser_id(rs.getInt("user_id"));
                    user.setUserName(rs.getString("userName"));
                    user.setEmail(rs.getString("email"));
                    user.setGender(rs.getString("gender"));
                    user.setUser_bio(rs.getString("user_bio"));
                    user.setPassword(rs.getString("password"));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return user;
    }
}