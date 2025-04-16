package com.mycompany.quanlyanphamthuvien.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "AnPham")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Sach.class, TapChi.class,Bao.class})
public abstract class AnPham {

    private String ID;
    private String tenAnPham;
    private int soLuong;
    private int namXuatBan;
    private String nhaXuatBan;
    private double giaTien;

    public AnPham() {
    }

    public AnPham(String ID, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien) {
        this.ID = ID;
        this.tenAnPham = tenAnPham;
        this.soLuong = soLuong;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
        this.giaTien = giaTien;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenAnPham() {
        return tenAnPham;
    }

    public void setTenAnPham(String tenAnPham) {
        this.tenAnPham = tenAnPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public abstract void tinhTrang();
}
