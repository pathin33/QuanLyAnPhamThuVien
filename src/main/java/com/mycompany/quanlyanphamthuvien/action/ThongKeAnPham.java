package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.AnPham;
import com.mycompany.quanlyanphamthuvien.entity.Bao;
import com.mycompany.quanlyanphamthuvien.entity.Sach;
import com.mycompany.quanlyanphamthuvien.entity.TapChi;
import java.util.ArrayList;

public class ThongKeAnPham {

    private QuanLyAnPham qlAnPham;
    private ArrayList<AnPham> arrAnPham;

    public ThongKeAnPham() {
        this.qlAnPham = new QuanLyAnPham();
        this.arrAnPham = qlAnPham.docDanhSachAnPham();
    }

    public int soLuongAnPham() {
        return arrAnPham.size();
    }

    public int soLuongSach() {
        return (int) arrAnPham.stream()
                .filter(ap -> ap instanceof Sach)
                .count();
    }

    public int tongSoLuongSach() {
        return arrAnPham.stream()
                .filter(ap -> ap instanceof Sach)
                .mapToInt(AnPham::getSoLuong)
                .sum();
    }
    public int soLuongBao() {
        return (int) arrAnPham.stream()
                .filter(ap -> ap instanceof Bao)
                .count();
    }

    public int tongSoLuongBao() {
        return arrAnPham.stream()
                .filter(ap -> ap instanceof Bao)
                .mapToInt(AnPham::getSoLuong)
                .sum();
    }

    public int soLuongTapChi() {
        return (int) arrAnPham.stream()
                .filter(ap -> ap instanceof TapChi)
                .count();

    }

    public int tongSoLuongTapChi() {
        return arrAnPham.stream()
                .filter(ap -> ap instanceof TapChi)
                .mapToInt(AnPham::getSoLuong)
                .sum();
    }

    public int tongSoLuongTatCa() {
        return arrAnPham.stream()
                .mapToInt(AnPham::getSoLuong)
                .sum();
    }

    public String timLoaiAnPhamNhieuNhat() {
        long soLuongSach = arrAnPham.stream().filter(ap -> ap instanceof Sach).count();
        long soLuongBao = arrAnPham.stream().filter(ap -> ap instanceof Bao).count();
        long soLuongTapChi = arrAnPham.stream().filter(ap -> ap instanceof TapChi).count();

        if (soLuongSach >= soLuongBao && soLuongSach >= soLuongTapChi) {
            return "Book";
        } else if (soLuongBao >= soLuongSach && soLuongBao >= soLuongTapChi) {
            return "Newspaper";
        } else {
            return "Magazine";
        }
    }

    public String timLoaiAnPhamItNhat() {
        long soSach = arrAnPham.stream().filter(ap -> ap instanceof Sach).count();
        long soBao = arrAnPham.stream().filter(ap -> ap instanceof Bao).count();
        long soTapChi = arrAnPham.stream().filter(ap -> ap instanceof TapChi).count();

        if (soSach <= soBao && soSach <= soTapChi) {
            return "Book";
        } else if (soBao <= soSach && soBao <= soTapChi) {
            return "Newspaper";
        } else {
            return "Magazine";
        }
    }
}
