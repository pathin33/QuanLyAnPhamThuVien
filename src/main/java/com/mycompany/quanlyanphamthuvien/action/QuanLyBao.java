package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.Bao;
import com.mycompany.quanlyanphamthuvien.entity.BaoXML;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;

public class QuanLyBao {

    private ArrayList<Bao> qlBao;
    private QuanLyAnPham qlAnPham;

    public QuanLyBao(QuanLyAnPham qlAnPham) {
        this.qlBao = docDanhSachBao();
        this.qlAnPham = qlAnPham;
        if (qlBao == null) {
            qlBao = new ArrayList<>();
        }
    }

    public QuanLyBao() {
    }

    public QuanLyAnPham getQlAnPham() {
        return qlAnPham;
    }

    public ArrayList<Bao> getQlBao() {
        return qlBao;
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

    public boolean xoaDtVaoDsBao(Bao baoXoa) {
        if (baoXoa == null) {
            return false;
        }
        for (int i = 0; i < qlBao.size(); i++) {
            if (qlBao.get(i).getID() == baoXoa.getID()) {
                qlBao.remove(i);
                qlAnPham.themDtVaoDsAnPham(baoXoa);
                ghiDanhSachBao(qlBao);

                return true;
            }
        }
        return false;
    }

    public void suaDtDsBao(Bao baoSua) {
        for (int i = 0; i < qlBao.size(); i++) {
            if (qlBao.get(i).getID() == baoSua.getID()) {
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

    public void sapxepNambao() {
        Collections.sort(qlBao, (Bao o1, Bao o2) -> Integer.compareUnsigned(o1.getNamXuatBan(), o2.getNamXuatBan()));
    }

    public void sapxepGiabao() {
        Collections.sort(qlBao, (Bao o1, Bao o2) -> Double.compare(o1.getGiaTien(), o2.getGiaTien()));
    }

    public void sapXepTenBao() {
        Collections.sort(qlBao, (Bao b1, Bao b2) -> b1.getTenAnPham().compareToIgnoreCase(b2.getTenAnPham()));
    }

    public ArrayList<Bao> timKiemIDBao(String timKiem) {
        ArrayList<Bao> temp = new ArrayList<>();
        for (Bao bao : qlBao) {
            if (bao.getID().toUpperCase().equalsIgnoreCase(timKiem)) {
                temp.add(bao);
            }
        }
        return temp;
    }

    /**
     * Tìm kiếm báo theo khoảng giá tiền
     *
     * @param giaMin Giá tối thiểu (null nếu không có)
     * @param giaMax Giá tối đa (null nếu không có)
     * @return Danh sách báo thỏa mãn điều kiện
     */
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

    public ArrayList<Bao> tiemKiemTenBao(String timKiem) {
        ArrayList<Bao> temp = new ArrayList<>();
        for (Bao bao : qlBao) {
            if (bao.getTenAnPham().toUpperCase().contains(timKiem.toLowerCase())) {
                temp.add(bao);
            }
        }
        return temp;
    }

    public ArrayList<Bao> tiemKiemgBtvBao(String timKiem) {
        ArrayList<Bao> temp = new ArrayList<>();
        for (Bao bao : qlBao) {
            if (bao.getBienTapVien().toUpperCase().contains(timKiem.toLowerCase())) {
                temp.add(bao);
            }
        }
        return temp;

    }
    public boolean kiemTraTrungID(Bao bao){
       String id = bao.getID();
       for(Bao baoHienCo : qlBao){
           if(baoHienCo.getID().equals(id)){
               return false;
           }
       }
       return true;
    }
}
