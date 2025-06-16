package model;

import java.util.Date;

public class DoanhThu {
    private String maHD;
    private Date ngay;
    private double tongTien;

    public DoanhThu() {}

    public DoanhThu(String maHD, Date ngay, double tongTien) {
        this.maHD = maHD;
        this.ngay = ngay;
        this.tongTien = tongTien;
    }

    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }

    public Date getNgay() { return ngay; }
    public void setNgay(Date ngay) { this.ngay = ngay; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
}