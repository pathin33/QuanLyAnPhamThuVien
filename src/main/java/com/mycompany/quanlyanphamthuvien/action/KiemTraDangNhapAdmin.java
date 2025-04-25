
package com.mycompany.quanlyanphamthuvien.action;

import com.mycompany.quanlyanphamthuvien.entity.Admin;
import java.util.List;
import java.util.ArrayList;
public class KiemTraDangNhapAdmin {
    public boolean checkDangNhapAdmin(Admin admin){
        if(admin!=null){
            if("admin".equalsIgnoreCase(admin.getTenDangNhap())&&
                    "admin".equalsIgnoreCase(admin.getMatKhau()))
                return true;
        }
        return false;
    }
}

