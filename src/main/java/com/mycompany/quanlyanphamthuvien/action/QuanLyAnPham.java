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
        // Đọc danh sách hiện có từ file
        ArrayList<AnPham> danhSachHienCo = docDanhSachAnPham();

        // Thêm đối tượng mới vào danh sách
        danhSachHienCo.add(anPhammoi);

        // Ghi lại toàn bộ danh sách
        ghiDanhSachAnPham(danhSachHienCo);

        // Cập nhật danh sách trong memory
        this.qlAnPham = danhSachHienCo;
    }

    public boolean xoaDtVaoDsAnPham(AnPham anPhamxoa) {
        ArrayList<AnPham> danhSachHienCo = docDanhSachAnPham();
        boolean result = false;

        for (int i = 0; i < danhSachHienCo.size(); i++) {
            if (danhSachHienCo.get(i).getID().equals(anPhamxoa.getID())) {
                danhSachHienCo.remove(i);
                result = true;
                break;
            }
        }

        if (result) {
            ghiDanhSachAnPham(danhSachHienCo);
            this.qlAnPham = danhSachHienCo;
        }

        return result;
    }

    public void suaDtDsAnPham(AnPham anPhamsua) {
        // Đọc danh sách hiện có từ file
        ArrayList<AnPham> danhSachHienCo = docDanhSachAnPham();
        boolean daSua = false;

        for (int i = 0; i < danhSachHienCo.size(); i++) {
            AnPham anPhamHienTai = danhSachHienCo.get(i);

            if (anPhamHienTai.getID().equals(anPhamsua.getID())) {
                // Cập nhật thông tin chung từ lớp AnPham
                anPhamHienTai.setTenAnPham(anPhamsua.getTenAnPham());
                anPhamHienTai.setSoLuong(anPhamsua.getSoLuong());
                anPhamHienTai.setNamXuatBan(anPhamsua.getNamXuatBan());
                anPhamHienTai.setNhaXuatBan(anPhamsua.getNhaXuatBan());
                anPhamHienTai.setGiaTien(anPhamsua.getGiaTien());

                // Xử lý riêng cho từng loại ấn phẩm
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
            // Ghi lại toàn bộ danh sách đã cập nhật
            ghiDanhSachAnPham(danhSachHienCo);
            // Cập nhật danh sách trong memory
            this.qlAnPham = danhSachHienCo;
        }
    }

    /**
     * Tìm kiếm ấn phẩm theo tên (tìm gần đúng, không phân biệt hoa thường)
     *
     * @param ten Tên hoặc một phần tên cần tìm
     * @return Danh sách ấn phẩm có tên chứa chuỗi tìm kiếm
     */
    public ArrayList<AnPham> timKiemTheoTen(String ten) {
        ArrayList<AnPham> ketQua = new ArrayList<>();

        for (AnPham anPham : qlAnPham) {
            if (anPham.getTenAnPham().toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(anPham);
            }
        }
        return ketQua;
    }

    /**
     * Tìm kiếm ấn phẩm theo khoảng giá tiền
     *
     * @param giaMin Giá tối thiểu (null nếu không giới hạn)
     * @param giaMax Giá tối đa (null nếu không giới hạn)
     * @return Danh sách ấn phẩm có giá trong khoảng chỉ định
     */
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

    /**
     * Tìm kiếm ấn phẩm theo ID (tìm chính xác)
     *
     * @param id ID cần tìm
     * @return Danh sách ấn phẩm có ID trùng khớp
     */
    public ArrayList<AnPham> timKiemTheoID(String id) {
        ArrayList<AnPham> ketQua = new ArrayList<>();

        for (AnPham anPham : qlAnPham) {
            if (anPham.getID().equalsIgnoreCase(id)) {
                ketQua.add(anPham);
            }
        }
        return ketQua;
    }
    public void sapXepNamXuatBanAp(){
        Collections.sort(qlAnPham, new Comparator<AnPham>(){
            @Override
            public int compare(AnPham o1, AnPham o2) {
                return Integer.compare(o1.getNamXuatBan(), o2.getNamXuatBan());
            }
            
        });
    }
    public void sapXepGiaTienAp(){
        Collections.sort(qlAnPham, new Comparator<AnPham>(){
            @Override
            public int compare(AnPham o1, AnPham o2) {
                return Double.compare(o1.getGiaTien(), o2.getGiaTien());
            }
            
        });
    }
}
