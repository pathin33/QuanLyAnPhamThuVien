package com.mycompany.quanlyanphamthuvien.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TapChi")
@XmlAccessorType(XmlAccessType.FIELD)
public class TapChi extends AnPham {

    @XmlElement(name = "SoPhatHanh")
    private int soPhatHanh;
    @XmlElement(name = "ThangPhatHanh")
    private int thangPhatHanh;
    @XmlElement(name = "ChuyenDe")
    private String chuyenDe;

    public TapChi() {
        super();
    }

    public TapChi(int soPhatHanh, int thangPhatHanh, String chuyenDe, String ID, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien) {
        super(ID, tenAnPham, soLuong, namXuatBan, nhaXuatBan, giaTien);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
        this.chuyenDe = chuyenDe;
    }

    public TapChi(String ID, String tenAnPham, int soLuong, int namXuatBan, String nhaXuatBan, double giaTien) {
        super(ID, tenAnPham, soLuong, namXuatBan, nhaXuatBan, giaTien);
    }

    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

    public String getChuyenDe() {
        return chuyenDe;
    }

    public void setChuyenDe(String chuyenDe) {
        this.chuyenDe = chuyenDe;
    }

    @Override
    public boolean tinhTrang() {
        if (this.getSoLuong() > 1) {
            return true;
        }
        return false;
    }

}
