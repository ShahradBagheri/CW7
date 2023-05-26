package service;

import entity.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.sql.SQLException;

public class UserServiceImpl implements UserService{

    @Override
    public void save(User user) throws SQLException {
        UserRepository userRepository = new UserRepositoryImpl();
        if (userRepository.natCodeValidation(user.getNastionalCode()) && userRepository.usernameValidation(user.getUsername()))
            userRepository.save(user);
    }
}
