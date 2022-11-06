package com.example.facebookcloneapp.controller;

import com.example.facebookcloneapp.dao.PostRepository;
import com.example.facebookcloneapp.dao.commentRepository;
import com.example.facebookcloneapp.dao.impl.CommentRepositoryImpl;
import com.example.facebookcloneapp.dao.impl.PostRepositoryImpl;
import com.example.facebookcloneapp.dtos.CommentDto;
import com.example.facebookcloneapp.model.Post;
import com.example.facebookcloneapp.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CommentServlet", value = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    private final commentRepository cor = new CommentRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)request.getSession().getAttribute("loggedUser");
        Post post = (Post) request.getSession().getAttribute("post");
        String text_area = request.getParameter("text_area");
        String post_id = request.getParameter("post_id");
        String user_id = request.getParameter("user_id");
        CommentDto commentDto = CommentDto.builder()
                        .text_area(text_area)
                        .post_id(post.getPost_id())
                                .user_id(user.getUser_id())
                                        .likes(1)
                                                .build();
        cor.saveComment(commentDto, post, user);
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()
                + "/comments/comment/?post_id="+post.getPost_id()));

    }
}

//    String email = request.getParameter("email");
//    String password = request.getParameter("password");
//        System.out.println("Email: " + email);
//                System.out.println("password: " + password);
//                User user = new User();
//                user.setEmail(email);
//                user.setPassword(password);
//                try {
//                User foundUser = userDao.checkLogin(user);
//                List<Post> posts = postDao.fetchAllPosts();
//        if (foundUser != null) {
//        request.getSession().setAttribute("loggedUser", foundUser);
//        request.getSession().setAttribute("posts", posts);
//        request.getSession().setAttribute("userName", user.getUserName());
//        System.out.println(foundUser.getUserName());
//        response.sendRedirect("dashboard");
//
//        } else {
//        request.setAttribute("errorMessage", "Email/Password not correct");
//        request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
//        }
//        } catch (Exception ne) {
//        ne.printStackTrace();
//        }