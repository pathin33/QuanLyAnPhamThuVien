package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.TapChi;
import com.mycompany.quanlyanphamthuvien.entity.TapChiXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;

public class QuanLyTapChi {

    private QuanLyAnPham qlAnPham;

    private ArrayList<TapChi> qlTapChi;

    public ArrayList<TapChi> getQlTapChi() {
        return qlTapChi;
    }

    public QuanLyTapChi(QuanLyAnPham qlAnPham) {
        this.qlAnPham = qlAnPham;
        this.qlTapChi = docDanhSachTapChi();
        if (qlTapChi == null) {
            qlTapChi = new ArrayList<>();
        }
    }

    public QuanLyTapChi() {
    }

    public QuanLyAnPham getQlAnPham() {
        return qlAnPham;
    }

    public void setQlTapChi(ArrayList<TapChi> qlTapChi) {
        this.qlTapChi = qlTapChi;
    }

    public void ghiDanhSachTapChi(ArrayList<TapChi> qlTapChi) {
        TapChiXML tapChiXML = new TapChiXML();
        tapChiXML.setXmlTapChi(qlTapChi);
        FileUtils.writeXMLtoFile("TapChi.xml", tapChiXML);
    }

    public ArrayList<TapChi> docDanhSachTapChi() {
        ArrayList<TapChi> listTapChi = new ArrayList<>();
        TapChiXML tapChiXML = (TapChiXML) FileUtils.readXMLFile("TapChi.xml", TapChiXML.class);
        if (tapChiXML != null) {
            listTapChi = new ArrayList<>(tapChiXML.getXmlTapChi());
        }
        return listTapChi;
    }

    public void themDtVaoDsTapChi(TapChi tapChiMoi) {
        qlTapChi.add(tapChiMoi);
        qlAnPham.themDtVaoDsAnPham(tapChiMoi);
        ghiDanhSachTapChi(qlTapChi);
    }

    public boolean xoaDtVaoDsTapChi(TapChi tapChiXoa) {
        if (tapChiXoa == null) {
            return false;
        }
        for (int i = 0; i < qlTapChi.size(); i++) {
            if (qlTapChi.get(i).getID() == tapChiXoa.getID()) {
                qlTapChi.remove(i);
                qlAnPham.xoaDtVaoDsAnPham(tapChiXoa);
                ghiDanhSachTapChi(qlTapChi);
                return true;
            }
        }
        return false;
    }

    public void suaDtDsTapChi(TapChi tapChiSua) {
        for (int i = 0; i < qlTapChi.size(); i++) {
            if (qlTapChi.get(i).getID() == tapChiSua.getID()) {
                // Các thuộc tính chung từ lớp cha AnPham
                qlTapChi.get(i).setTenAnPham(tapChiSua.getTenAnPham());
                qlTapChi.get(i).setSoLuong(tapChiSua.getSoLuong());
                qlTapChi.get(i).setNamXuatBan(tapChiSua.getNamXuatBan());
                qlTapChi.get(i).setNhaXuatBan(tapChiSua.getNhaXuatBan());
                qlTapChi.get(i).setGiaTien(tapChiSua.getGiaTien());

                // Các thuộc tính riêng của TapChi
                qlTapChi.get(i).setSoPhatHanh(tapChiSua.getSoPhatHanh());
                qlTapChi.get(i).setThangPhatHanh(tapChiSua.getThangPhatHanh());
                qlTapChi.get(i).setChuyenDe(tapChiSua.getChuyenDe());

                // Ghi lại danh sách sau khi sửa
                qlAnPham.suaDtDsAnPham(tapChiSua);

                ghiDanhSachTapChi(qlTapChi);
                break;
            }
        }
    }

    public void sapxepNamtapchi() {
        Collections.sort(qlTapChi, (TapChi o1, TapChi o2) -> Integer.compareUnsigned(o1.getNamXuatBan(), o2.getNamXuatBan()));
    }

    public void sapxepGiatapchi() {
        Collections.sort(qlTapChi, (TapChi o1, TapChi o2) -> Double.compare(o1.getGiaTien(), o2.getGiaTien()));
    }

    public void sapXepTenTapChi() {
        Collections.sort(qlTapChi, (TapChi t1, TapChi t2) -> t1.getTenAnPham().compareToIgnoreCase(t2.getTenAnPham()));
    }

    public ArrayList<TapChi> timKiemIDTapChi(String timKiem) {
        ArrayList<TapChi> temp = new ArrayList<>();
        for (TapChi sach : qlTapChi) {
            if (sach.getID().equalsIgnoreCase(timKiem)) {
                temp.add(sach);
            }
        }
        return temp;
    }

    /**
     * Tìm kiếm tạp chí theo khoảng giá tiền
     *
     * @param giaMin Giá tối thiểu (null nếu không có)
     * @param giaMax Giá tối đa (null nếu không có)
     * @return Danh sách tạp chí thỏa mãn điều kiện
     */
    public ArrayList<TapChi> timKiemTheoGiaTien(Double giaMin, Double giaMax) {
        ArrayList<TapChi> ketQua = new ArrayList<>();

        for (TapChi tapChi : qlTapChi) {
            double gia = tapChi.getGiaTien();
            boolean thoaDieuKien = true;

            if (giaMin != null && gia < giaMin) {
                thoaDieuKien = false;
            }
            if (giaMax != null && gia > giaMax) {
                thoaDieuKien = false;
            }

            if (thoaDieuKien) {
                ketQua.add(tapChi);
            }
        }
        return ketQua;
    }

    public ArrayList<TapChi> timKiemTenTapChi(String timKiem) {
        ArrayList<TapChi> temp = new ArrayList<>();
        for (TapChi sach : qlTapChi) {
            if (sach.getTenAnPham().toLowerCase().contains(timKiem.toLowerCase())) {
                temp.add(sach);
            }
        }
        return temp;
    }

    public ArrayList<TapChi> timKiemChuyenDeTapChi(String timKiem) {
        ArrayList<TapChi> temp = new ArrayList<>();
        for (TapChi sach : qlTapChi) {
            if (sach.getChuyenDe().toLowerCase().contains(timKiem.toLowerCase())) {
                temp.add(sach);
            }
        }
        return temp;
    }

    public boolean kiemTraTrungID(TapChi tapChi) {
        String id = tapChi.getID();
        for (TapChi tapChiHienCo : qlTapChi) {
            if (tapChiHienCo.getID().equals(id)) {
                return false;
            }
        }
        return true;
    }

}
