package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.DBConnection;
import utils.PasswordUtils;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "123456789");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public User validateUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        User user = null;
        
        String hashPassword = PasswordUtils.hashPassword(password);

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, hashPassword);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("role");
                user = new User(username, role);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error validating user", ex);
        }

        return user;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
