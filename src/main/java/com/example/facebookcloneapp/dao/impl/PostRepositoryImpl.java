package com.example.facebookcloneapp.dao.impl;

import com.example.facebookcloneapp.dao.PostRepository;
import com.example.facebookcloneapp.dtos.PostDto;
import com.example.facebookcloneapp.model.Comment;
import com.example.facebookcloneapp.model.Post;
import com.example.facebookcloneapp.model.User;
import com.example.facebookcloneapp.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    final static String postCreate =
            "insert into post (text_body, likes, user_id, userName) values (?,?,?,?)";
    final static String postEdit = "update post set text_body=? where post_id=?";
    final static String postDelete = "DELETE FROM post where post_id = ?";
    final static String postList = "SELECT *  FROM post order by post_id desc";
    final static String likePost = "UPDATE post SET likes=? WHERE post_id= ?";
    final static String checkLike = "SELECT likes FROM post WHERE user_id= ?";

    @Override
    public int createPost(PostDto postDto, User user) {
        int status = 0;
        try {
            Connection connects = DataBaseConnection.INSTANCE.getDatasource().getConnection();
            PreparedStatement statement = connects.prepareStatement(postCreate);
            statement.setString(1, postDto.getText_body());
            statement.setInt(2, postDto.getLikes());
            statement.setInt(3, user.getUser_id());
            statement.setString(4, user.getUserName());
            status = statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    @Override
    public int deletePost(int post_id) {
        int status = 0;
        try {
            Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();
            PreparedStatement ps2 = connection.prepareStatement(postDelete);
            ps2.setInt(1, post_id);
            status = ps2.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int updatePost(PostDto postDto) {
        int update = 0;
        try (Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection()) {
            PreparedStatement prepStat = connection.prepareStatement(postEdit);
            prepStat.setString(1, postDto.getText_body());
            prepStat.setInt(2, postDto.getPost_id());
            update = prepStat.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return update;
    }

    @Override
    public Post getPostById(int post_id) {
        Post post = new Post();

        try {
            Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from post where post_Id = ?");
            ps.setInt(1, post_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                post.setPost_id(rs.getInt("post_id"));
                post.setText_body(rs.getString("text_body"));
                post.setLikes(rs.getInt("likes"));
                post.setUser_id(rs.getInt("user_id"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return post;
    }

    @Override
    public List<Post> fetchAllPosts() {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection()) {
            PreparedStatement prepStat = connection.prepareStatement(postList);
            ResultSet resultSet = prepStat.executeQuery();
            while (resultSet.next()) {

                User user = new User();
                int post_id = resultSet.getInt("post_id");
                String text_body = resultSet.getString("text_body");
                int likes = resultSet.getInt("likes");
                int user_id = resultSet.getInt("user_id");
                String userName = resultSet.getString("userName");
                user.setUser_id(user_id);
                user.setUserName(userName);
                Post post = new Post(post_id, text_body, likes, user.getUser_id(), user.getUserName());
                posts.add(post);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return posts;
    }

    public List<Comment> getCommentsByPostId(int post_id) {
        List<Comment> comments = new ArrayList<>();
        try {
            Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from comment where post_Id = ?");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                {
                    Comment comment = new Comment();
                    comment.setComment_id(rs.getInt("comment_id"));
                    comment.setText_area(rs.getString("text_area"));
                    comment.setPost_id(rs.getInt("post_id"));
                    comment.setUser_id(rs.getInt("user_id"));
                    comment.setLikes(rs.getInt("likes"));
                    comments.add(comment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public int postLike(int post_id) {
        try {
            Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();
            PreparedStatement ps = connection.prepareStatement(likePost);
            int likes = getPostById(post_id).getLikes() + 1;
            ps.setInt(1, likes);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int checkPostLike(int post_id) {
        int likes = 0;
        try {
            Connection connection = DataBaseConnection.INSTANCE.getDatasource().getConnection();
            PreparedStatement ps = connection.prepareStatement(checkLike);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                likes = rs.getInt("likes");
            }
        } catch (Exception xe) {
            xe.printStackTrace();
        }
        return likes;
    }

    @Override
    public int unlike(int post_id) {
        return 0;
    }
}

