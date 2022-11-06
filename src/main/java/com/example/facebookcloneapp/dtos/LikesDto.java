package com.example.facebookcloneapp.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class LikesDto {
    private int like_id;
    private int user_id;
    private int post_id;
}
