package com.example.facebookcloneapp.dao;

import com.example.facebookcloneapp.dtos.UserDto;
import com.example.facebookcloneapp.model.User;

import java.util.List;

public interface UserRepository {
    int createUser(UserDto userDto);

    User checkLogin(User user);

    int deleteUser(UserDto userDto);
     List<User> getAllUsers();

     int updateUserInfo(UserDto userDto);

     User getUserById(int user_id);
}
