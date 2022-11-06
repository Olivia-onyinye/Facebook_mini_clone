package com.example.facebookcloneapp.model;

import lombok.*;


import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class User {
    private int user_id;
    private String userName;
    private String email;
    private String gender;
    private String user_bio;
    private String password;
}