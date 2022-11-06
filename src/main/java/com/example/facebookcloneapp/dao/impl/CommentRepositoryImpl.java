package com.example.facebookcloneapp.dao.impl;

import com.example.facebookcloneapp.Exception.ModelRepositoryException;
import com.example.facebookcloneapp.dao.commentRepository;
import com.example.facebookcloneapp.dtos.CommentDto;
import com.example.facebookcloneapp.dtos.PostDto;
import com.example.facebookcloneapp.dtos.UserDto;
import com.example.facebookcloneapp.model.Comment;
import com.example.facebookcloneapp.model.Post;
import com.example.facebookcloneapp.model.User;
import com.example.facebookcloneapp.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements commentRepository {
     final static String commentCreate =
             "insert into comment (comment_id,text_area, post_id, user_id, likes) values (?,?,?,?,?)";
     final static String commentDelete = "DELETE FROM comment where comment_id = ?";
     final static String commentEdit = "update comment set text_area = ? where comment_id=?";
    final static String allComments = "SELECT * comment FROM where comment_id = ?";

     @Override
     public int saveComment(CommentDto commentDto, Post post, User user) {
          int result = 0;
          try{
               Connection connects = DataBaseConnection.INSTANCE.getDatasource().getConnection();
               PreparedStatement prSt = connects.prepareStatement(commentCreate);
               prSt.setString(1, commentDto.getText_area());
               prSt.setInt(2, post.getPost_id());
               prSt.setInt(3, user.getUser_id());
               prSt.setInt(4,commentDto.getLikes());
               result = prSt.executeUpdate();
          }catch (Exception e){
              e.printStackTrace();
          }
          return result;
     }

     @Override
     public int deleteComment(int comment_id) {
          int status = 0;
          try {
               Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();
               PreparedStatement ps = connection.prepareStatement(commentDelete);
               ps.setInt(1, comment_id);
               status = ps.executeUpdate();

          } catch (Exception e) {
               e.printStackTrace();
          }
          if (status > 0) {
               return status;
          } else {
               throw new ModelRepositoryException("Comment with : " + comment_id + " not found");
          }
     }

     @Override
     public int updateComment(CommentDto commentDto) {
          int update = 0;
          try(Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection()) {
               PreparedStatement prepStat = connection.prepareStatement(commentEdit);
               prepStat.setString(1, commentDto.getText_area());
               prepStat.setInt(2, commentDto.getComment_id());
               update = prepStat.executeUpdate();
          }catch (Exception ex){
               ex.printStackTrace();
          }
          return update;
     }

     @Override
     public Comment getCommentById(int comment_id) {
          Comment comment = new Comment();
          try (Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection()) {
               PreparedStatement prepStat = connection.prepareStatement("select * from comment where comment_id = ?");
               prepStat.setInt(1, comment_id);
               ResultSet rs = prepStat.executeQuery();
               if(rs.next()){
                    comment.setComment_id(rs.getInt("comment_id"));
                   comment.setText_area(rs.getString("text_body"));
                    comment.setPost_id(rs.getInt("post_id"));
                    comment.setUser_id(rs.getInt("user_id"));
                    comment.setLikes(rs.getInt("likes"));
               }
          }catch(Exception ne){
               ne.printStackTrace();
          }
          return comment;
     }

     @Override
     public List<Comment> getAllComment() {

         Comment comment;
         List<Comment> commentList =new ArrayList<>();
         try
             (Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection()) {
                 PreparedStatement prepStat = connection.prepareStatement(allComments);
             ResultSet rs = prepStat.executeQuery();
             while(rs.next()){
                 User user = new User();
                 Post post = new Post();
                 int comment_id = rs.getInt("comment_id");
                 String text_area = rs.getString("text-area");
                 int post_id = rs.getInt("post_id");
                 int user_id = rs.getInt("user_id");
                 int likes = rs.getInt("likes");

                 user.setUser_id(user_id);
                 post.setPost_id(post_id);
                  comment = new Comment(comment_id, text_area, post.getPost_id(), user.getUser_id(), likes);
                 commentList.add(comment);
                 }
         } catch(Exception e){
             e.printStackTrace();
         }
         return commentList;
     }
}

//                     comment=new Comment();
//                     comment.setComment_id(rs.getInt("comment_id"));
//                     comment.setPost_id(rs.getInt("post_id"));
//                     comment.setText_area(rs.getString("text_area"));
//                     comment.setUser_id(rs.getInt("user_id"));
//                     comment.setLikes(rs.getInt("likes"));
//                     commentList.add(comment);