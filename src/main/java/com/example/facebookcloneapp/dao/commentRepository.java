package com.example.facebookcloneapp.dao;

import com.example.facebookcloneapp.dtos.CommentDto;
import com.example.facebookcloneapp.dtos.PostDto;
import com.example.facebookcloneapp.model.Comment;
import com.example.facebookcloneapp.model.Post;
import com.example.facebookcloneapp.model.User;

import java.util.List;

public interface commentRepository {
    int saveComment(CommentDto commentDto, Post post, User user);
    int deleteComment(int comment_id);
    int updateComment(CommentDto commentDto);
    Comment getCommentById (int comment_id);
    List<Comment> getAllComment();
}
