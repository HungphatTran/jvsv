package service;

import java.sql.*;
import model.User;

public class UserDAO {
    public boolean insert(User user) {
        String sql = "INSERT INTO Users (username, password, role) VALUES (?, ?, ?)";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole()); // Thêm role
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    // Trả về User nếu đăng nhập thành công, null nếu thất bại
    public User checkLogin(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username=? AND password=?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                return new User(username, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public User findByUsername(String username) {
    String sql = "SELECT * FROM users WHERE username = ?";
    try (
        java.sql.Connection conn = DBConnect.getConnection();
        java.sql.PreparedStatement ps = conn.prepareStatement(sql)
    ) {
        ps.setString(1, username);
        try (java.sql.ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String user = rs.getString("username");
                String pass = rs.getString("password");
                String role = rs.getString("role");
                return new User(user, pass, role);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
}