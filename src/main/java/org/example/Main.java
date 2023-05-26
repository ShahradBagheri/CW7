package org.example;

import entity.User;
import menu.Page;
import service.UserService;
import service.UserServiceImpl;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        new Page().start();
    }
}