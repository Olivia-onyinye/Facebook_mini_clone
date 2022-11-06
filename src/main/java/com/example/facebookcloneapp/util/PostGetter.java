package com.example.facebookcloneapp.util;

import com.example.facebookcloneapp.controller.LikeServlet;
import com.example.facebookcloneapp.dao.PostRepository;
import com.example.facebookcloneapp.dao.impl.PostRepositoryImpl;
import com.example.facebookcloneapp.dtos.GetAllPostDto;
import com.example.facebookcloneapp.model.Comment;
import com.example.facebookcloneapp.model.Post;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PostGetter {
//    public static List<GetAllPostDto> postFetch(List<Post> posts){
//        Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();
//        PostRepository postRepo = new PostRepositoryImpl();
//        List<GetAllPostDto> viewPosts = new ArrayList<>();
//        for (Post post1:posts
//             ) {
//            List<Comment> allComments = postRepo.getCommentsByPostId(post1.getPost_id());
//            GetAllPostDto getAllPostDto = GetAllPostDto.builder()
//                    .id(post1.getPost_id())
//                    .user_id(post1.getUser_id())
//                    .username(post1.getUserName)
//                    .text_area(post1.getLikes())
//                    .comments(allComments)
//                    .build();
        }
//
//    }
//}
