package com.example.facebookcloneapp.dtos;


import lombok.*;

@Data
@Builder


public class CommentDto {
    private int comment_id;
    private final String text_area;
    private final int post_id;
    private final int user_id;
    private final int likes;

}