package com.example.facebookcloneapp.controller;

import com.example.facebookcloneapp.dao.PostRepository;
import com.example.facebookcloneapp.dao.UserRepository;
import com.example.facebookcloneapp.dao.impl.PostRepositoryImpl;
import com.example.facebookcloneapp.dao.impl.UserRepositoryImpl;
import com.example.facebookcloneapp.dtos.PostDto;
import com.example.facebookcloneapp.model.Post;
import com.example.facebookcloneapp.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/newPost"})
public class PostServlet extends HttpServlet {
    private final PostRepository pr = new PostRepositoryImpl();
    private final UserRepository userDao = new UserRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= (User)request.getSession().getAttribute("loggedUser");
        String user_id = request.getParameter("user_id");
        String text_body = request.getParameter("text_body");
        String userName = request.getParameter("userName");
        PostDto postDto = PostDto.builder()
                .text_body(text_body)
                .likes(0)
                .user_id(user.getUser_id())
                .userName(user.getUserName())
                .build();
        pr.createPost(postDto,user);
            response.sendRedirect("dashboard");
        }
    }



