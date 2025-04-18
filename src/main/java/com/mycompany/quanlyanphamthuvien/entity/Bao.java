package com.mycompany.quanlyanphamthuvien.entity;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Bao")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bao extends AnPham {
    @XmlElement(name = "NgayPhatHanh")
    private LocalDate ngayPhatHanh;
    @XmlElement(name = "BienTapVien")
    private String bienTapVien;
     public Bao() {
        super();
    }
    public Bao(LocalDate ngayPhatHanh, String bienTapVien, String ID, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien) {
        super(ID, tenAnPham, soLuong, namXuatBan, nhaXuatBan, giaTien);
        this.ngayPhatHanh = ngayPhatHanh;
        this.bienTapVien = bienTapVien;
    }

    public Bao(String ID, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien) {
        super(ID, tenAnPham, soLuong, namXuatBan, nhaXuatBan, giaTien);
    }

    public LocalDate getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(LocalDate ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getBienTapVien() {
        return bienTapVien;
    }

    public void setBienTapVien(String bienTapVien) {
        this.bienTapVien = bienTapVien;
    }

    @Override
    public void tinhTrang() {
        //tinh trang an pham bao 
    }

}
