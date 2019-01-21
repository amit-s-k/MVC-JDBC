package com.stackroute.dao;

import com.stackroute.model.User;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
@Order(value = 1)
public class UserDao {
    private static final String PASSWORD = "admin";
    private static final String USERNAME = "admin";
    private static final String URL = "jdbc:mysql://localhost:3306/userprofile";

    public void persist(User user) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection(URL,USERNAME, PASSWORD);
            Statement statement=connection.createStatement();
            statement.executeUpdate("insert into user_details(username,password) values('"+user.getUsername()+"','"+user.getPassword()+"');");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
