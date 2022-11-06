package com.example.facebookcloneapp.dao;

import com.example.facebookcloneapp.dtos.PostDto;
import com.example.facebookcloneapp.dtos.UserDto;
import com.example.facebookcloneapp.model.Comment;
import com.example.facebookcloneapp.model.Post;
import com.example.facebookcloneapp.model.User;

import java.util.List;

public interface PostRepository {
    int createPost(PostDto postDto, User user);
    int deletePost(int post_id);
    int updatePost(PostDto postDto);
    Post getPostById (int post_id);
    List<Post> fetchAllPosts();
    List<Comment> getCommentsByPostId(int post_id);
    int postLike(int post_id);
    int checkPostLike(int post_id);
    int unlike(int post_id);
}
