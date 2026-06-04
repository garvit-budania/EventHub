package dao;

import model.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean registerUser(User user) {

        String query =
                "INSERT INTO users " +
                "(username, password, role, wallet_balance) " +
                "VALUES (?, ?, ?, ?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());
            pstmt.setDouble(4, user.getWalletBalance());

            int rowsAffected =
                    pstmt.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
    public User loginUser(String username, String password) {

        String query =
                "SELECT * FROM users " +
                "WHERE username = ? " +
                "AND password = ?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs =
                    pstmt.executeQuery();

            if(rs.next()) {

                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getDouble("wallet_balance")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}