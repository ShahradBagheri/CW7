package service;

import entity.User;

import java.sql.SQLException;

public interface UserService {
    void save(User user) throws SQLException;
    void update(int id,User user) throws SQLException;
    void delete(int id) throws SQLException;
    void saveAll(User[] user) throws SQLException;
    boolean loginValidation(String username, String password) throws SQLException;
    boolean usernameValidation(String username) throws SQLException;
    boolean natCodeValidation(String natCode) throws SQLException;
}
