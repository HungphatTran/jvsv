package service;

import model.DoanhThu;
import java.sql.*;
import java.util.ArrayList;

public class DoanhThuDAO {
    public ArrayList<DoanhThu> getAll() {
        ArrayList<DoanhThu> list = new ArrayList<>();
        String sql = "SELECT h.ma_hd, h.thoi_diem_mua, " +
                     "SUM(ct.so_luong * ct.gia_qua_khu) AS tong_tien " +
                     "FROM HoaDon h " +
                     "JOIN CHITIETHOADON ct ON h.ma_hd = ct.ma_hd " +
                     "GROUP BY h.ma_hd, h.thoi_diem_mua";
        try (Connection conn = DBConnect.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new DoanhThu(
                    rs.getString("ma_hd"),
                    rs.getDate("thoi_diem_mua"),
                    rs.getDouble("tong_tien")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}