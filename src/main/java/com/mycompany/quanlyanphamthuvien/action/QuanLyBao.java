package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.Bao;
import com.mycompany.quanlyanphamthuvien.entity.BaoXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class QuanLyBao {

    private static QuanLyBao instance;
    private QuanLyAnPham qlAnPham;
    private ArrayList<Bao> qlBao;

    public QuanLyBao() {
        this.qlAnPham = new QuanLyAnPham();
        this.qlBao = docDanhSachBao();
        if (qlBao == null) {
            qlBao = new ArrayList<>();
        }
    }

    public static QuanLyBao getInstance() {
        if (instance == null) {
            instance = new QuanLyBao();
        }
        return instance;
    }

    public ArrayList<Bao> getQlBao() {
        return qlBao;
    }

    public QuanLyAnPham getQlAnPham() {
        return qlAnPham;
    }

    public void setQlAnPham(QuanLyAnPham qlAnPham) {
        this.qlAnPham = qlAnPham;
    }

    public void setQlBao(ArrayList<Bao> qlBao) {
        this.qlBao = qlBao;
    }

    public void ghiDanhSachBao(ArrayList<Bao> qlBao) {
        BaoXML baoXML = new BaoXML();
        baoXML.setXmlBao(qlBao);
        FileUtils.writeXMLtoFile("Bao.xml", baoXML);
    }

    public ArrayList<Bao> docDanhSachBao() {
        ArrayList<Bao> listBao = new ArrayList<>();
        BaoXML baoXML = (BaoXML) FileUtils.readXMLFile("Bao.xml", BaoXML.class);
        if (baoXML != null) {
            listBao = new ArrayList<>(baoXML.getXmlBao());
        }
        return listBao;
    }

    public void themDtVaoDsBao(Bao baoMoi) {
        qlBao.add(baoMoi);
        qlAnPham.themDtVaoDsAnPham(baoMoi);
        ghiDanhSachBao(qlBao);
    }

    public boolean xoaBao(String id) {
        qlBao = docDanhSachBao();
        Optional<Bao> baoCanXoa = qlBao.stream()
                .filter(b -> b.getID().equals(id))
                .findFirst();

        if (baoCanXoa.isPresent()) {
            qlBao.remove(baoCanXoa.get());
            ghiDanhSachBao(qlBao);

            if (qlAnPham != null) {
                qlAnPham.xoaDtVaoDsAnPham(baoCanXoa.get());
            }

            return true;
        }
        return false;
    }

    public void suaDtDsBao(Bao baoSua) {
        for (int i = 0; i < qlBao.size(); i++) {
            if (qlBao.get(i).getID().equals(baoSua.getID())) {
                qlBao.get(i).setTenAnPham(baoSua.getTenAnPham());
                qlBao.get(i).setSoLuong(baoSua.getSoLuong());
                qlBao.get(i).setNamXuatBan(baoSua.getNamXuatBan());
                qlBao.get(i).setNhaXuatBan(baoSua.getNhaXuatBan());
                qlBao.get(i).setGiaTien(baoSua.getGiaTien());
                qlBao.get(i).setNgayPhatHanh(baoSua.getNgayPhatHanh());
                qlBao.get(i).setBienTapVien(baoSua.getBienTapVien());
                qlAnPham.suaDtDsAnPham(baoSua);
                ghiDanhSachBao(qlBao);
                break;
            }
        }
    }

    public void sapxepNamBao() {
        qlBao = docDanhSachBao();
        Collections.sort(qlBao, (Bao o1, Bao o2) -> Integer.compareUnsigned(o1.getNamXuatBan(), o2.getNamXuatBan()));
    }

    public void sapxepGiaBao() {
        qlBao = docDanhSachBao();
        Collections.sort(qlBao, (Bao o1, Bao o2) -> Double.compare(o1.getGiaTien(), o2.getGiaTien()));
    }

    public void sapXepTenBao() {
        qlBao = docDanhSachBao();
        Collections.sort(qlBao, (Bao b1, Bao b2) -> b1.getTenAnPham().compareToIgnoreCase(b2.getTenAnPham()));
    }

    public void sapXepSoLuongBao() {
        qlBao = docDanhSachBao();
        Collections.sort(qlBao, (Bao b1, Bao b2) -> Integer.compare(b1.getSoLuong(), b2.getSoLuong()));
    }

    public ArrayList<Bao> timKiemIDBao(String timKiem) {
        ArrayList<Bao> temp = new ArrayList<>();
        for (Bao bao : qlBao) {
            if (bao.getID().equalsIgnoreCase(timKiem)) {
                temp.add(bao);
            }
        }
        return temp;
    }

    public ArrayList<Bao> timKiemTheoGiaTien(Double giaMin, Double giaMax) {
        ArrayList<Bao> ketQua = new ArrayList<>();
        for (Bao bao : qlBao) {
            double gia = bao.getGiaTien();
            boolean thoaDieuKien = true;

            if (giaMin != null && gia < giaMin) {
                thoaDieuKien = false;
            }
            if (giaMax != null && gia > giaMax) {
                thoaDieuKien = false;
            }

            if (thoaDieuKien) {
                ketQua.add(bao);
            }
        }
        return ketQua;
    }

    public ArrayList<Bao> timKiemTenBao(String timKiem) {
        ArrayList<Bao> temp = new ArrayList<>();
        for (Bao bao : qlBao) {
            if (bao.getTenAnPham().toLowerCase().contains(timKiem.toLowerCase())) {
                temp.add(bao);
            }
        }
        return temp;
    }

    public ArrayList<Bao> timKiemBienTapVien(String timKiem) {
        ArrayList<Bao> temp = new ArrayList<>();
        for (Bao bao : qlBao) {
            if (bao.getBienTapVien().toLowerCase().contains(timKiem.toLowerCase())) {
                temp.add(bao);
            }
        }
        return temp;
    }

    public boolean kiemTraTrungID(Bao bao) {
        String id = bao.getID();
        for (Bao baoHienCo : qlBao) {
            if (baoHienCo.getID().equals(id)) {
                return false;
            }
        }
        return true;
    }
}
