package com.example.facebookcloneapp;

import com.example.facebookcloneapp.dao.PostRepository;
import com.example.facebookcloneapp.dao.UserRepository;
import com.example.facebookcloneapp.dao.impl.PostRepositoryImpl;
import com.example.facebookcloneapp.dao.impl.UserRepositoryImpl;
import com.example.facebookcloneapp.dtos.PostDto;
import com.example.facebookcloneapp.dtos.UserDto;
import com.example.facebookcloneapp.model.User;

public class AppMain {
    private static UserRepository userDao = new UserRepositoryImpl();
    private static PostRepository postDao = new PostRepositoryImpl();

    public static void main(String[] args){
        UserDto userDto1 = new UserDto("Maggi March", "mag@gmail.com", "Female", "A goal getter", "Maggi12");
      int user1 =  userDao.createUser(userDto1);
        System.out.println(user1);




//PostDto postDto = new PostDto(1, "Talking about how bright the weather is and how sunny it is",
//        3, 3);
//   User user = new User();
//      int post1 = postDao.createPost(postDto, user);
//        System.out.println(post1);
//      try {
//          Connection connects = DataBaseConnection.INSTANCE.getDatasource().getConnection();
//          UserRepository userDao = new UserDaoImpl();
//          userDao.createUser(user);
//      }catch (Exception e){
//          e.printStackTrace();
      }
    }
