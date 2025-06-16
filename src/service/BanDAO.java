package service;

import java.sql.*;
import java.util.ArrayList;
import model.Ban;

public class BanDAO {
    public ArrayList<Ban> getAll() {
        ArrayList<Ban> list = new ArrayList<>();
        String sql = "SELECT * FROM Ban";
        try (Connection conn = DBConnect.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Ban(
                    rs.getString("maBan"),
                    rs.getString("tenBan"),
                    rs.getString("trangThai")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(Ban ban) {
        String sql = "INSERT INTO Ban (maBan, tenBan, trangThai) VALUES (?, ?, ?)";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ban.getMaBan());
            ps.setString(2, ban.getTenBan());
            ps.setString(3, ban.getTrangThai());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean update(Ban ban) {
        String sql = "UPDATE Ban SET tenBan=?, trangThai=? WHERE maBan=?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ban.getTenBan());
            ps.setString(2, ban.getTrangThai());
            ps.setString(3, ban.getMaBan());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean delete(String maBan) {
        String sql = "DELETE FROM Ban WHERE maBan=?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maBan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}