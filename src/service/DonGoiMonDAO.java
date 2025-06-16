/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author ADMIN
 */
import java.sql.*;
import java.util.*;
import model.DonGoiMon;
import service.DBConnect;
import static service.DBConnect.getConnection;
import java.sql.Date;

public class DonGoiMonDAO {
    public Object[] getRow(DonGoiMon dgm) {
        String maDon = dgm.getMaDon();
        String tenDon = dgm.getTenDon();
        Date ngayNhap = dgm.getNgayNhap();
        int tongTien = dgm.getTongTien();
        String trangThai = dgm.getTrangThai();
        String ghiChu = dgm.getGhiChu();

        Object[] row = new Object[]{maDon, tenDon, ngayNhap, tongTien, trangThai, ghiChu};
        return row;
    }
    
    public List<DonGoiMon> getAll() {
        List<DonGoiMon> list = new ArrayList<>();
        String sql = "SELECT * FROM DonGoiMon";
        try (Connection con = DBConnect.getConnection(); 
             Statement st = con.createStatement(); 
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                DonGoiMon d = new DonGoiMon(
                    rs.getString("MaDon"),
                    rs.getString("TenDon"),
                    rs.getDate("NgayNhap"),
                    rs.getInt("TongTien"),
                    rs.getString("TrangThai"),
                    rs.getString("GhiChu")
                );
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int add(DonGoiMon d) {
        String sql = "INSERT INTO DonGoiMon VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnect.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getMaDon());
            ps.setString(2, d.getTenDon());
            ps.setDate(3, d.getNgayNhap());
            ps.setInt(4, d.getTongTien());
            ps.setString(5, d.getTrangThai());
            ps.setString(6, d.getGhiChu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(DonGoiMon d, String maCu) {
        String sql = "UPDATE DonGoiMon SET MaDon=?, TenDon=?, NgayNhap=?, TongTien=?, TrangThai=?, GhiChu=? WHERE MaDon=?";
        try (Connection con = DBConnect.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getMaDon());
            ps.setString(2, d.getTenDon());
            ps.setDate(3, d.getNgayNhap());
            ps.setInt(4, d.getTongTien());
            ps.setString(5, d.getTrangThai());
            ps.setString(6, d.getGhiChu());
            ps.setString(7, maCu);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(String maDon) {
        String sql = "DELETE FROM DonGoiMon WHERE MaDon=?";
        try (Connection con = DBConnect.getConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maDon);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
