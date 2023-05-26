package service;

import entity.User;

import java.sql.SQLException;

public interface UserService {
    void save(User user) throws SQLException;
}
