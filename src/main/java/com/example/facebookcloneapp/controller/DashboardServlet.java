package com.example.facebookcloneapp.controller;

import com.example.facebookcloneapp.dao.PostRepository;
import com.example.facebookcloneapp.dao.UserRepository;
import com.example.facebookcloneapp.dao.impl.PostRepositoryImpl;
import com.example.facebookcloneapp.dao.impl.UserRepositoryImpl;
import com.example.facebookcloneapp.model.Post;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/dashboard", "/home"})
public class DashboardServlet extends HttpServlet {

    private final UserRepository userDao = new UserRepositoryImpl();
    private final PostRepository postDao = new PostRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(postDao.fetchAllPosts());
        request.getSession().setAttribute("posts",postDao.fetchAllPosts());
        request.getRequestDispatcher("/dashboard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
