package com.example.facebookcloneapp.model;


import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor


public class Comment {
    private int comment_id;
    private String text_area;
    private int post_id;
    private int user_id;
    private int likes;

}