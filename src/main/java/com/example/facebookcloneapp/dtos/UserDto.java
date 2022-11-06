package com.example.facebookcloneapp.dtos;

import lombok.*;

import java.time.LocalDate;

@Data


public class UserDto {
    private int user_id;
    private final String userName;
    private final String email;
    private final String gender;
    private final String user_bio;
    private final String password;
}