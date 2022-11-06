package com.example.facebookcloneapp.controller;

import com.example.facebookcloneapp.dao.UserRepository;
import com.example.facebookcloneapp.dao.impl.UserRepositoryImpl;
import com.example.facebookcloneapp.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

class LoginServletTest {
    HttpServletRequest request;
    HttpServletResponse response;
    UserRepository userDao;

    @BeforeEach
    void setUp() {
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        userDao = new UserRepositoryImpl();
    }

    @Test
    void doPost() throws SQLException, ClassNotFoundException {
        Mockito.when(request.getParameter("email")).thenReturn("joseph@gmail.com");
        Mockito.when(request.getParameter("password")).thenReturn("Joseph12");
        User user = new User();
        user.setEmail("joseph@gmail.com");
        user.setPassword("Joseph12");
        User user1 = this.userDao.checkLogin(user);

        Assertions.assertEquals(user1.getEmail(), user.getEmail());
        Assertions.assertEquals(user1.getPassword(), user.getPassword());
    }
}