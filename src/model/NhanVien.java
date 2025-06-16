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

public class NhanVien {
    private String id_nv;
    private String ten_nv;
    private String dia_chi;
    private String sdt;
    private String vai_tro;
    private Date ngay_vao_lam;

    public NhanVien() {}

    public NhanVien(String id_nv, String ten_nv, String dia_chi, String sdt, String vai_tro, Date ngay_vao_lam) {
        this.id_nv = id_nv;
        this.ten_nv = ten_nv;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.vai_tro = vai_tro;
        this.ngay_vao_lam = ngay_vao_lam;
    }

    public String getId_nv() { return id_nv; }
    public void setId_nv(String id_nv) { this.id_nv = id_nv; }

    public String getTen_nv() { return ten_nv; }
    public void setTen_nv(String ten_nv) { this.ten_nv = ten_nv; }

    public String getDia_chi() { return dia_chi; }
    public void setDia_chi(String dia_chi) { this.dia_chi = dia_chi; }

    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }

    public String getVai_tro() { return vai_tro; }
    public void setVai_tro(String vai_tro) { this.vai_tro = vai_tro; }

    public Date getNgay_vao_lam() { return ngay_vao_lam; }
    public void setNgay_vao_lam(Date ngay_vao_lam) { this.ngay_vao_lam = ngay_vao_lam; }
}
