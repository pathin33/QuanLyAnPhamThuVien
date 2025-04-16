package com.mycompany.quanlyanphamthuvien.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Sach")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sach extends AnPham {

    private String tacGia;
    private String theLoai;

    public Sach() {
        super();
    }

    public Sach(String tacGia, String theLoai, String ID, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien) {
        super(ID, tenAnPham, soLuong, namXuatBan, nhaXuatBan, giaTien);
        this.tacGia = tacGia;
        this.theLoai = theLoai;
    }

    public Sach(String ID, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien) {
        super(ID, tenAnPham, soLuong, namXuatBan, nhaXuatBan, giaTien);
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    @Override
    public void tinhTrang() {
        //tinh trang cua an pham sach
    }

}
