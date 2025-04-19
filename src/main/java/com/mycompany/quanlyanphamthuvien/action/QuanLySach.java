package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.Sach;
import com.mycompany.quanlyanphamthuvien.entity.SachXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;

public class QuanLySach {

    private ArrayList<Sach> qlSach;
    private QuanLyAnPham qlAnPham;

    public QuanLySach(QuanLyAnPham qlAnPham) {
        this.qlSach = docDanhSachSach();
        this.qlAnPham = qlAnPham;
        if (qlSach == null) {
            qlSach = new ArrayList<>();
        }
    }

    public QuanLySach() {
    }

    public ArrayList<Sach> getQlSach() {
        return qlSach;
    }

    public void setQlSach(ArrayList<Sach> qlSach) {
        this.qlSach = qlSach;
    }

    public void ghiDanhSachSach(ArrayList<Sach> qlSach) {
        SachXML sachXML = new SachXML();
        sachXML.setXmlSach(qlSach);
        FileUtils.writeXMLtoFile("Sach.xml", sachXML);
    }

    public ArrayList<Sach> docDanhSachSach() {
        ArrayList<Sach> listSach = new ArrayList<>();
        SachXML sachXML = (SachXML) FileUtils.readXMLFile("Sach.xml", SachXML.class);
        if (sachXML != null) {
            listSach = new ArrayList<>(sachXML.getXmlSach());
        }
        return listSach;
    }

    public void themDtVaoDsSach(Sach sachMoi) {
        qlSach.add(sachMoi);
        qlAnPham.themDtVaoDsAnPham(sachMoi);
        ghiDanhSachSach(qlSach);

    }

    public boolean xoaDtVaoDsSach(Sach sachXoa) {
        if (sachXoa == null) {
            return false;
        }
        for (int i = 0; i < qlSach.size(); i++) {
            if (qlSach.get(i).getID() == sachXoa.getID()) {
                qlSach.remove(i);
                qlAnPham.xoaDtVaoDsAnPham(sachXoa);
                ghiDanhSachSach(qlSach);

                return true;
            }
        }
        return false;
    }

    public void suaDtDsSach(Sach sachSua) {
        for (int i = 0; i < qlSach.size(); i++) {
            if (qlSach.get(i).getID() == sachSua.getID()) {
                Sach sachCanSua = qlSach.get(i);

                // Cập nhật các thuộc tính từ lớp cha AnPham
                sachCanSua.setTenAnPham(sachSua.getTenAnPham());
                sachCanSua.setSoLuong(sachSua.getSoLuong());
                sachCanSua.setNamXuatBan(sachSua.getNamXuatBan());
                sachCanSua.setNhaXuatBan(sachSua.getNhaXuatBan());
                sachCanSua.setGiaTien(sachSua.getGiaTien());

                // Cập nhật các thuộc tính riêng của Sách
                sachCanSua.setTacGia(sachSua.getTacGia());
                sachCanSua.setTheLoai(sachSua.getTheLoai());
                qlAnPham.suaDtDsAnPham(sachCanSua);
                ghiDanhSachSach(qlSach);

                break;
            }
        }
    }

    public void sapxepNamsach() {
        Collections.sort(qlSach, (Sach o1, Sach o2) -> Integer.compareUnsigned(o1.getNamXuatBan(), o2.getNamXuatBan()));
    }

    public void sapxepGiasach() {
        Collections.sort(qlSach, (Sach o1, Sach o2) -> Double.compare(o1.getGiaTien(), o2.getGiaTien()));
    }

}
