package com.example.facebookcloneapp.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public enum DataBaseConnection {
    INSTANCE;

    public DataSource getDatasource(){
        MysqlDataSource dataSource1 = new MysqlDataSource();
        dataSource1.setUrl("jdbc:mysql://localhost/facebook_mini?serverTimezone=UTC");
        dataSource1.setUser("root");
        dataSource1.setPassword("Kamsiyochukwu1*");
        return dataSource1;

    }
    public boolean isConnectionValid(){
        try(Connection connection = getDatasource().getConnection()){
            return connection.isValid(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
