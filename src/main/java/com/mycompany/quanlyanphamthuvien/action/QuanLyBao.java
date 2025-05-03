package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.Sach;
import com.mycompany.quanlyanphamthuvien.entity.SachXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

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
                sachCanSua.setTenAnPham(sachSua.getTenAnPham());
                sachCanSua.setSoLuong(sachSua.getSoLuong());
                sachCanSua.setNamXuatBan(sachSua.getNamXuatBan());
                sachCanSua.setNhaXuatBan(sachSua.getNhaXuatBan());
                sachCanSua.setGiaTien(sachSua.getGiaTien());
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

    public void sapXepTenSach() {
        Collections.sort(qlSach, (s1, s2) -> s1.getTenAnPham().compareToIgnoreCase(s2.getTenAnPham()));
    }
    public void sapxepSoLuong() {
        Collections.sort(qlSach, (Sach o1, Sach o2) -> Integer.compareUnsigned(o1.getSoLuong(), o2.getSoLuong()));
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

    /**
     * Tìm kiếm sách theo khoảng giá tiền
     *
     * @param giaMin Giá tối thiểu (nếu null thì không giới hạn)
     * @param giaMax Giá tối đa (nếu null thì không giới hạn)
     * @return Danh sách sách thỏa mãn điều kiện
     */
    public ArrayList<Sach> timKiemTheoGiaTien(Double giaMin, Double giaMax) {
        ArrayList<Sach> ketQua = new ArrayList<>();

        for (Sach sach : qlSach) {
            double gia = sach.getGiaTien();

            boolean thoaDieuKien = true;

            // Kiểm tra giá tối thiểu
            if (giaMin != null && gia < giaMin) {
                thoaDieuKien = false;
            }

            // Kiểm tra giá tối đa
            if (giaMax != null && gia > giaMax) {
                thoaDieuKien = false;
            }

            if (thoaDieuKien) {
                ketQua.add(sach);
            }
        }

        return ketQua;
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
     public boolean kiemTraTrungID(Sach sach){
       String id = sach.getID();
       for(Sach sachHienCo : qlSach){
           if(sachHienCo.getID().equals(id)){
               return false;
           }
       }
       return true;
    }
    public Sach getBookAt(int index) {
    ArrayList<Sach> temp = new ArrayList<>();
    if (index >= 0 && index < temp.size()) {
        return temp.get(index);
    }
    return null;
}
public ArrayList<Sach> getListSach() 
    {
        return this.qlSach;
    }

    public boolean xoaSach(String id) {
       qlSach = docDanhSachSach(); // Reload to ensure the list is up-to-date
        Optional<Sach> SachCanXoa = qlSach.stream()
                .filter(s -> s.getID().equals(id))
                .findFirst();

        if (SachCanXoa.isPresent()) {
            qlSach.remove(SachCanXoa.get());
            ghiDanhSachSach(qlSach);
            if (qlAnPham != null) {
                qlAnPham.xoaDtVaoDsAnPham(SachCanXoa.get());
            }

            return true;
        }
        return false;
    }
}
