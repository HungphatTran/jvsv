package stuffs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import service.DBConnect;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class NguyenLieuDAO {
    public Object[] getRow(NguyenLieu nl) {
        String maNL = nl.getMaNL();
        String tenNL = nl.getTenNL();
        Date ngayNhap = nl.getNgayNhap();
        double giaNhap = nl.getGiaNhap();
        String maSP = nl.getMaSP();

        Object[] row = new Object[]{maNL, tenNL, ngayNhap, giaNhap, maSP};
        return row;
    }
    public List<NguyenLieu> getAll() {
        List<NguyenLieu> listNL = new ArrayList<>();
        String sql = "SELECT * FROM NguyenLieu";
        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String maNL = rs.getString(1);
                String tenNL = rs.getString(2);
                Date ngayNhap = rs.getDate(3);
                double giaNhap = rs.getDouble(4);
                String maSP = rs.getString(5);

                NguyenLieu nl = new NguyenLieu(maNL, tenNL, ngayNhap, giaNhap, maSP);
                listNL.add(nl);
            }

        } catch (Exception e) {
        }

        return listNL;
    }
    public int addNL(NguyenLieu nl) {
    String sql = "INSERT INTO NguyenLieu (MaNL, TenNL, NgayNhap, GiaNhap, MaSP) VALUES (?, ?, ?, ?, ?)";
    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, nl.getMaNL());
        pstm.setString(2, nl.getTenNL());
        pstm.setDate(3, new java.sql.Date(nl.getNgayNhap().getTime()));
        pstm.setDouble(4, nl.getGiaNhap());
        pstm.setString(5, nl.getMaSP());

        if (pstm.executeUpdate() > 0) {
            return 1;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}


public int editNL(NguyenLieu nl, String maCu) {
    String sql = "UPDATE NguyenLieu SET "
            + "MaNL = ?, "
            + "TenNL = ?, "
            + "NgayNhap = ?, "
            + "GiaNhap = ?, "
            + "MaSP = ? "
            + "WHERE MaNL = ?";
    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, nl.getMaNL());
        pstm.setString(2, nl.getTenNL());
        pstm.setDate(3, new java.sql.Date(nl.getNgayNhap().getTime()));
        pstm.setDouble(4, nl.getGiaNhap());
        pstm.setString(5, nl.getMaSP());
        pstm.setString(6, maCu);

        if (pstm.executeUpdate() > 0) {
            return 1;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}


    public int deleteNL(String maNL) {
        String sql = "DELETE NguyenLieu WHERE MANL = ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, maNL);
            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
        }

        return 0;
    }
}
