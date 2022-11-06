package com.example.facebookcloneapp.controller;

import com.example.facebookcloneapp.dao.PostRepository;
import com.example.facebookcloneapp.dao.UserRepository;
import com.example.facebookcloneapp.dao.impl.PostRepositoryImpl;
import com.example.facebookcloneapp.dao.impl.UserRepositoryImpl;
import com.example.facebookcloneapp.dtos.PostDto;
import com.example.facebookcloneapp.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/edit/" ,"/edit"})
public class EditPostServlet extends HttpServlet {
    private final UserRepository userDao = new UserRepositoryImpl();
    private final PostRepository postDao = new PostRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Post post = postDao.get(Integer.parseInt( request.getParameter("post_id")));
//        Post post = postDao.get( request.getParameter("post_id"));
//
//        User user=(User)request.getSession().getAttribute("user");
//        request.getSession().setAttribute("post",postDTO);
//        if (user.getId()==postDTO.getUserId()){
//            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/edit.jsp"));
//        }else {
//            response.sendRedirect("dashboard");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= (User)request.getSession().getAttribute("loggedUser");
        PostDto postDto1 = (PostDto) request.getSession().getAttribute("post");
        String text_body = request.getParameter("text_body");
        if(user.getUser_id() == postDto1.getUser_id()){
            postDao.updatePost(postDto1);
            response.sendRedirect("dashboard");
        }else
            response.sendRedirect("dashboard");
    }
}
