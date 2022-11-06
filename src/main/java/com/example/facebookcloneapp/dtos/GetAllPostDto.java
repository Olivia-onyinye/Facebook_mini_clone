package com.example.facebookcloneapp.dtos;

import com.example.facebookcloneapp.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GetAllPostDto {
    private int id;
    private  int likes;
    private String text_area;
    private String username;
    private int user_id;
    private List<Comment> comments;
}
