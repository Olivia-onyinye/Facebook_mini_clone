package com.example.facebookcloneapp.dtos;

import lombok.*;

import java.sql.Date;

@Data
@Builder

public class PostDto {
    private int post_id;
    private final String text_body;
    private final int likes;
    private final int user_id;
    private final String userName;



}


