package stuffs;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Date;
/**
 *
 * @author ADMIN
 */
public class NguyenLieu {
    private String maNL;
    private String tenNL;
    private Date ngayNhap;
    private double giaNhap;
    private String maSP;

    public NguyenLieu() {
    }

    public NguyenLieu(String maNL, String tenNL, Date ngayNhap, double giaNhap, String maSP) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.ngayNhap = ngayNhap;
        this.giaNhap = giaNhap;
        this.maSP = maSP;
    }

    public String getMaNL() {
        return maNL;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
}
