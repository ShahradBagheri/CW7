package service;

import entity.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public void save(User user) throws SQLException {
        if (userRepository.natCodeValidation(user.getNastionalCode()) && userRepository.usernameValidation(user.getUsername()))
            userRepository.save(user);
    }

    @Override
    public void update(int id, User user) throws SQLException {
        if (userRepository.natCodeValidation(user.getNastionalCode()) && userRepository.usernameValidation(user.getUsername()))
            userRepository.update(id,user);
    }

    @Override
    public void delete(int id) throws SQLException {
        if (!userRepository.idValidation(id))
            userRepository.delete(id);
    }

    @Override
    public void saveAll(User[] users) throws SQLException {
        for (User user : users) {
            save(user);
        }
    }

    @Override
    public boolean loginValidation(String username, String password) throws SQLException {
        return userRepository.loginValidation(username,password);
    }

    @Override
    public boolean usernameValidation(String username) throws SQLException {
        return !userRepository.usernameValidation(username);
    }

    @Override
    public boolean natCodeValidation(String natCode) throws SQLException {
        return !userRepository.natCodeValidation(natCode);
    }
}
