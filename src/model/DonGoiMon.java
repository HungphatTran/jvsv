/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
import java.sql.Date;

public class DonGoiMon {
    private String maDon;
    private String tenDon;
    private Date ngayNhap;
    private int tongTien;
    private String trangThai;
    private String ghiChu;

    public DonGoiMon() {}

    public DonGoiMon(String maDon, String tenDon, Date ngayNhap, int tongTien, String trangThai, String ghiChu) {
        this.maDon = maDon;
        this.tenDon = tenDon;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public String getMaDon() { return maDon; }
    public void setMaDon(String maDon) { this.maDon = maDon; }

    public String getTenDon() { return tenDon; }
    public void setTenDon(String tenDon) { this.tenDon = tenDon; }

    public Date getNgayNhap() { return ngayNhap; }
    public void setNgayNhap(Date ngayNhap) { this.ngayNhap = ngayNhap; }

    public int getTongTien() { return tongTien; }
    public void setTongTien(int tongTien) { this.tongTien = tongTien; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
}


