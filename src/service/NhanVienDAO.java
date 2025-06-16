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
import java.sql.Date;
import java.util.*;
import model.NhanVien;
import service.DBConnect;

public class NhanVienDAO {

    public Object[] getRow(NhanVien nv) {
    String id_nv = nv.getId_nv();
    String ten_nv = nv.getTen_nv();
    String dia_chi = nv.getDia_chi();
    String sdt = nv.getSdt();
    String vai_tro = nv.getVai_tro();
    Date ngay_vao_lam = nv.getNgay_vao_lam();

    Object[] row = new Object[]{id_nv, ten_nv, dia_chi, sdt, vai_tro, ngay_vao_lam};
    return row;
}
    
    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getString("id_nv"),
                        rs.getString("ten_nv"),
                        rs.getString("dia_chi"),
                        rs.getString("sdt"),
                        rs.getString("vai_tro"),
                        rs.getDate("ngay_vao_lam")
                );
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int add(NhanVien nv) {
        String sql = "INSERT INTO NhanVien VALUES (?,?,?,?,?,?)";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nv.getId_nv());
            ps.setString(2, nv.getTen_nv());
            ps.setString(3, nv.getDia_chi());
            ps.setString(4, nv.getSdt());
            ps.setString(5, nv.getVai_tro());
            ps.setDate(6, nv.getNgay_vao_lam());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(NhanVien nv, String idCu) {
        String sql = "UPDATE NhanVien SET id_nv=?, ten_nv=?, dia_chi=?, sdt=?, vai_tro=?, ngay_vao_lam=? WHERE id_nv=?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nv.getId_nv());
            ps.setString(2, nv.getTen_nv());
            ps.setString(3, nv.getDia_chi());
            ps.setString(4, nv.getSdt());
            ps.setString(5, nv.getVai_tro());
            ps.setDate(6, nv.getNgay_vao_lam());
            ps.setString(7, idCu);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String id_nv) {
        String sql = "DELETE FROM NhanVien WHERE id_nv=?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id_nv);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

