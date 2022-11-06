package com.example.facebookcloneapp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Likes {
    private int like_id;
    private int user_id;
    private int post_id;
}
