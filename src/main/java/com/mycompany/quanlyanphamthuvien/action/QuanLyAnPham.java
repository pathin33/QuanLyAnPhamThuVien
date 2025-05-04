package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.AnPham;
import com.mycompany.quanlyanphamthuvien.entity.AnPhamXML;
import com.mycompany.quanlyanphamthuvien.entity.Bao;
import com.mycompany.quanlyanphamthuvien.entity.Sach;
import com.mycompany.quanlyanphamthuvien.entity.TapChi;
import com.mycompany.quanlyanphamthuvien.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyAnPham {

    private ArrayList<AnPham> qlAnPham;

    public QuanLyAnPham() {
        this.qlAnPham = docDanhSachAnPham();
        if (this.qlAnPham == null) {
            this.qlAnPham = new ArrayList<>();
        }
    }

    public ArrayList<AnPham> getQlAnPham() {
        return qlAnPham;
    }

    public void setQlAnPham(ArrayList<AnPham> qlAnPham) {
        this.qlAnPham = qlAnPham;
    }

    public void ghiDanhSachAnPham(ArrayList<AnPham> qlAnPham) {
        AnPhamXML anPhamXML = new AnPhamXML();
        anPhamXML.setXmlAnPham(qlAnPham);
        FileUtils.writeXMLtoFile("AnPham.xml", anPhamXML);
    }

    public ArrayList<AnPham> docDanhSachAnPham() {
        ArrayList<AnPham> listAnPham = new ArrayList<>();
        AnPhamXML anPhamXML = (AnPhamXML) FileUtils.readXMLFile("AnPham.xml", AnPhamXML.class);

        if (anPhamXML != null) {
            listAnPham = new ArrayList<>(anPhamXML.getXmlAnPham());
        }
        return listAnPham;
    }

    public void themDtVaoDsAnPham(AnPham anPhammoi) {

        ArrayList<AnPham> danhSachHienCo = docDanhSachAnPham();

        danhSachHienCo.add(anPhammoi);

        ghiDanhSachAnPham(danhSachHienCo);

        this.qlAnPham = danhSachHienCo;
    }

    public boolean xoaDtVaoDsAnPham(AnPham anPhamXoa) {
        if (anPhamXoa == null) {
            return false;
        }

        ArrayList<AnPham> danhSachHienCo = docDanhSachAnPham();
        boolean daXoa = false;

        for (int i = 0; i < danhSachHienCo.size(); i++) {
            if (danhSachHienCo.get(i).getID().equals(anPhamXoa.getID())) {
                danhSachHienCo.remove(i);
                daXoa = true;
                break;
            }
        }

        if (daXoa) {

            ghiDanhSachAnPham(danhSachHienCo);

            this.qlAnPham = danhSachHienCo;
        }

        return daXoa;
    }

    public void suaDtDsAnPham(AnPham anPhamsua) {

        ArrayList<AnPham> danhSachHienCo = docDanhSachAnPham();
        boolean daSua = false;

        for (int i = 0; i < danhSachHienCo.size(); i++) {
            AnPham anPhamHienTai = danhSachHienCo.get(i);

            if (anPhamHienTai.getID().equals(anPhamsua.getID())) {

                anPhamHienTai.setTenAnPham(anPhamsua.getTenAnPham());
                anPhamHienTai.setSoLuong(anPhamsua.getSoLuong());
                anPhamHienTai.setNamXuatBan(anPhamsua.getNamXuatBan());
                anPhamHienTai.setNhaXuatBan(anPhamsua.getNhaXuatBan());
                anPhamHienTai.setGiaTien(anPhamsua.getGiaTien());

                if (anPhamsua instanceof Sach && anPhamHienTai instanceof Sach) {
                    Sach sachSua = (Sach) anPhamsua;
                    Sach sachHienTai = (Sach) anPhamHienTai;
                    sachHienTai.setTacGia(sachSua.getTacGia());
                    sachHienTai.setTheLoai(sachSua.getTheLoai());
                } else if (anPhamsua instanceof Bao && anPhamHienTai instanceof Bao) {
                    Bao baoSua = (Bao) anPhamsua;
                    Bao baoHienTai = (Bao) anPhamHienTai;
                    baoHienTai.setNgayPhatHanh(baoSua.getNgayPhatHanh());
                    baoHienTai.setBienTapVien(baoSua.getBienTapVien());
                } else if (anPhamsua instanceof TapChi && anPhamHienTai instanceof TapChi) {
                    TapChi tapChiSua = (TapChi) anPhamsua;
                    TapChi tapChiHienTai = (TapChi) anPhamHienTai;
                    tapChiHienTai.setSoPhatHanh(tapChiSua.getSoPhatHanh());
                    tapChiHienTai.setThangPhatHanh(tapChiSua.getThangPhatHanh());
                    tapChiHienTai.setChuyenDe(tapChiSua.getChuyenDe());
                }

                daSua = true;
                break;
            }
        }

        if (daSua) {
    
            ghiDanhSachAnPham(danhSachHienCo);
  
            this.qlAnPham = danhSachHienCo;
        }
    }

   
    public ArrayList<AnPham> timKiemTheoTen(String ten) {
        ArrayList<AnPham> ketQua = new ArrayList<>();

        for (AnPham anPham : qlAnPham) {
            if (anPham.getTenAnPham().toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(anPham);
            }
        }
        return ketQua;
    }

 
    public ArrayList<AnPham> timKiemTheoGiaTien(Double giaMin, Double giaMax) {
        ArrayList<AnPham> ketQua = new ArrayList<>();

        for (AnPham anPham : qlAnPham) {
            double gia = anPham.getGiaTien();
            boolean thoaDieuKien = true;

            if (giaMin != null && gia < giaMin) {
                thoaDieuKien = false;
            }
            if (giaMax != null && gia > giaMax) {
                thoaDieuKien = false;
            }

            if (thoaDieuKien) {
                ketQua.add(anPham);
            }
        }
        return ketQua;
    }

 
    public ArrayList<AnPham> timKiemTheoID(String id) {
        ArrayList<AnPham> ketQua = new ArrayList<>();

        for (AnPham anPham : qlAnPham) {
            if (anPham.getID().equalsIgnoreCase(id)) {
                ketQua.add(anPham);
            }
        }
        return ketQua;
    }

    public void sapXepNamXuatBanAp() {
        Collections.sort(qlAnPham, new Comparator<AnPham>() {
            @Override
            public int compare(AnPham o1, AnPham o2) {
                return Integer.compare(o1.getNamXuatBan(), o2.getNamXuatBan());
            }

        });
    }

    public void sapXepGiaTienAp() {
        Collections.sort(qlAnPham, new Comparator<AnPham>() {
            @Override
            public int compare(AnPham o1, AnPham o2) {
                return Double.compare(o1.getGiaTien(), o2.getGiaTien());
            }

        });
    }

    public void sapXepTenAnPham() {
        Collections.sort(qlAnPham, new Comparator<AnPham>() {
            @Override
            public int compare(AnPham o1, AnPham o2) {
                return o1.getTenAnPham().compareToIgnoreCase(o2.getTenAnPham());
            }
        });
    }

}
