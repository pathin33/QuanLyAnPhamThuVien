
package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.Admin;
import java.util.List;
import java.util.ArrayList;

public class KiemTraDangNhapAdmin {

    private List<Admin> danhSachAdmin;
    public KiemTraDangNhapAdmin() {
        danhSachAdmin = new ArrayList<>();
        danhSachAdmin.add(new Admin("admin", "123456"));
    }

    public boolean kiemTraDangNhap(String tenDangNhap, String matKhau) {
        for (Admin admin : danhSachAdmin) {
            if (admin.getTenDangNhap().equals(tenDangNhap) &&
                admin.getMatKhau().equals(matKhau)) {
                return true;
            }
        }
        return false;
    }
}
