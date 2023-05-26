package org.example;

import entity.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserRepository userRepository = new UserRepositoryImpl();

        User user = new User("testing","test","tester","123","321");
        userRepository.delete(1);
    }
}