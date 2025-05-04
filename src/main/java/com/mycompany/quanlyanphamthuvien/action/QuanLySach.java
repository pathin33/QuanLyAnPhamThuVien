package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.Sach;
import com.mycompany.quanlyanphamthuvien.entity.SachXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class QuanLySach {

    private static QuanLySach instance;
    private QuanLyAnPham qlAnPham;
    private ArrayList<Sach> qlSach;

    public QuanLySach() {
        this.qlAnPham = new QuanLyAnPham();
        this.qlSach = docDanhSachSach();
        if (qlSach == null) {
            qlSach = new ArrayList<>();
        }
    }

    public static QuanLySach getInstance() {
        if (instance == null) {
            instance = new QuanLySach();
        }
        return instance;
    }

    public ArrayList<Sach> getQlSach() {
        return qlSach;
    }

    public QuanLyAnPham getQlAnPham() {
        return qlAnPham;
    }

    public void setQlAnPham(QuanLyAnPham qlAnPham) {
        this.qlAnPham = qlAnPham;
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

    public boolean xoaSach(String id) {
        qlSach = docDanhSachSach(); 
        Optional<Sach> sachCanXoa = qlSach.stream()
                .filter(s -> s.getID().equals(id))
                .findFirst();

        if (sachCanXoa.isPresent()) {
            qlSach.remove(sachCanXoa.get());
            ghiDanhSachSach(qlSach);

            if (qlAnPham != null) {
                qlAnPham.xoaDtVaoDsAnPham(sachCanXoa.get());
            }

            return true;
        }
        return false;
    }

    public void suaDtDsSach(Sach sachSua) {
        for (int i = 0; i < qlSach.size(); i++) {
            if (qlSach.get(i).getID().equals(sachSua.getID())) {
                qlSach.get(i).setTenAnPham(sachSua.getTenAnPham());
                qlSach.get(i).setSoLuong(sachSua.getSoLuong());
                qlSach.get(i).setNamXuatBan(sachSua.getNamXuatBan());
                qlSach.get(i).setNhaXuatBan(sachSua.getNhaXuatBan());
                qlSach.get(i).setGiaTien(sachSua.getGiaTien());
                qlSach.get(i).setTacGia(sachSua.getTacGia());
                qlSach.get(i).setTheLoai(sachSua.getTheLoai());
                qlAnPham.suaDtDsAnPham(sachSua);
                ghiDanhSachSach(qlSach);
                break;
            }
        }
    }

    public void sapxepNamsach() {
        qlSach = docDanhSachSach();
        Collections.sort(qlSach, (Sach o1, Sach o2) -> Integer.compareUnsigned(o1.getNamXuatBan(), o2.getNamXuatBan()));
    }

    public void sapXepSoLuongSach() {
        qlSach = docDanhSachSach();
        Collections.sort(qlSach, (Sach o1, Sach o2) -> Integer.compare(o1.getSoLuong(), o2.getSoLuong()));
    }

    public void sapxepGiasach() {
        qlSach = docDanhSachSach();
        Collections.sort(qlSach, (Sach o1, Sach o2) -> Double.compare(o1.getGiaTien(), o2.getGiaTien()));
    }

    public void sapXepTenSach() {
        qlSach = docDanhSachSach();
        Collections.sort(qlSach, (Sach s1, Sach s2) -> s1.getTenAnPham().compareToIgnoreCase(s2.getTenAnPham()));
    }

    public ArrayList<Sach> timKiemIDSach(String timKiem) {
        ArrayList<Sach> temp = new ArrayList<>();
        for (Sach sach : qlSach) {
            if (sach.getID().equalsIgnoreCase(timKiem)) {
                temp.add(sach);
            }
        }
        return temp;
    }

    public ArrayList<Sach> timKiemTenSach(String timKiem) {
        ArrayList<Sach> temp = new ArrayList<>();
        for (Sach sach : qlSach) {
            if (sach.getTenAnPham().toLowerCase().contains(timKiem.toLowerCase())) {
                temp.add(sach);
            }
        }
        return temp;
    }

    public ArrayList<Sach> timKiemTacGiaSach(String timKiem) {
        ArrayList<Sach> temp = new ArrayList<>();
        for (Sach sach : qlSach) {
            if (sach.getTacGia().toLowerCase().contains(timKiem.toLowerCase())) {
                temp.add(sach);
            }
        }
        return temp;
    }

    public ArrayList<Sach> timKiemTheLoaiSach(String timKiem) {
        ArrayList<Sach> temp = new ArrayList<>();
        for (Sach sach : qlSach) {
            if (sach.getTheLoai().toLowerCase().contains(timKiem.toLowerCase())) {
                temp.add(sach);
            }
        }
        return temp;
    }

    public ArrayList<Sach> timKiemTheoGiaTien(Double giaMin, Double giaMax) {
        ArrayList<Sach> ketQua = new ArrayList<>();
        for (Sach sach : qlSach) {
            double gia = sach.getGiaTien();
            boolean thoaDieuKien = true;
            if (giaMin != null && gia < giaMin) {
                thoaDieuKien = false;
            }
            if (giaMax != null && gia > giaMax) {
                thoaDieuKien = false;
            }
            if (thoaDieuKien) {
                ketQua.add(sach);
            }
        }
        return ketQua;
    }

    public boolean kiemTraTrungID(Sach sach) {
        String id = sach.getID();
        for (Sach sachHienCo : qlSach) {
            if (sachHienCo.getID().equals(id)) {
                return false;
            }
        }
        return true;
    }
}
