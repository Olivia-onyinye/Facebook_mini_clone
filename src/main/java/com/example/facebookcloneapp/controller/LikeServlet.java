package com.example.facebookcloneapp.controller;

import com.example.facebookcloneapp.dao.PostRepository;
import com.example.facebookcloneapp.dao.impl.PostRepositoryImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet (urlPatterns = {"/likes"})
//(name = "LikeServlet", value = "/LikeServlet")
public class LikeServlet extends HttpServlet {
    private final PostRepository pr = new PostRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int post_id = Integer.parseInt(request.getParameter("post_id"));
        pr.postLike(post_id);
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/dashboard"));
    }
}
