package service;

import java.sql.*;
import java.util.ArrayList;
import model.KhachHang;
import service.DBConnect;

public class KhachHangDAO {

    public ArrayList<KhachHang> getAll() {
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String ma = rs.getString("ma_kh");
                String ten = rs.getString("ten_kh");
                String sdt = rs.getString("sdt");
                int diem = rs.getInt("diem_tich_luy");

                KhachHang kh = new KhachHang(ma, ten, sdt, diem);
                list.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(KhachHang kh) {
        String sql = "INSERT INTO KhachHang (ma_kh, ten_kh, sdt, diem_tich_luy) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTenKH());
            ps.setString(3, kh.getSdt());
            ps.setInt(4, kh.getDiemTichLuy());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(KhachHang kh) {
        String sql = "UPDATE KhachHang SET ten_kh = ?, sdt = ?, diem_tich_luy = ? WHERE ma_kh = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kh.getTenKH());
            ps.setString(2, kh.getSdt());
            ps.setInt(3, kh.getDiemTichLuy());
            ps.setString(4, kh.getMaKH());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String maKH) {
        String sql = "DELETE FROM KhachHang WHERE ma_kh = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maKH);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
