package com.example.facebookcloneapp.controller;

import com.example.facebookcloneapp.dao.impl.PostRepositoryImpl;
import com.example.facebookcloneapp.dao.impl.UserRepositoryImpl;
import com.example.facebookcloneapp.dao.UserRepository;
import com.example.facebookcloneapp.dao.PostRepository;
import com.example.facebookcloneapp.model.Post;
import com.example.facebookcloneapp.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private final UserRepository userDao = new UserRepositoryImpl();
    private final PostRepository postDao = new PostRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("Email: " + email);
        System.out.println("password: " + password);
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        try {
            User foundUser = userDao.checkLogin(user);
            List<Post> posts = postDao.fetchAllPosts();
            if (foundUser != null) {
                request.getSession().setAttribute("loggedUser", foundUser);
                request.getSession().setAttribute("posts", posts);
                request.getSession().setAttribute("userName", user.getUserName());
                System.out.println(foundUser.getUserName());
                response.sendRedirect("dashboard");

            } else {
                request.setAttribute("errorMessage", "Email/Password not correct");
                request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
            }
        } catch (Exception ne) {
            ne.printStackTrace();
        }
    }
}