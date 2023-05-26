package repository;

import entity.User;

import java.sql.SQLException;

public interface UserRepository {
    void save(User user);
    User load(int id) throws SQLException;
    void update(int id,User user) throws SQLException;
    void delete(int id)throws SQLException;
    User[] loadAll() throws SQLException;
    void saveAll(User[] users) throws SQLException;
    boolean natCodeValidation(String natCode) throws SQLException;
    public boolean usernameValidation(String username) throws SQLException;
}
