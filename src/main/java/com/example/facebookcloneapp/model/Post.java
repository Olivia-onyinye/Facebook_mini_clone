package com.example.facebookcloneapp.model;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor


public class Post {
    private int post_id;
    private String text_body;
    private int likes;
    private int user_id;
    private String userName;



}


