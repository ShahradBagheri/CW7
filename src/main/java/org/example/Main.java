package org.example;

import entity.User;
import service.UserService;
import service.UserServiceImpl;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();

        User user = new User("testing","test","tester","123","3217");
        userService.save(user);
    }
}