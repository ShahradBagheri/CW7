package repository;

import entity.User;
import util.ApplicationContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void save(User user) {
        try {
            String query = "insert into public.user_table (firstname,lastname,username,password,national_code) values (?,?,?,?,?)";
            PreparedStatement statement = ApplicationContext.getConnection().prepareStatement(query);
            statement.setString(1,user.getFirstname());
            statement.setString(2, user.getLastname());
            statement.setString(3,user.getUsername());
            statement.setString(4,user.getPassword());
            statement.setString(5,user.getNastionalCode());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User load(int id) throws SQLException {
        String query = "SELECT * FROM user_table WHERE id = ?";
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            String firstname = resultSet.getString(1);
            String lastname = resultSet.getString(2);
            String username = resultSet.getString(3);
            String password = resultSet.getString(4);
            String nastionalCode = resultSet.getString(5);

            return new User(firstname,lastname,username,password,nastionalCode);
        }
        return null;
    }

    @Override
    public void update(int id,User user) throws SQLException {
        String query = "UPDATE user_table SET firstname = ?, lastname = ?, username = ? , password = ?, national_code = ? WHERE id = ?";
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);


        preparedStatement.setString(1,user.getFirstname());
        preparedStatement.setString(2, user.getLastname());
        preparedStatement.setString(3,user.getUsername());
        preparedStatement.setString(4,user.getPassword());
        preparedStatement.setString(5,user.getNastionalCode());
        preparedStatement.setInt(6,id);

        preparedStatement.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "delete FROM user_table WHERE id = ?";
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);

        preparedStatement.executeUpdate();
    }

    @Override
    public User[] loadAll() throws SQLException {
        int size = 0;

        String query2 = "SELECT * FROM user_table";
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query2,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.last();
        size = resultSet.getRow();
        resultSet.first();

        User[] users = new User[size];

        for (int i = 0; i < users.length; i++) {
            String firstname = resultSet.getString(1);
            String lastname = resultSet.getString(2);
            String username = resultSet.getString(3);
            String password = resultSet.getString(4);
            String nastionalCode = resultSet.getString(5);

            users[i] = new User(firstname,lastname,username,password,nastionalCode);
            resultSet.next();
        }
        return users;

    }

    @Override
    public void saveAll(User[] users) throws SQLException {
        for (User user: users) {
            String query = "insert into public.user_table (firstname,lastname,username,password,national_code) values (?,?,?,?,?)";
            PreparedStatement statement = ApplicationContext.getConnection().prepareStatement(query);
            statement.setString(1,user.getFirstname());
            statement.setString(2, user.getLastname());
            statement.setString(3,user.getUsername());
            statement.setString(4,user.getPassword());
            statement.setString(5,user.getNastionalCode());

            statement.executeUpdate();
        }
    }

    @Override
    public boolean natCodeValidation(String natCode) throws SQLException {
        boolean flag = true;

        String query = "SELECT national_code FROM user_table";
        Statement statement = ApplicationContext.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            if (resultSet.getString(1).equals(natCode)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean usernameValidation(String username) throws SQLException {
        boolean flag = true;

        String query = "SELECT username FROM user_table";
        Statement statement = ApplicationContext.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            if (resultSet.getString(1).equals(username)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean idValidation(int id) throws SQLException {
        boolean flag = true;

        String query = "SELECT id FROM user_table";
        Statement statement = ApplicationContext.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            if (resultSet.getInt(1) == id) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean loginValidation(String username, String password) throws SQLException {
        String query = "SELECT username,password FROM user_table WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = ApplicationContext.getConnection().prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.last();
        int size = resultSet.getRow();

        return size == 1;
    }
}