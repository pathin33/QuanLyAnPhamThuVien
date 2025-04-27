
package com.mycompany.quanlyanphamthuvien.controller;

import com.mycompany.quanlyanphamthuvien.action.QuanLyTapChi;
import com.mycompany.quanlyanphamthuvien.entity.TapChi;
import com.mycompany.quanlyanphamthuvien.view.QLtapchi;
import java.util.ArrayList;


public class TapChiController {
    private QLtapchi qlTapChiView ;
    private QuanLyTapChi qlTapChi;

    public TapChiController(QLtapchi qlTapChiView) {
        this.qlTapChi = new QuanLyTapChi();
        this.qlTapChiView = qlTapChiView;
    }
    
    public void bangTapChi(){
        ArrayList<TapChi> tapChi = new ArrayList<>();
        tapChi = qlTapChi.docDanhSachTapChi();
        qlTapChiView.setVisible(true);
        qlTapChiView.khoiTaoBangTapChi(tapChi);
    }
}
