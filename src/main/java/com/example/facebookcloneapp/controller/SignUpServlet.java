package com.example.facebookcloneapp.controller;

import com.example.facebookcloneapp.dao.UserRepository;
import com.example.facebookcloneapp.dao.impl.UserRepositoryImpl;
import com.example.facebookcloneapp.dtos.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignUpServlet", value = "/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private final UserRepository userDao = new UserRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String user_bio = request.getParameter("user_bio");
        String password = request.getParameter("password");

        UserDto userDto1 = new UserDto(userName, email, gender, user_bio, password);

        int status = userDao.createUser(userDto1);
        if(status > 0) {
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("loginPage.jsp").include(request, response);
        }else {
            out.println("Sorry! unable to register record at the moment");
        }
        out.close();
    }
}
